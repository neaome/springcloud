package com.xpsd.provider;

public class ZkClient {

    private String path;


    public ZkClient(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ZkClient close(){
        return null;
    }
}
