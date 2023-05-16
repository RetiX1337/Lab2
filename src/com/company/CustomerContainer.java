package com.company;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

public class CustomerContainer implements Serializable {
    private final HashMap<Long, Customer> customerContainer = new HashMap<>();
    private Long idCounter = 0L;

    public Customer save(Customer customer) {
        customer.setId(idCounter);
        customerContainer.put(idCounter, customer);
        idCounter++;
        return customer;
    }

    public void delete(Customer customer) {
        customerContainer.remove(customer.getId());
    }

    public Customer findById(Long id) {
        return customerContainer.get(id);
    }

    public Collection<Customer> findAll() {
        return customerContainer.values();
    }
}
