package com.gdu_springboot.springboot_demo;

import com.gdu_springboot.springboot_demo.dao.ProductDAO;
import com.gdu_springboot.springboot_demo.entity.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringbootDemoApplication {

	public static void main(String[] args) {SpringApplication.run(SpringbootDemoApplication.class, args);}

	//lab1_buoi2
	@Bean
	CommandLineRunner commandLineRunner(ProductDAO productDAO) {
		return runner -> {
//			//bt1: ket noi Database
//			System.out.println("Ket noi Database");
//			//bt2: them product
//			CreateProduct(productDAO);
//			System.out.println("Insert product in database");
//			ViewProduct(productDAO);
//			//bt3: update product
//			UpdateProduct(productDAO);
//			ViewProduct(productDAO);
//			//bt4: xoa product
//			DeleteProduct(productDAO);
//			System.out.println("Deleted product in Database");

//			bt5: view all product
//			CreateProduct(productDAO);// Nhap 5 product'Num' moi vao Database
//			ViewAllProduct(productDAO);

//			//bt6: view product by name
//			ViewProductByName(productDAO);
//
//			//bt7: delete all product
			DeleteAll(productDAO);
			ViewAllProduct(productDAO);
		};
	}

	private void CreateProduct(ProductDAO productDAO) {
//		Product product = new Product("Tra sua A","Thuc uong Tra sua",12);
//		productDAO.save(product);

		Product product1 = new Product("Ca phe Den Highland","Thuc uong Ca phe",20);
		productDAO.save(product1);
		Product product2 = new Product("Banh mi Thit Ha Noi", "Thuc an Banh mi",15);
		productDAO.save(product2);
		Product product3 = new Product("Pho Bo thit Pho xua","Thuc an Pho", 30);
		productDAO.save(product3);
		Product	product4 = new Product("Nuoc suoi Aqua", "Thuc uong Nuoc suoi", 8);
		productDAO.save(product4);
		Product product5 = new Product("Sua Cacao Milo", "Thuc uong Sua", 10);
		productDAO.save(product5);
	}

	private void ViewProduct(ProductDAO productDAO) {
		Product product = productDAO.findById(1);
		System.out.println(product);
	}

	private void UpdateProduct(ProductDAO productDAO) {
		Product product = productDAO.findById(1);
		product.setName("Tra sua A");
		product.setDetail("Thuc uong Tra sua");
		product.setPrice(12);
		productDAO.update(product);
	}

	private void DeleteProduct(ProductDAO productDAO) {
		Product product = productDAO.findById(1);
		productDAO.delete(product);
	}

	private void ViewAllProduct(ProductDAO productDAO) {
		List<Product> products = productDAO.findAll();
		for(Product product : products) {
			System.out.println(product);
		}
	}

	private void ViewProductByName(ProductDAO productDAO) {
		List<Product> products = productDAO.findByName("Banh mi Thit Ha Noi");
		for(Product product : products) {
			System.out.println(product);
		}
	}

	private void DeleteAll(ProductDAO productDAO) {
		int num= productDAO.deleteAll();
		System.out.println("Deleted "+ num + " products");
	}
	//lab1_buoi2
}
