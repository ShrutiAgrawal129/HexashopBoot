package com.univ.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.univ.bean.Product;
import com.univ.bean.Customer;
import com.univ.repository.ProductRepository;
import com.univ.repository.UserRepository;

@Service
public class ProductServices {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private UserRepository userRepository;

	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	public List<Product> showAll(){
//		System.out.println("abc");
		return productRepository.findAll();
	}
	public List<Customer> showAllCustomer(){
//		System.out.println("abc");
		return userRepository.findAll();
	}
	
	
	public List<Product> getProducts(List<Integer> proIds) {
	    return productRepository.findByIdIn(proIds);
	}

	 
	/*
	 * @Transactional
	 * public void updateProductStatus(int productId, String status)
	 * { List<Product> pro=productRepository.findAll(); for(Product prod:pro) {
	 * prod.setStatus("0"); }
	 * 
	 * // Find the product by ID Optional<Product> productOptional =
	 * productRepository.findById(productId);
	 * 
	 * 
	 * if (productOptional.isPresent()) { Product product = productOptional.get();
	 * // Update the product's status
	 * 
	 * product.setStatus(status); // Save the updated product
	 * productRepository.save(product);
	 * 
	 * } else { // Handle case where the product is not found
	 * System.out.println("Product with ID " + productId + " not found."); } }
	 */
	
	public List<Product> statusOne(String status){
		return productRepository.findByStatus(status);
	}
	
	@Transactional
	public void updateProductStatus(List<Integer> activeProducts) {
		productRepository.updateAllStatus("0");
		
		if(!activeProducts.isEmpty()) {
			productRepository.updateStatusByIds(activeProducts,"1");
		}
	}
	
	
}