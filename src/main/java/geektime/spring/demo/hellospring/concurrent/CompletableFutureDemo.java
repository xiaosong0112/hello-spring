package geektime.spring.demo.hellospring.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.BiFunction;

/**
 * java异步编程  https://www.jianshu.com/p/6bac52527ca4  详解
 */
public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // completableFuture  supplyAsync 返回结果
        CompletableFuture<String> ft1 = CompletableFuture.supplyAsync(() -> {

            System.out.println("ft1在洗水壶");

            System.out.println("ft1在烧开水");

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "茶碗";
        });

        CompletableFuture<String> ft2 = CompletableFuture.supplyAsync(() -> {

            System.out.println("ft2洗茶壶");
            System.out.println("ft2洗茶杯");
            System.out.println("ft2拿茶叶");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "茉莉花茶";
        });

        CompletableFuture<String> f3 = ft1.thenCombine(ft2, new BiFunction<String, String, String>() {

            @Override
            public String apply(String s1, String s2) {
                return "放在" + s1 + "泡好的" + s2;
            }
        });

        System.out.println(f3.get());

    }
}
