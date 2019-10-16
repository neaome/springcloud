package com.xpsd.provider;

public interface IZKLock {

    /**
     * 获取锁
     */
    public void getLock();

    /**
     * 释放锁
     */
    public void unlock();
}
