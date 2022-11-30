import java.util.Arrays;

public class MergeSort {

    /**
     * 归并（分治法）
     * 将数组依次折半拆分成最小子数组
     * 通过最小子数组之间的比较，还原成排序数组
     * @param args
     */

    public static void main(String[] args) {
        Integer[] nums = { 8, 2, 5, 9, 7 };
        sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(Integer[] nums, int left, int right) {
        if (left < right) {
            // 折半
            int mid = (left + right) / 2;
            // 递归处理左半边数据
            sort(nums, left, mid);
            // 递归处理右半边数据
            sort(nums,mid + 1, right);
            // 处理两个数组
            merge(nums, left, mid, right);
        }
    }

    public static void merge(Integer[] nums, int left, int mid, int right) {
        int lStart = left;
        int rStart = mid + 1;
        // 临时变量存储比较后数的数组，最终再讲临时变量的数据覆盖到对应原数组的下标位置上，即完成排序替换
        Integer[] temp = new Integer[right - left + 1];
        int index= 0;
        while (lStart <= mid && rStart <= right) {
            if (nums[lStart] <= nums[rStart]) {
                temp[index++] = nums[lStart++];
            } else {
                temp[index++] = nums[rStart++];
            }
        }
        while (lStart <= mid) {
            temp[index++] = nums[lStart++];
        }
        while (rStart <= right) {
            temp[index++] = nums[rStart++];
        }
        for (int i = 0; i < temp.length; i++) {
            nums[left++] = temp[i];
        }
    }


}
