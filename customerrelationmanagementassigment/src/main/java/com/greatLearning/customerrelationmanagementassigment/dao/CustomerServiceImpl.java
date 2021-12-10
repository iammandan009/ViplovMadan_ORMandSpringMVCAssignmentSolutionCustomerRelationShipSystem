package com.greatLearning.customerrelationmanagementassigment.dao;

import com.greatLearning.customerrelationmanagementassigment.service.CustomerService;
import com.greatLearning.customerrelationmanagementassigment.entity.*;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CustomerServiceImpl implements CustomerService {
	private SessionFactory sessionFactory;
	private Session session;

	public CustomerServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			this.session = this.sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			this.session = this.sessionFactory.openSession();
		}
	}

	@Transactional
	public List<Customer> findAll() {
		List<Customer> customers = session.createQuery("from Customer", Customer.class).list();
		return customers;
	}

	@Transactional
	public Customer findById(int id) {
		Customer customer = session.get(Customer.class, id);
		return customer;
	}

	@Transactional
	public void save(Customer customer) {
		session.saveOrUpdate(customer);
	}

	@Transactional
	public void deleteById(int id) {
		Transaction tx = session.beginTransaction();

		Customer customer = session.get(Customer.class, id);
		session.delete(customer);

		tx.commit();
	}

}
