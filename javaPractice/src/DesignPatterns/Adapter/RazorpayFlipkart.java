package DesignPatterns.Adapter;

import DesignPatterns.ThirdPartyClasses.Razorpay;

public class RazorpayFlipkart implements PaymentGateway{
    private Razorpay razorpay;

    public RazorpayFlipkart(Razorpay razorpay) {
        this.razorpay = razorpay;
    }

    @Override
    public int Payment(int orderId) {
        return razorpay.Payment(orderId);
    }

    @Override
    public int refund(int orderId) {
        return razorpay.refund(orderId);
    }

    @Override
    public boolean paymentStatus(int transactionId) {
        return razorpay.refundStatus(transactionId);
    }



}
