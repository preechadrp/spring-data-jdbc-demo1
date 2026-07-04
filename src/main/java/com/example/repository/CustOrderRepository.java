package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.model.CustOrder;

public interface CustOrderRepository extends CrudRepository<CustOrder, String> {

}
