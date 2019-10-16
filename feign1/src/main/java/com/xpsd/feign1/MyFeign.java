package com.xpsd.feign1;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "PROVIDER",fallback = MemberFallBack.class)
public interface MyFeign {

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String sayHi(@RequestParam(value = "name") String name);

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String sayHello();
}
