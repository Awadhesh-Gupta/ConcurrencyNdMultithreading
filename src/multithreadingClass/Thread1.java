package multithreadingClass;

public class Thread1 extends Thread {
    public void run(){
        for(int i=0;i<5;i++)
            System.out.println("inside thread1 "+i);
    }
}
