package com.company.customer;

import com.company.customer.Customer;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

public class CustomerList implements Serializable {
    private final HashMap<Long, Customer> customerList = new HashMap<>();
    private Long idCounter = 0L;

    public Customer save(Customer customer) {
        customer.setId(idCounter);
        customerList.put(idCounter, customer);
        idCounter++;
        return customer;
    }

    public void delete(Customer customer) {
        customerList.remove(customer.getId());
    }

    public Customer findById(Long id) {
        return customerList.get(id);
    }

    public Collection<Customer> findAll() {
        return customerList.values();
    }
}
