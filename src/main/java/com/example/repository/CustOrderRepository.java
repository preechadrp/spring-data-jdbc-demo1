package com.example.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.model.CustOrder;

public interface CustOrderRepository extends CrudRepository<CustOrder, String> {

	@Query("SELECT * FROM cust_order WHERE id != :id and total_amount >= :total_amount")
	List<CustOrder> findTotalAmount(@Param("id") String id, @Param("total_amount") BigDecimal totalAmount);
}
