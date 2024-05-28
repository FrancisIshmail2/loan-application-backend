package com.loan.services;

import com.sendgrid.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class SendGridMailService implements iMailService {

    @Value("${sendgrid.api.key}")
    private String sendGridApiKey;

    @Override
    public void sendMail(String email, double loanAmount, int loanDuration, double emi, String customerName, float salary) {
        Email from = new Email("your-email@example.com"); // Replace with your email
        String subject = "Loan Application Received";
        Email to = new Email(email);
        Content content = new Content("text/plain", 
                "Dear " + customerName + ",\n\n" +
                "We have received your loan application with the following details:\n" +
                "Loan Amount: " + loanAmount + "\n" +
                "Loan Duration: " + loanDuration + " years\n" +
                "Monthly EMI: " + emi + "\n" +
                "Salary: " + salary + "\n\n" +
                "Thank you for choosing us for your financial needs.\n\n" +
                "Best Regards,\nYour Loan Team");
/*
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(sendGridApiKey);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            // You can add more logging or actions based on the response
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            // Handle exceptions here
            ex.printStackTrace();
        }
    }
*/
}
