package com.xpsd.feign1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Autowired
    private MyFeign myFeign;

    @RequestMapping("/hi")
    public String sayHi(String name){
        return myFeign.sayHi(name);
    }

    @GetMapping("/hello")
    public String sayHello(){
        System.out.println("2222222222222222");
        return myFeign.sayHello();
    }
}
