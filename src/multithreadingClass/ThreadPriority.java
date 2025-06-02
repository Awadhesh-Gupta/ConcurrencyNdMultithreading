package multithreadingClass;
public class ThreadPriority {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            System.out.println(Thread.currentThread());
        },"t1");
        Thread t2 = new Thread(()->{
            System.out.println(Thread.currentThread());
        },"t2");
        t1.setPriority(1);//min = 1 , max = 10  and default = 5  .It is not always fixed whether JVM follows this priority
        t2.setPriority(10);
        Thread.currentThread().setPriority(7);
        t1.start();
        t2.start();
        System.out.println("Entering Main Thread i.e. "+Thread.currentThread());
        System.out.println("T1 Priority: "+t1.getPriority()+",T2 Priority: "+t2.getPriority()+",main priority: "+Thread.currentThread().getPriority());
    }
}
