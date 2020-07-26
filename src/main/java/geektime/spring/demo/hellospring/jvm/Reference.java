package geektime.spring.demo.hellospring.jvm;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class Reference {

    public void test() {

        Object object = new Object();
        SoftReference<Object> softReference = new SoftReference<>(object);
        softReference = null;

        System.out.println(softReference.get());

        String a = "a";
        a.intern();

        WeakReference<Object> weakReference = new WeakReference<>(object);
    }

    public static void main(String[] args) {

//        String a1 = "AA" + "BB";//在常量池上创建常量AA、BB和AABB，并返回AABB
//
//        //常量池上存在常量AABB
//        String a2 = "AABB";
//        String a3 = "AA" + "BB";
//        System.out.println(a2 == a3); //true

        String a5 = "AABB";
        String a4 = new String("AABB"); //在堆上创建对象AA、BB和AABB，在常量池上创建常量AA和BB
        String a6 = a4.intern();

        System.out.println(a6 == a5); //true

    }


}
