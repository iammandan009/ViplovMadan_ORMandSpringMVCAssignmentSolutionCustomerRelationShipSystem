package com.greatLearning.customerrelationmanagementassigment.service;

import com.greatLearning.customerrelationmanagementassigment.entity.Customer;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

	public List<Customer> findAll();

	public Customer findById(int id);

	public void save(Customer customer);

	public void deleteById(int id);

}
