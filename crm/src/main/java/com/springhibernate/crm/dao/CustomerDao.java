package com.springhibernate.crm.dao;

import com.springhibernate.crm.entity.Customer;

import java.util.List;

public interface CustomerDao {

    public List<Customer> getCustomers();
    public void saveCustomer(Customer theCustomer);
    public Customer getCustomer(int id);

    public void deleteCustomer(int id);
}
