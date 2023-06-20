package DesignPatterns;

import DesignPatterns.Adapter.PaymentGateway;

public class Flipkart {
    private PaymentGateway payment;

    public Flipkart(PaymentGateway payment) {
        this.payment = payment;
    }

    public int payment(int orderId){
        return payment.Payment(orderId);
    }

    public int refund(int orderId){
        return payment.refund(orderId);
    }

    public boolean refundStatus(int orderId){
        return payment.paymentStatus(orderId);
    }
}
