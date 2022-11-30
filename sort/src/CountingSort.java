import java.util.Arrays;

public class CountingSort {

    /**
     * 计数
     * 统计原数组最大值
     * 开辟原数组最大值的新数组空间用来计数原数组中每个元素出现的次数
     * 根据新数组统计的元素数量，重新赋值回原数组
     * @param args
     */

    public static void main(String[] args) {
        Integer[] nums = { 8, 2, 5, 9, 7, 1, 4, 6, 7, 13, 1, 2, 3, 3, 4, 5};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(Integer[] nums) {
        int max = getMax(nums);
        int[] bucket = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            bucket[nums[i]] = bucket[nums[i]] + 1;
        }
        int j = 0;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i] > 0) {
                nums[j++] = i;
                bucket[i]--;
            }
        }
    }

    public static int getMax(Integer[] nums) {
        int max = 0;
        for (Integer num : nums) {
            max = num > max ? num : max;
        }
        return max;
    }


}
