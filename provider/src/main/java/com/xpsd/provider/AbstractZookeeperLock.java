package com.xpsd.provider;

import java.util.concurrent.CountDownLatch;

public abstract class AbstractZookeeperLock implements IZKLock {

    // 1.zk连接地址ip+端口号
    private static final String CONNECT_ADDRESS = "127.0.0.1:8888";
    //2.创建zk连接
    protected ZkClient zkClient = new ZkClient(CONNECT_ADDRESS);
    //3.创建临时节点
    protected  static final String PATH = "/lock";

    //4.信号量定义 countdownLatch 置为 null 当前等于 0的时候，唤醒在其间等待的线程
    protected CountDownLatch countDownLatch = null;

    /**
     * 尝试获取锁  如果没有获取到锁，就继续等待获取锁 waitGetLock()，获取到了锁就开始执行生产 订单。
     * 获取到锁 就是创建这个PATH节点成功了 则当前线程就获取到锁了
     * @return
     */
    abstract Boolean tryGetLock();

    /**
     * 等待获取锁
     */
    abstract void waitGetLock();

    @Override
    public void getLock() {
        if (tryGetLock()){
            System.out.println("####获取锁成功#####");
        }else {
            //等待获取锁  使用的信号量和ZK的事件监听来实现，等待完毕后再尝试获取锁
            waitGetLock();
            //再次尝试获取锁
            getLock();
        }

    }

    @Override
    public void unlock() {
        if(zkClient!=null){
            System.out.println("###释放锁资源###");
            System.out.println();
            zkClient.close();
        }
    }
}
