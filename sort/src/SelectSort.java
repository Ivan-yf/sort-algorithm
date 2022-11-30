import java.util.Arrays;

public class SelectSort {

    /**
     * 选择（每次选择未排序的最大值，放置到已排序的最后）
     * 将数组逻辑上分成未排序跟已排序两个模块
     * 在未排序数组中，找到一个最大或者最小的数放在已排序数组末尾，不断重复，直到未排序数组为空
     * @param args
     */

    public static void main(String[] args) {
        Integer[] nums = { 8, 2, 5, 9, 7 };
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(Integer[] nums) {
        // 总共需要比较n - 1轮
        for (int i = 0; i < nums.length - 1; i++) {
            // 记录每轮最小下标
            int index = i;
            // 每轮都是从i + 1下标开始，比到最后
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[index] > nums[j]) {
                    index = j;
                }
            }
            if (index != i) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
            }
        }
    }

}
