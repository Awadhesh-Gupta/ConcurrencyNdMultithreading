package multithreadingClass;
public class ThreadTester {
    public static void main(String[] args) {
        System.out.println("Main is starting");
        /*Thread thread1 = new Thread1("thread1");
        thread1.start();*/ // not using this way i.e. extending Thread class bcoz it adds conditions to our code also
        // won't support multiple inheritance of class in java

        Thread thread2 = new Thread(new Thread2(),"thread2"); //using this as implements Runnable interface & java supports multiple inheritance.
        thread2.start();


        Thread thread3 = new Thread(()->{
            for(int i=0;i<5;i++)
                System.out.println(Thread.currentThread().getName()+ " "+i);
        },"thread3");

        thread3.start();
        System.out.println("Main is exiting");
    }
}
