import java.util.Arrays;

public class BucketSort {

    /**
     * 桶
     * 计数排序的升级版
     * 计数排序只能作用于元素个数较小的情况，当元素过多，上百或者上千、万，则不可能开辟那么多个桶
     * 自定义每个桶能存在不同元素的个数，再根据原数组中最大值跟最小值计算需要桶的个数
     * 遍历原数组，算出每个元素应该放在哪个桶里
     * 所有元素都放入各自桶后，各个桶内部再进行一次排序，最终设置回原数组，原数组则是排好序的状态
     * @param args
     */

    public static void main(String[] args) {
        Integer[] nums = { 8, 2, 5, 9, 7, 1, 4, 6, 7, 13, 1, 2, 3, 3, 4, 5};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(Integer[] nums) {
        // 每个桶能放不同元素的个数
        int bucketSize = 5;
        int max = 0;
        int min = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            } else if (nums[i] < min){
                min = nums[i];
            }
        }
        // 计算桶个数
        int bucketCount = (max - min) / bucketSize + 1;
        int[][] bucket = new int[bucketCount][0];
        for (int i = 0; i < nums.length; i++) {
            // 当前元素要放到哪个桶里
            int index = (nums[i] - min) / bucketSize;
            // 复制原桶上数组，size加1，将待排序的元素插入到数组最后中
            int[] tempNums = Arrays.copyOf(bucket[index], bucket[index].length + 1);
            tempNums[tempNums.length - 1] = nums[i];
            bucket[index] = tempNums;
        }
        int index = 0;
        for (int[] buck : bucket) {
            if (buck.length <= 0) {
                continue;
            }
            // 每个桶内部利用排序算法重新进行排序
            insertSort(buck);
            for (int b : buck) {
                nums[index++] = b;
            }
        }
    }

    public static int[] insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int index = i;
            int arr = nums[i];
            while (index > 0 && arr < nums[index - 1]) {
                nums[index] = nums[index - 1];
                index--;
            }
            if (index != i) {
                nums[index] = arr;
            }
        }
        return nums;
    }

}
