package com.univ;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.univ.bean.Product;
import com.univ.repository.ProductRepository;
import com.univ.bean.Customer;
import com.univ.bean.Order;
import com.univ.services.OrderServices;
import com.univ.services.ProductServices;
import com.univ.services.UserServices;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDate;

@Controller
@RequestMapping("/user")
public class UserController {

	HttpSession cartSession;
	@Autowired
	private UserServices userServ;

	@Autowired
	private ProductServices proserv;

	@Autowired
	private OrderServices orderServ;
	
	@Autowired
	private ProductRepository proRepo;
	
	@GetMapping("/")
	public String userindex1() {
		return "user/user_index";
	}
//	
//	@GetMapping("/user_index")
//	public String userindex2() {
//		return "user/user_index";
//	}

	@RequestMapping("/user_index")
	public String userindex(Model model,HttpServletRequest request) {

		HttpSession hs = request.getSession(false);
		String uname = (String) hs.getAttribute("sname");
		System.out.println(uname);
		List<Product> pro = proserv.statusOne(1); // System.out.println(pro); 
//		System.out.println("123");
		List<Product> menProducts = new ArrayList<>();
		List<Product> womenProducts = new ArrayList<>();
		List<Product> kidProducts = new ArrayList<>();
		for (Product prod : pro) {
			String ty = prod.getType();
			System.out.println(ty);
			if (ty.equals("Men's")) {
//				System.out.println(prod);
				menProducts.add(prod);
				// System.out.println("abc");
			}
			if (ty.equals("Women's")) {
//				System.out.println(prod);
				womenProducts.add(prod);
				// System.out.println("abc");
			}
			if (ty.equals("Kid's")) {
//				System.out.println(prod);
				kidProducts.add(prod);
				// System.out.println("abc");
			}
		}
		model.addAttribute("mproducts", menProducts);
		model.addAttribute("wproducts", womenProducts);
		model.addAttribute("kproducts", kidProducts);

		return "user/user_index";

	}

	@GetMapping("/signout")
	public String signOut(HttpSession session) {
//			session.setAttribute("name", "");
		// Invalidate the session to clear all attributes
		session.invalidate();
		// Redirect to the main index page
		return "redirect:/index";
	}

	@GetMapping("user_profile")
	public String prof(Model model, HttpServletRequest request) {
		HttpSession hs = request.getSession(false);
		String uname = (String) hs.getAttribute("sname");
//		 	System.out.println(uname);
		Customer usr = userServ.profileCheck(uname);
//			System.out.println(usr);
		model.addAttribute("user", usr);
		return "user/user_profile";
	}

	@RequestMapping("user_profile")
	public String profile(Model model, HttpServletRequest request) {
		String action1 = request.getParameter("profile");
		String action2 = request.getParameter("password");
		if ("Edit Profile".equals(action1)) {
			return "user/edit_profile";
		}
		if ("Change Password".equals(action2)) {
			return "user/change_password";
		}
		return null;
	}

	@RequestMapping("edit_profile")
	public String edit(HttpServletRequest request, @RequestParam("phone") String phone,
			@RequestParam("address") String address, @RequestParam("email") String email,
			@RequestParam("city") String city) {

		HttpSession hs = request.getSession(false);
		String uname = (String) hs.getAttribute("sname");
//		System.out.println(uname);

		userServ.updateProfile(uname, Long.parseLong(phone), email, address, city);
		return "user/user_index";

	}

	@RequestMapping("change_password")
	public String change(HttpServletRequest request, @RequestParam("old") String password_Original,
			@RequestParam("new1") String password_New1, @RequestParam("new2") String password_New2) {
		HttpSession hs = request.getSession(false);
		String uname = (String) hs.getAttribute("sname");
//		System.out.println(uname);
		Customer user = userServ.profileCheck(uname);
		String oldPass = user.getPassword();
		if (oldPass.equals(password_Original) && password_New1.equals(password_New2)) {
			userServ.changePassword(uname, password_New1);
			return "user/user_index";
		} else {
			return "user/change_password";
		}

	}
	

	@RequestMapping("/addtocart") public String cart(HttpServletRequest
	  request,@RequestParam("productId")String productId,Model model) { 
		String action1 =request.getParameter("addtocart"); 
		if ("Add to Cart".equals(action1)) {
		cartSession=request.getSession(true);
			  
	//	   hs2=request.getSession(true); //create new session
		 List<Integer> proList=(List<Integer>) cartSession.getAttribute("pid");
		  if (proList == null) {
		        proList = new ArrayList<>();
//		        System.out.println(productId); 
		        cartSession.setAttribute("pid", proList);
		    }
		// Add the new product ID to the list
	        try {
	            int productIdInt = Integer.parseInt(productId);
	            if (!proList.contains(productIdInt)) { // Avoid duplicate entries
	                proList.add(productIdInt);
	            }
	        } catch (NumberFormatException e) {
	            model.addAttribute("error", "Invalid product ID");
	            return "/error"; // Redirect to an error page if needed
	        }

		  return "redirect:/user/user_index"; 
	  }
	
	  return null; 
	  }
	
	@RequestMapping("cartt")
	public String cartt(Model model,HttpSession session) {

        List<Integer> proList = (List<Integer>) session.getAttribute("pid");

        if (proList == null || proList.isEmpty()) {
            model.addAttribute("cartEmpty", true);
            return "user/cart";
        }
        model.addAttribute("cartEmpty", false);

        // Fetch products based on IDs
        List<Product> products = proserv.getProducts(proList);

        model.addAttribute("products", products);
        session.setAttribute("products", products); // ✅ FIXED: Don't overwrite "pid"

        return "user/cart"; // Render the cart view
    }

	
	@RequestMapping("/orderPage")
	public String orderPage(HttpServletRequest request, HttpSession session) {
	    Order order = new Order();
	    int totalPrice = 0;

	    String action = request.getParameter("placeOrder");

	    if ("Place Order".equals(action)) {
	        order.setUser_name((String) session.getAttribute("sname"));

	        // Retrieve selected product IDs
	        String[] productIds = request.getParameterValues("productIds");
	        String[] quantities = request.getParameterValues("quantities");

	        List<Integer> orderIds = new ArrayList<>();
	        List<Integer> quantityList = new ArrayList<>();

	        if (productIds != null && quantities != null) {
	            for (int i = 0; i < productIds.length; i++) {
	                int pid = Integer.parseInt(productIds[i]);
	                int qty = Integer.parseInt(quantities[i]);

	                orderIds.add(pid);
	                quantityList.add(qty);

	                // Fetch product price from DB (assuming you have a ProductService)
	                Optional<Product> product = proRepo.findById(pid);
	                totalPrice += product.get().getPrice() * qty;  // Price * Quantity
	            }
	        }

	        order.setProductIds(orderIds);
	        order.setOrder_date(new Date());
	        order.setTotal_price(totalPrice); // Save calculated total price

	        orderServ.saveOrder(order);  // Save order in DB

	        return "user/payment";
	    }
	    return "redirect:/userCart";
	}

	@RequestMapping("/payment")
	public String pay(Model model, HttpServletRequest request) {
		String action = request.getParameter("paymentMethod");
		String action2 = request.getParameter("proceed");
		if (action2 == null || action2.isEmpty()) {
		    model.addAttribute("error", "Please select a payment method.");
		    return "user/payment_form"; // Redirect back to the form
		}

		if ("UPI".equals(action) && "Proceed".equals(action2)) {
			cartSession.setAttribute("pay", "done");
			return "redirect:https://pay.google.com/";
		}
		if ("COD".equals(action)&& "Proceed".equals(action2)) {
			cartSession.setAttribute("pay", "pending");
			return "user/order_confirm";
		}
		return null;
	}
}
