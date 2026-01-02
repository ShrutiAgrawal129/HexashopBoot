package com.univ.services;

import java.util.Optional;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.univ.bean.Product;
import com.univ.bean.Customer;
import com.univ.repository.ProductRepository;
import com.univ.repository.UserRepository;

@Service
public class UserServices {
	@Autowired
	private UserRepository userrepo;

	@Autowired
	private ProductRepository productrepo;

	public void saveUser(Customer user) {
		userrepo.save(user);
	}

	public boolean check(String name, String password) {
		boolean v = false;
		Optional<Customer> user = userrepo.findByName(name);
		Customer user2 = user.get();

		if (name.equals(user2.getName()) && password.equals(user2.getPassword())) {
			v = true;
//			System.out.println("good job");
		}
//		System.out.println("bad");
		return v;
	}

	public Customer profileCheck(String name) {
		Optional<Customer> user = userrepo.findByName(name);
		Customer user2 = user.get();
//		System.out.println(user2.getName()+"/"+user2.getAddress()+"/"+user2.getCity());
		if (name.equals(user2.getName())) {
//		System.out.println(user);
			return user2;
		} else {
			return null;
		}

	}

	@Transactional
	public void updateProfile(String name, Long phone, String email, String address, String city) {
		userrepo.updateProfile(name, phone, email, address, city);

	}

	@Transactional
	public void changePassword(String name, String pass) {
		userrepo.changePassword(name, pass);
	}

	

}
