package com.loan.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.loan.dao.MongoCustomerRepository;
import com.loan.exceptions.CustomerAlreadyRegisteredException;
import com.loan.exceptions.CustomerNotFoundException;
import com.loan.models.MongoCustomer;
import com.loan.services.iMongoCustomerService;

import java.util.List;

@Service
public class MongoCustomerServiceImpl implements iMongoCustomerService {

    @Autowired
    private MongoCustomerRepository mongoCustomerDao;

    @Override
    public MongoCustomer addCustomer(MongoCustomer c) {
        // Check if customer already exists
        if (mongoCustomerDao.existsById(c.getId())) {
            throw new CustomerAlreadyRegisteredException("Customer Already Registered: " + c.getId());
        }
        return mongoCustomerDao.save(c);
    }

    @Override
    public MongoCustomer getCustomerById(String customerId) {
        return mongoCustomerDao.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer Not Found: " + customerId));
    }

    @Override
    public List<MongoCustomer> getCustomers(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return mongoCustomerDao.findAll(pageable).getContent();
    }

    @Override
    public MongoCustomer updateCustomer(MongoCustomer c) {
        MongoCustomer existingCustomer = getCustomerById(c.getId());
        if (existingCustomer != null) {
            existingCustomer.setFname(c.getFname());
            // Set other properties...
            return mongoCustomerDao.save(existingCustomer);
        }
        throw new CustomerNotFoundException("Customer Not Found: " + c.getId());
    }

    // Add other methods as per your requirement like doLogin, etc.
}
