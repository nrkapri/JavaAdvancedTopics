package concurrency;

import java.util.Random;

public class ProducerConsumerWaitNotifyDemo {

    String buffer = new String();

    boolean readyToProduce =true;

    public synchronized void  produce(String s) throws InterruptedException {
        while(!readyToProduce){
            System.out.println("wait from producer");
            wait();
        }

        buffer = s;
        readyToProduce=false;
        notifyAll();
        System.out.println("notify from producer");

    }

    public synchronized String  consume() throws InterruptedException {
        while(readyToProduce){
            System.out.println("wait from consumer");
            wait();
        }

        readyToProduce=true;
        notifyAll();
        System.out.println("notify from consumer");
        return buffer;
    }

    public static void main(String[] args) {

        ProducerConsumerWaitNotifyDemo pcdemo = new ProducerConsumerWaitNotifyDemo();

        //Producer
        Thread producer=    new Thread(()->{
            for(int i=0;i<10;i++){

                try {
                    Thread.sleep(1000);
                    pcdemo.produce("String "+i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
          });

        //Consumer
        Thread consumer= new Thread(()->{
            for(int i=0;i<10;i++){
                try {
                    Thread.sleep(1000);
                    System.out.println(pcdemo.consume());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
