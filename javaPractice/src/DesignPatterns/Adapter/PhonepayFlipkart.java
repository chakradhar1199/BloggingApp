package DesignPatterns.Adapter;

import DesignPatterns.ThirdPartyClasses.PhonePay;

public class PhonepayFlipkart implements PaymentGateway {
    public PhonepayFlipkart(PhonePay phonePay) {
    }

    @Override
    public int Payment(int paymentId) {
        return 0;
    }

    @Override
    public int refund(int orderId) {
        return 0;
    }

    @Override
    public boolean paymentStatus(int transactionId) {
        return false;
    }
}
