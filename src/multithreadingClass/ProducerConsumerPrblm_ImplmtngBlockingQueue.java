package multithreadingClass;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerPrblm_ImplmtngBlockingQueue {
    private Queue<Integer> q;
    private int capacity;

    public ProducerConsumerPrblm_ImplmtngBlockingQueue(int cap){
        q = new LinkedList<>();
        capacity = cap;
    }
    public boolean add(int item) {
        synchronized (q) {
            while (q.size() == capacity) {
                try {
                    q.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            q.add(item);
            System.out.println(Thread.currentThread().getName() + " produced: " + item);
            q.notifyAll();
            return true;
        }
    }

    public int remove(){
        synchronized (q) {
            while (q.size() == 0) {
                try {
                    q.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            int element = q.poll();
            System.out.println(Thread.currentThread().getName() + " consumed: " + element);
            q.notifyAll();
            return element;
        }
    }

    public static void main(String[] args) {
        ProducerConsumerPrblm_ImplmtngBlockingQueue sc = new ProducerConsumerPrblm_ImplmtngBlockingQueue(7);
        System.out.println("Entering Main");
        Thread producer = new Thread(()-> {
            for(int i =0;i<7;i++){
                sc.add(i);
                try{
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },"Producer");
        Thread consumer = new Thread(()-> {
            for(int i =0;i<7;i++){
                sc.remove();
                try{
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },"Consumer");
        producer.start();
        consumer.start();
        System.out.println("Exiting Main");

    }
}
