package com.univ;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.univ.bean.Product;
import com.univ.bean.Customer;
import com.univ.bean.Order;
import com.univ.repository.ProductRepository;
import com.univ.services.OrderServices;
import com.univ.services.ProductServices;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private ProductServices productServ;
	
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderServices orderServ;
	
	@RequestMapping("/")
	public String adminIndex1() {
		return "admin/admin_index";
	}

	@RequestMapping("/admin_index")
	public String adminIndex() {
		return "admin/admin_index";
	}

	@RequestMapping("/addProduct")
	public String addProduct() {
		return "admin/addProduct";
	}
 

	@RequestMapping(path = "/addProduct", method = RequestMethod.POST)
	public String upload(@ModelAttribute("Product") Product pro, HttpSession s) throws IOException {
		MultipartFile file = pro.getImage();
		byte[] data = file.getBytes();
		String path = s.getServletContext().getRealPath("/") + "assets" + File.separator + "images" + File.separator
				+ file.getOriginalFilename();
		System.out.println(file);
		try {
			FileOutputStream fos = new FileOutputStream(path);
			fos.write(data);
			fos.close();

			pro.setImg_org(file.getOriginalFilename());

			productServ.saveProduct(pro);

		} catch (IOException e) {
			System.out.println(e);
		}

		return "admin/product_list";
	}

	@GetMapping("/customer_list")
	public String show(Model model) {

		List<Customer> user = productServ.showAllCustomer();
//		System.out.println(user);
		model.addAttribute("users", user);

		return "admin/customer_list";
	}
	
	
	@GetMapping("/product_list")
	public String entry(Model model) {

		List<Product> product = productServ.showAll();
		
//		System.out.println(product);
		
//		if (product.isEmpty()) {
//			System.out.println("fail");
//		} else {
//			System.out.println("pass");
//		}

		model.addAttribute("products", product);

		return "admin/product_list";
	}
	
	/*
	 * @RequestMapping("/update_status") public String approval(HttpServletRequest
	 * request) { String[] selectedProducts = request.getParameterValues("status");
	 * // System.out.println("xsac"); if (selectedProducts != null) { // Loop
	 * through the selected product IDs for (String productId : selectedProducts) {
	 * // Here you would call a service method to update the product status
	 * productServ.updateProductStatus(Integer.parseInt(productId)," 1"); } }
	 * 
	 * return "/admin/admin_index"; } 
	 */
	
	@RequestMapping("/update_status")
	public String updateStatus(@RequestParam("status") List<Integer> activeProductIds) {
		productServ.updateProductStatus(activeProductIds);
		return "admin/admin_index";
	}
	
	@RequestMapping("/accept_order")
	public String acceptOrder(Model model) {
		List<Order> orders = orderServ.showOrders();
		if (orders.isEmpty()) {
        model.addAttribute("message", "No orders available.");
        return "admin/accept_order";
		}

		model.addAttribute("orders", orders); // Pass the list of orders

		return "admin/accept_order";
	}
	
}
