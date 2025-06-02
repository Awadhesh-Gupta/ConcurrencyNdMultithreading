package multithreadingClass;

public class CreatingDeadlock {
    public static void main(String[] args) {
        String lock1 = "Kurt";
        String lock2 = "Cobain";
        Thread t1 = new Thread(()->{
            synchronized (lock1){
                try{
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                synchronized (lock2){
                    System.out.println("LOCK ACQUIRED");
                }
            }

        });
        Thread t2 = new Thread(()->{
            synchronized (lock2){
                try{
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                synchronized (lock1){
                    System.out.println("LOCK ACQUIRED");
                }
            }

        });
        t1.start();
        t2.start();
        System.out.println("Main is Started");

        //This is the case where deadlock arises as both the thread has holded one lock required to them to acquire lock
        //To solve this keep the order of synchronization of lock similar for both thread
    }
}
