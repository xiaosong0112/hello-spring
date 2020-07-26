package geektime.spring.demo.hellospring.algorithm.array;

/**
 * 接雨水
 * https://leetcode-cn.com/problems/trapping-rain-water/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-8/  题解
 */
public class Trap {

    /**
     * 给定高度参数 解法1 按照行来解
     * @param height
     * @return
     */
    public int trap(int[] height) {

        if (height == null || height.length < 2) {

            return 0;
        }

        // 求数组最大的高度，后续进行遍历。
        int max = getMax(height);//找到最大的高度，以便遍历。

        // 用于累加每行的结果。当出现
        int sum = 0;

        // 按照行扫描的话，height这个数组要扫描length - 1次
        for (int i = 0; i < max; i++) {

            // 默认记录开关为false。 当遇到height大于1的时候，flag标识标记为true。
            boolean flag = false;

            // 累加的数
            int temp = 0;

            // j代表每次扫描的时候的列。
            for (int j = 0 ; j < height.length; j++) {

                // 如果开关还没有开启，并且当前列的高度大于当前遍历的行的高度。
                if (height[j] > i && !flag) {

                    flag = true;
                    continue;
                }

                // 当开关开启后，并且当前列的高度小于当前遍历的行的高度
                if (height[j] <= i && flag) {

                    temp = temp + 1;
                    continue;
                }

                if (height[j] > i && flag) {

                    // 对雨滴的结果进行累加。
                    flag = false;
                    sum = sum + temp;
                    temp = 0;
                }
            }
        }

        return sum;
    }

    /**
     * 获取最高的高度，确定按行遍历几次。
     * @param height
     * @return
     */
    private int getMax(int[] height) {

        int max = 0;

        for (int i = 0; i < height.length; i++) {

            if (height[i] > max) {
                max = height[i];
            }
        }
        return max;
    }

    /**
     * 解法2 按照列去解
     * @param height
     * @return
     */
    public int trap2(int[] height) {

        int sum = 0;

        //最两端的列不用考虑，因为一定不会有水。所以下标从 1 到 length - 2
        for (int i = 1; i < height.length - 1; i++) {

            int max_left = 0;

            //找出左边最高
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > max_left) {
                    max_left = height[j];
                }
            }

            int max_right = 0;

            //找出右边最高
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > max_right) {
                    max_right = height[j];
                }
            }

            //找出两端较小的
            int min = Math.min(max_left, max_right);

            //只有较小的一段大于当前列的高度才会有水，其他情况不会有水
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        int[] param = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        Trap trap = new Trap();
        int result = trap.trap(param);
        System.out.println(result);
    }
}
