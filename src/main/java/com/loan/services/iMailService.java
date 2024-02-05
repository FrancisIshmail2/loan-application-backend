package com.loan.services;

public interface iMailService {
    void sendMail(String email, double loanAmount, int loanDuration, double emi, String customerName, float salary);
}
