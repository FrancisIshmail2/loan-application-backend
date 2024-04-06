package com.loan.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.loan.models.MongoCustomer;

public interface MongoCustomerRepository extends MongoRepository<MongoCustomer, String> {
    // Add custom query methods if required
}
