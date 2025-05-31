package multithreadingClass;

public class UsingsynchronizedToFuncnToSyncThreads {
    private int array[];
    private int stacktop;
    //private Object lock;    // This lock is used to lock a thread so other thread won't be able to access the resrcs.
    public UsingsynchronizedToFuncnToSyncThreads(int capacity){
        array = new int[capacity];
        stacktop = -1;
       // lock = new Object();    //Only wrapper class can be used like new Integer() not int,etc. & here lock points to current obj
    }
    public boolean isEmpty(){
        return stacktop <0;
    }
    public boolean isFull(){
        return stacktop >= array.length-1;
    }
    public  synchronized boolean push(int element){ //Using synchronized keyword on methods so won't
          //synchronized the thread containing a block of piece of code & using this keyword pointing
            // to current object works as one lock for all thread to take over control on the resources or critical section
            //so other thread won't able to interrupt until one exits.
            if(isFull()) return false;
            ++stacktop;
            try{Thread.sleep(1000);
            }catch (Exception e){
                System.out.println(e);
            }
            array[stacktop] = element;
            return true;

    }
    public synchronized int pop(){
            if(isEmpty()) return Integer.MIN_VALUE;
            int element = array[stacktop];
            array[stacktop] = Integer.MIN_VALUE;
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                System.out.println(e);
            }
            stacktop--;
            return element;
        }

    public static void main(String[] args) {
        System.out.println("Main is starting");
        UsingsynchronizedToFuncnToSyncThreads stack = new UsingsynchronizedToFuncnToSyncThreads(5);
        new Thread(()->{
            int c = 0;
            while(++c < 10){
                System.out.println("Pushed "+ stack.push(c));
            }

        }).start();

        new Thread(() -> {
            int count =0;
            while(++count < 10) System.out.println("Popped "+ stack.pop());
        }).start();

        System.out.println("Main is exiting");

    }
}
