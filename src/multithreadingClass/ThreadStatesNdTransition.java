package multithreadingClass;

public class ThreadStatesNdTransition {
    public static void main(String[] args) {
        System.out.println("Main is Starting");
        Thread t1 = new Thread(()->{
            try {
                Thread.sleep(1);
                for (int i = 10000; i > 0; i--) ;
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        },"States");
        t1.start();
        while(true){
            Thread.State state = t1.getState();
            System.out.println(state);
            if(state == Thread.State.TERMINATED) break;
        }
    }
}
