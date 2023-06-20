package DesignPatterns;

import DesignPatterns.Adapter.*;
import DesignPatterns.ThirdPartyClasses.Creditcard;
import DesignPatterns.ThirdPartyClasses.Debitcard;
import DesignPatterns.ThirdPartyClasses.PhonePay;
import DesignPatterns.ThirdPartyClasses.Razorpay;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        PaymentGateway paymentGateway;

        Scanner scanner = new Scanner(System.in);
        System.out.println("===== Select the payment method =====\n1. RazorPay\n2. PhonePay\n3. Credit Card\n4. Debit Card");
        int option = scanner.nextInt();
        switch (option){
            case 1: paymentGateway = new RazorpayFlipkart(new Razorpay());
            case 2: paymentGateway = new PhonepayFlipkart(new PhonePay());
            case 3: paymentGateway = new CreditFlipkart(new Creditcard());
            case 4: paymentGateway = new DebitCardFlipkart(new Debitcard());
            default:paymentGateway = new RazorpayFlipkart(new Razorpay());
        }
        Flipkart flipkart = new Flipkart(paymentGateway);

        System.out.println(flipkart.payment(23));

        System.out.println(flipkart.refund(89));

        System.out.println(flipkart.refundStatus(89));

    }
}
