package com.xpsd.provider;

public class ZookeeperDistrbuteLock extends AbstractZookeeperLock {

    @Override
    Boolean tryGetLock() {
        if (zkClient!=null){
            //创建节点 如果当前节点创建成功了 就不会报异常  就返回true,否则创建失败返回false

        }



        return null;
    }

    @Override
    void waitGetLock() {

    }
}
