package com.company.customer;

import com.company.customer.Customer;

import java.io.*;
import java.util.Collection;
import java.util.HashMap;

public class CustomerList implements Externalizable {
    private HashMap<Long, Customer> customerList = new HashMap<>();
    private Long idCounter = 0L;

    public CustomerList() {

    }

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

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(customerList);
        for (Customer c : customerList.values()) {
            c.writeExternal(out);
        }
        out.writeLong(idCounter);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        customerList = (HashMap<Long, Customer>) in.readObject();
        for (Customer c : customerList.values()) {
            c.readExternal(in);
        }
        idCounter = in.readLong();
    }
}
