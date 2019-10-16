package com.xpsd.provider;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class OrderService implements Runnable {

    //生成订单号
    OrderNumGenerator numGenerator = new OrderNumGenerator();

    @Override
    public void run() {
        synchronized (this){
            getNumber();
        }
    }

    //获取流水号
    public void getNumber(){
        String number = numGenerator.getNumber();
        System.out.println(Thread.currentThread().getId()+",##number "+number);
    }

    public static void main(String[] args) {
//        System.out.println("###模拟订单号生成");
//        OrderService orderService = new OrderService();
//        //模拟多用户去请求订单号
//        for (int i=0;i<100;i++){
//            new Thread(orderService).start();
//        }
        test();
//        System.out.println(System.currentTimeMillis());
//        System.out.println(-1^(-1<<5));
//        System.out.println(1^32);
//        System.out.println(6<<3  );

    }

    public static void test(){
        final IdWorker w = new IdWorker(1,2);
        final CyclicBarrier cdl = new CyclicBarrier(100);

        for(int i = 0; i < 100; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        cdl.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println(w.nextId());}
            }).start();
        }
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
