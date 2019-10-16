package com.xpsd.provider;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 功能描述:(生成订单号)  时间戳+业务ID
 */
public class OrderNumGenerator {

    //全局业务id
    public static int count = 0;

    public String getNumber(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH--mm-ss");
        return simpleDateFormat.format(new Date()) + "-" + ++count;
    }
}
