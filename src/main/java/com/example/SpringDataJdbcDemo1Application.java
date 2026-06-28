package com.example;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.model.Product;
import com.example.repository.ProductRepository;

@SpringBootApplication
public class SpringDataJdbcDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJdbcDemo1Application.class, args);
	}

	@Bean
	CommandLineRunner demo(ProductRepository repository) {
		return (args) -> {
			// == 1. Insert ข้อมูล ==
			// ตอน Insert ให้ส่ง ID เป็น null ไปก่อน เพื่อให้ DB รัน Auto-increment เอง
			Product p1 = new Product(null, "Gaming Mouse", new BigDecimal("1500.00"), LocalDateTime.now());
			Product p2 = new Product(null, "Mechanical Keyboard", new BigDecimal("3500.00"), LocalDateTime.now());

			p1 = repository.save(p1); // สังเกตว่า p1 ตัวใหม่จะได้ ID กลับมาจาก DB
			repository.save(p2);
			System.out.println("Inserted Product: " + p1);

			// == 2. Find ข้อมูลทั้งหมด ==
			System.out.println("\n--- All Products ---");
			repository.findAll().forEach(product -> System.out.println(product));

			// == 3. ลองใช้ Custom Query แบบระบุราคา ==
			System.out.println("\n--- Products expensive than 2000 ---");
			repository.findExpensiveProducts(new BigDecimal("2000.00"))
					.forEach(System.out::println);

			// == 4. อัปเดตข้อมูลด้วย SQL ตรงๆ ==
			System.out.println("\n--- Updating Price ---");
			int effRows = repository.updatePrice(p1.id(), new BigDecimal("1200.00"));
			System.out.println("Update success? : " + effRows + " row(s) affected.");

			// ดูผลลัพธ์หลังอัปเดต
			System.out.println("Updated Product: " + repository.findById(p1.id()).orElse(null));

			// ดึงแค่บางฟิลด์เข้า record
			System.out.println("\n--- Select some field to record ---");
			var result = repository.findAllProductSummaries();
			result.forEach(productSummary -> System.out.println(productSummary));
		};
	}

}
