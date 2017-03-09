package com.xiaoneng.fashion;

import org.junit.*;

import java.util.*;

/**
 * @author zhaoht
 * @date 2017/2/24 16:26
 */
public class HashMapTest {

    @org.junit.Test
    public void test(){

        List<String> hello = new LinkedList<>();

        Iterator<String> iterator= hello.iterator();
        hello.add("nihao");
        hello.add("hello");

        while(iterator.hasNext()){
            System.out.println(iterator.next());

        }


    }

    public void hello(int h){
        h += 1;
        System.out.println("hello()..." + h);
    }
}
