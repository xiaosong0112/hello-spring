package geektime.spring.demo.hellospring.algorithm.divideconquer;

/**
 * 求x的n次方
 */
public class Pow {

    /**
     * 分治的方法求x的n次方
     * @param x
     * @param n
     * @return
     */
    public int pow(int x, int n) {

        // 如果n=0 则直接返回1
        if (n == 0) {

            return 1;
        }

        // 如果小于0则直接返回 函数计算过得 pow(x, -n) 分之1
        if (n < 0) {

            return 1 / pow(x, -n);
        }

        // 下面进入算法主体，全都是正数的情况。
        // 如果n是偶数
        int half = pow(x, n / 2);

        if (n % 2 == 0) {

            return half * half;
        } else {

            return half * half * x;
        }
    }
}
