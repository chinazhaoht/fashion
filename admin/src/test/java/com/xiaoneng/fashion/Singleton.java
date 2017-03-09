package com.xiaoneng.fashion;

/**
 * @author zhaoht
 * @date 2017/2/24 16:03
 */
public class Singleton {

    private static volatile Singleton singleton = null;

    private Singleton(){}

    public static  Singleton getInstance(){
        if(singleton == null){
            synchronized (Singleton.class){
                if(singleton == null){
                    System.out.println("teset");
                    singleton  = new Singleton();
                }
            }

        }
        return singleton;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(new Test()).start();
        }
    }
}

class Test implements Runnable{

    @Override
    public void run() {
       Singleton.getInstance();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


