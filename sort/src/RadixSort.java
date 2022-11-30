import java.util.Arrays;

public class RadixSort {

    /**
     * 基数
     * 通过按元素值的位数切分放在不同的桶在来实现排序
     * 位数从小到大开始比较
     * @param args
     */

    public static void main(String[] args) {
        Integer[] nums = { 8, 2, 5, 9, 7, 1, 4, 6, 7, 13, 1, 2, 3, 3, 4, 5};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(Integer[] nums) {
        // 获取数组中最大值
        int max = getMax(nums);
        // 获取数组中最大值的长度
        int maxLen = getMaxLen(max);
        // 取模大小
        int mod = 10;
        // 除数大小
        int dev = 1;
        for (int i = 0; i < maxLen; i++) {
            int[][] temp = new int[10][0];
            // 计算当前元素的基数需要放在哪个下标的桶里
            for (int j = 0; j < nums.length; j++) {
                int index = nums[j] % mod / dev;
                // 原桶大小扩容1来存放新元素
                int[] tempNum = Arrays.copyOf(temp[index], temp[index].length + 1);
                tempNum[tempNum.length - 1] = nums[j];
                temp[index] = tempNum;
            }
            int index = 0;
            for (int[] n1 : temp) {
                for (int n : n1) {
                    nums[index++] = n;
                }
            }
            mod *= 10;
            dev *= 10;
        }
    }

    public static int getMax(Integer[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
        }
        return max;
    }

    public static int getMaxLen(int num) {
        int max = 0;
        for (int i = num; i != 0; i /= 10) {
            max++;
        }
        return max;
    }

}
