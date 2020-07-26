package geektime.spring.demo.hellospring.jdk;

/**
 * jdk8 接口可以有默认实现。
 */
public interface NewPatch {

    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
