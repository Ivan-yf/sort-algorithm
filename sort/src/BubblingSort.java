import java.util.Arrays;

public class BubblingSort {

    /**
     * 冒泡
     * 从左到右比较相邻元素，前面元素比后面元素大则交换位置，到最后一个下标，则是最大的元素
     * 重复上述步骤，因为上一步的最右一个元素已是最大，所以此次遍历只需要遍历到nums.length - 1 - 1
     * @param args
     */

    public static void main(String[] args) {
        Integer[] nums = { 8, 2, 5, 9, 7 };
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(Integer[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }
}
