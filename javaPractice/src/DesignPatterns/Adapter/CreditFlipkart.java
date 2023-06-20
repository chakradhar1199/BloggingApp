package DesignPatterns.Adapter;

import DesignPatterns.ThirdPartyClasses.Creditcard;

public class CreditFlipkart implements PaymentGateway {
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

    public CreditFlipkart(Creditcard creditcard) {
    }
}
