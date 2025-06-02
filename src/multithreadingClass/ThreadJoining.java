package multithreadingClass;

public class ThreadJoining {
    public static void main(String[] args) {
        System.out.println("Entering Child thread");
        Thread t1 = new Thread(()->{
            System.out.println(Thread.currentThread());
        },"Our Thread");
        t1.start();
        try {
            t1.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Entering Main method and in main thread  i.e. "+ Thread.currentThread());

    }
}
