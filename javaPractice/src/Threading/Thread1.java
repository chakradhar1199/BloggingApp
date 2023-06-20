package Threading;

public class Thread1 extends Thread{
    public void run(){
        Thread.currentThread().setName("okatova daaram");
        System.out.println("this is thread1 "+Thread.currentThread().getName());
    }
}
