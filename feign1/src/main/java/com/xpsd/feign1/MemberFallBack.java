package com.xpsd.feign1;

import org.springframework.stereotype.Component;

@Component//注入到Spring容器里面去
public class MemberFallBack implements MyFeign {
    @Override
    public String sayHi(String name) {
        return null;
    }

    @Override
    public String sayHello() {
        return "服务器发生异常，当前不能访问";
    }
}
