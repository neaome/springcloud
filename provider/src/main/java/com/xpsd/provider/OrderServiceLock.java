package com.xpsd.provider;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OrderServiceLock implements Runnable {

     //生成订单号
    OrderNumGenerator numGenerator = new OrderNumGenerator();

    //这里使用的是lock锁中的重入锁 ：可以重复使用的锁
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {

        try {
            lock.lock();
            getNumber();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {//释放锁一定要放在这个finally里面，保证执行方法的时候出现异常也能释放掉锁。防止死锁。
            lock.unlock();
        }
    }

    //获取流水号
    public void getNumber(){
        String number = numGenerator.getNumber();
        System.out.println(Thread.currentThread().getId()+",##number "+number);
    }

    public static void main(String[] args) {
        System.out.println("###模拟订单号生成");
        OrderService orderService = new OrderService();
        //模拟多用户去请求订单号
        for (int i=0;i<100;i++){
            new Thread(orderService).start();
        }

    }
}
