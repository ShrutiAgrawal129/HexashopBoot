package com.univ.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Configuration
public class CloudinaryConfig {

	 @Bean
	    public Cloudinary cloudinary() {
	        return new Cloudinary(ObjectUtils.asMap(
	                "cloud_name", "dgbcczozs",
	                "api_key", "812713422729896",
	                "api_secret", "Z38pCnm3Yc0U5AbLblc1dPoMdMI"
	        ));
	    }
}
