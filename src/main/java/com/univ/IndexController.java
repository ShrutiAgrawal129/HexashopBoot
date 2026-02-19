package com.univ;

import java.util.ArrayList;
import java.util.List;

//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.univ.bean.Product;
import com.univ.bean.Customer;
import com.univ.services.ProductServices;
import com.univ.services.UserServices;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class IndexController {
	@Autowired
	private UserServices usersr;

	@Autowired
	private ProductServices proserv;


	HttpSession hs = null;

	@RequestMapping("/")
	public String go() {
		return "index";
	}

	@RequestMapping("/index")
	public String go2() {
		return "index";
	}

	@RequestMapping("/about")
	public String about() {
		return "about";
	}

	@RequestMapping("/contact")
	public String contact() {
		return "contact";
	}

	@RequestMapping("/products")
	public String products() {
		return "products";
	}

	@RequestMapping("/singleproduct")
	public String singleproduct() {
		return "singleproduct";
	}

	@GetMapping("/reg")
	public String showRegistrationForm() {
		return "reg";
	}

	@PostMapping("/reg")
	public String addSubject(Customer user) {
//		user.setPassword(encoder.encode(user.getPassword()));
		usersr.saveUser(user);
		return "logIn";
	}

	@GetMapping("/logIn")
	public String showLogInForm(HttpServletRequest request) {
		hs = request.getSession(false);
		if (hs != null) // old session check
		{
			hs.invalidate();
			hs = null;
			return "logIn";
		} else {
			return "logIn";
		}
	}

	@PostMapping("/logIn")
	public String checkUser(@RequestParam("name") String name, @RequestParam("password") String password,
			HttpServletRequest request, Model model) {

		hs = request.getSession(false);
		if (hs != null) // check old session
		{
			hs.invalidate();
			hs = null;
		}

		hs = request.getSession(true); // create new session

	   
//	  UserDetails s= adminServ.loadUserByUsername(name);
//		boolean t = true;
		boolean t = usersr.check(name, password);
		if (t) {
			hs.setAttribute("sname", name);
			List<Product> allProducts = proserv.statusOne(1);
			List<Product> mensProducts = new ArrayList<>();
			List<Product> womensProducts = new ArrayList<>();
			List<Product> kidsProducts = new ArrayList<>();

			for (Product product : allProducts) {
				if ("Men's".equals(product.getType())) {
					mensProducts.add(product);
				}
				if ("Women's".equals(product.getType())) {
					womensProducts.add(product);
				}
				if ("Kid's".equals(product.getType())) {
					kidsProducts.add(product);
				}
			}

			if (!mensProducts.isEmpty()) {
				model.addAttribute("mproducts", mensProducts);
			}
			if (!womensProducts.isEmpty()) {
				model.addAttribute("wproducts", womensProducts);
			}
			if (!kidsProducts.isEmpty()) {
				model.addAttribute("kproducts", kidsProducts);
			}
			return "redirect:/user/user_index";
		}
		/*
		 * else if(s!=null && t==null ) { return "redirect:/admin/admin_index"; }
		 */
		else {
			return "logIn";
		}

	}

	/*
	 * @PostMapping("/logIn") public String checkUser(@RequestParam("name") String
	 * name,
	 * 
	 * @RequestParam("password") String password, HttpServletRequest request, Model
	 * model) {
	 * 
	 * Authentication authentication = authenticationManager.authenticate( new
	 * UsernamePasswordAuthenticationToken(name, password));
	 * 
	 * if (authentication.isAuthenticated()) { UserDetails user = (UserDetails)
	 * authentication.getPrincipal(); HttpSession session = request.getSession();
	 * session.setAttribute("sname", name);
	 * 
	 * System.out.println(name); if (user.getAuthorities().stream().anyMatch(a ->
	 * a.getAuthority().equals("admin"))) { return "redirect:/admin/admin_index"; }
	 * else { List<Product> allProducts = proserv.statusOne("1"); List<Product>
	 * mensProducts = new ArrayList<>(); List<Product> womensProducts = new
	 * ArrayList<>(); List<Product> kidsProducts = new ArrayList<>();
	 * 
	 * for (Product product : allProducts) { switch (product.getType()) { case
	 * "Men's": mensProducts.add(product); break; case "Women's":
	 * womensProducts.add(product); break; case "Kid's": kidsProducts.add(product);
	 * break; } }
	 * 
	 * model.addAttribute("mproducts", mensProducts);
	 * model.addAttribute("wproducts", womensProducts);
	 * model.addAttribute("kproducts", kidsProducts);
	 * 
	 * return "redirect:/user/user_index"; } } else { return "logIn"; // Invalid
	 * credentials } }
	 * 
	 * 
	 * @GetMapping("/redirect") public String redirectUser(Authentication
	 * authentication) { if (authentication.getAuthorities().stream() .anyMatch(role
	 * -> role.getAuthority().equals("ROLE_ADMIN"))) { return
	 * "redirect:/admin/dashboard"; } else { return "redirect:/user/user_index"; } }
	 */
}
