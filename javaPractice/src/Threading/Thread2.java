package Threading;

public class Thread2 implements Runnable{
    @Override
    public void run() {
        Thread.currentThread().setName("Thread2 rendava daaram");
        System.out.println(Thread.currentThread().getName());
    }
}
