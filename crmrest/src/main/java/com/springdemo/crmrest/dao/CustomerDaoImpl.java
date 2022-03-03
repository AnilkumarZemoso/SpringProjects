package com.springdemo.crmrest.dao;

import com.springdemo.crmrest.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {

        Session session= sessionFactory.getCurrentSession();
        Query<Customer> query= session.createQuery("from Customer order by lastName", Customer.class);
        List<Customer> customerList=query.getResultList();

        return customerList;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {

        Session session= sessionFactory.getCurrentSession();
        session.saveOrUpdate(theCustomer);

    }

    @Override
    public Customer getCustomer(int id) {

        Session session=sessionFactory.getCurrentSession();
        Customer customer=session.get(Customer.class,id);

        return customer;
    }

    @Override
    public void deleteCustomer(int id) {

        Session session= sessionFactory.getCurrentSession();
        Query<Customer> query= session.createQuery("delete from Customer where id=:customerId");
        query.setParameter("customerId",id);
        query.executeUpdate();
    }
}
