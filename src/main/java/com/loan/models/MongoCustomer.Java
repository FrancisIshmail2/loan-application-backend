package com.loan.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "customer")
public class MongoCustomer {

    @Id
    private String id;
    private String fname;
    private String lname;
    private String gender;
    private long phone;
    private String email;
    private String password;
    private String confirmPassword;
    private float salary;
    private long adhaar;
    private String pan;
    private double walletAmt;

    // Since MongoDB doesn't support direct relation mapping like JPA,
    // consider storing loan IDs or embed Loan documents directly.
    private List<String> loanIds = new ArrayList<>();

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    // ... Other getters and setters for lname, gender, etc.

    public List<String> getLoanIds() {
        return loanIds;
    }

    public void setLoanIds(List<String> loanIds) {
        this.loanIds = loanIds;
    }

    // Method to add Loan ID
    public void addLoanId(String loanId) {
        this.loanIds.add(loanId);
    }
}
