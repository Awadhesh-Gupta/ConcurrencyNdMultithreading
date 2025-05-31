package multithreadingClass;

public class SyncThreadOfHavingStaticNdNonStaticFuncn {
    private static int array[];
    private static int stacktop;
    private static final Object lock = new Object();    // This lock is used to lock a thread so other thread won't be able to access the resrcs.
    public SyncThreadOfHavingStaticNdNonStaticFuncn(int capacity){
        array = new int[capacity];
        stacktop = -1;
       // lock = new Object();    //Only wrapper class can be used like new Integer() not int,etc. & here lock points to current obj
    }
    public static boolean isEmpty(){
        return stacktop <0;
    }
    public boolean isFull(){
        return stacktop >= array.length-1;
    }
    public  boolean push(int element){
        synchronized (lock){
            if(isFull()) return false;
            ++stacktop;
            try{Thread.sleep(1000);
            }catch (Exception e){
                System.out.println(e);
            }
            array[stacktop] = element;
            return true;
        }
    }
    public static int pop(){
        synchronized (lock) {
            if (isEmpty()) return Integer.MIN_VALUE;
            int element = array[stacktop];
            array[stacktop] = Integer.MIN_VALUE;
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            }
            stacktop--;
            return element;
        }
    }

    public static void main(String[] args) {
        System.out.println("Main is starting");
        SyncThreadOfHavingStaticNdNonStaticFuncn stack = new SyncThreadOfHavingStaticNdNonStaticFuncn(5);
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
