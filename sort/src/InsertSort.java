import java.util.Arrays;

public class InsertSort {

    /**
     * 插入（每次取未排序数组的第一个跟已排序从右到左一一做比较后插入）
     * 将数组逻辑上分成未排序跟已排序两个模块
     * 在未排序数组中，取第一个值，跟已排序的数组一一左比较进行插入
     * @param args
     */

    public static void main(String[] args) {
        Integer[] nums = { 8, 2, 5, 9, 7 };
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(Integer[] nums) {
        for (int i = 1; i < nums.length; i++) {
            // 核心思想是将当前未排序的值将已排序值集合进行一一比较
            // 记录当前需要比较的值跟下标值
            // 后续跟已排序比较都是通过当前记录的值去比较
            // 当前下标值小于前一个下标值时，将当前值替换成前一个下标值，再往前比较
            int arr = nums[i];
            int j = i;
            while (j > 0 && arr < nums[j - 1]) {
                nums[j] = nums[j - 1];
                j--;
            }
            if (j != i) {
                nums[j] = arr;
            }
        }
    }

}
