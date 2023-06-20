package DesignPatterns.Adapter;

import DesignPatterns.ThirdPartyClasses.Debitcard;

public class DebitCardFlipkart implements PaymentGateway {
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

    public DebitCardFlipkart(Debitcard debitcard) {
    }
}
