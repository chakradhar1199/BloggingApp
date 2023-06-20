package DesignPatterns.ThirdPartyClasses;

public class Razorpay {
    public int Payment(int orderId){
        System.out.println(orderId+" paid successfully");
        return orderId;
    }


    public int refund(int orderId){
        System.out.println(orderId+" refunded successfully");
        return orderId;
    }

    public boolean refundStatus(int orderId){
        System.out.println(orderId<10);
        return orderId<10;
    }
}
