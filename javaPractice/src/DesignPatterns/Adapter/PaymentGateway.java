package DesignPatterns.Adapter;

public interface PaymentGateway {

//    returns the payment transaction id
    public int Payment(int paymentId);
//    returns the refund transaction id
    public int refund(int orderId);
//    returns the boolean status of the transaction id
    public boolean paymentStatus(int transactionId);
}
