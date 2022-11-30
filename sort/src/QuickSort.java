import java.util.Arrays;

public class QuickSort {

    /**
     * 快速
     * 找到一个基准数（一般是最左或者最右）
     * 最左：先从右到左找到小于基准数的值，再从左到右找到大于基准数的值，两者替换，不断循环直到左下标大于等于右下标，再根据基准数区分开两边的数据，进行递归
     * 最右：先从左到右找到大于基准数的值，再从右到左找到小于基准数的值，两者替换，不断循环直到左下标大于等于右下标，再根据基准数区分开两边的数据，进行递归
     * @param args
     */

    public static void main(String[] args) {
        Integer[] nums = { 8, 2, 5, 9, 7 };
        sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(Integer[] nums, int left, int right) {
        int dp;
        if (left < right) {
            dp = partition(nums, left, right);
            sort(nums, left, dp - 1);
            sort(nums, dp + 1, right);
        }
    }

    public static int partition(Integer[] nums, int left, int right) {
        int index = left;
        int p = nums[left];
        while (left < right) {
            // 先从右到左找到小于基准数
            while (left < right && p <= nums[right]) {
                right--;
            }
            // 再从左到右找到大于基准数
            while (left < right && p >= nums[left]) {
                left++;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        // 将基准数替换到目标下标位置
        nums[index] = nums[left];
        nums[left] = p;
        return left;
    }

}
