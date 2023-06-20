package Threading;

public class Threadimplementation {
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread t2 = new Thread(new Thread2());
        t1.start();
        t2.start();
    }
}
