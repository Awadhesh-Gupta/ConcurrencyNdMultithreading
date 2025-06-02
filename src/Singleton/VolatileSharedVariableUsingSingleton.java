package Singleton;
public class VolatileSharedVariableUsingSingleton  {
    private static volatile VolatileSharedVariableUsingSingleton  variable = null;
    private VolatileSharedVariableUsingSingleton (){
        System.out.println("Volatile shared variable instantiated");
    }

    public static VolatileSharedVariableUsingSingleton  getVariable(){
        if(variable == null)
            synchronized (VolatileSharedVariableUsingSingleton .class){
                if(variable==null)
                    variable = new VolatileSharedVariableUsingSingleton ();
            }
        return variable;
    }

    public static void main(String[] args) {
        System.out.println("Entering Main");
        Thread t1 = new Thread(()-> {
            for(int i=0;i<5;i++) {
                System.out.println(Thread.currentThread().getName() + "  " + getVariable());
                try {
                    Thread.sleep(1000);//i.e 1 second = 1000 ms
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"Thread1");
        Thread t2 = new Thread(()->{
            for(int i=0;i<5;i++) {
                System.out.println(Thread.currentThread().getName() + "  " + getVariable());
                try {
                    Thread.sleep(1000);//i.e 1 second = 1000 ms
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"Thread2");
        t1.start();
        t2.start();
        System.out.println("Exiting Main");
    }
}

