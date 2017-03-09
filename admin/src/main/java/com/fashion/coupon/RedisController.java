package com.fashion.coupon;

import org.springframework.stereotype.Controller;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhaoht
 * @date 2017/1/6 17:51
 */
@Controller
public class RedisController {

    public String test(){


        List<String> hello = new LinkedList<>();
        Iterator<String> iterator= hello.iterator();

        hello.add("nihao");
        hello.add("hello");
        while(iterator.hasNext()){
            iterator.next();
        }

        return null;
    }
}
