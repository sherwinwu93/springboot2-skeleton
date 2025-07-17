package com.wusd.skeleton.designpattern.singleton;

/**
 * @author wusd
 * @date 2020/1/8 23:43
 */
public class LazySingleton {
//    private static LazySingleton instance = null;
//    private LazySingleton() {}
      //加synchronize,确保多线程下单一
//    synchronized public LazySingleton getInstance() {
//        if (instance == null) {
//            instance = new LazySingleton();
//        }
//        return instance;
//    }
    //第一种方式带来性能问题
//    public static LazySingleton getInstance() {
//        if (instance == null) {
    //这种方法不成功,进入该代码块之后,多线程同时进行,线程1进入代码块后,创建完,但是线程2不知道线程1已经创建完
//            synchronized (LazySingleton.class) {
//                instance = new LazySingleton();
//            }
//        }
//        return instance;
//    }

    /**
     * 忽略jvm的优化
     */
    private volatile static LazySingleton instance = null;

    /**
     * 双重检查锁定
     * @return
     */
    public static LazySingleton getInstance() {
        //第一重判断
        if (instance == null) {
            //锁定代码块
            synchronized (LazySingleton.class) {
                //第二重判断
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
