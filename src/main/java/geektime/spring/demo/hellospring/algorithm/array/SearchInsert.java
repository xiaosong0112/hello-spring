package geektime.spring.demo.hellospring.algorithm.array;

public class SearchInsert {

    public int searchInsert(int[] nums, int target) {

        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {

        int[] array = {1};

        int target = 0;

        SearchInsert searchInsert = new SearchInsert();
        int result = searchInsert.searchInsert(array, target);
    }
}
