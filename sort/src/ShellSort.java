import java.util.Arrays;

public class ShellSort {

    /**
     * 希尔
     * 选择一个增量（一般是length/2）依次比较相隔增量的值
     * 经过一次增量比较后，再将增量/2再比较一次，直到增量为1
     * @param args
     */

    public static void main(String[] args) {
        Integer[] nums = { 8, 2, 5, 9, 7, 1, 4, 6, 7, 13, 1, 2, 3, 3, 4, 5};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(Integer[] nums) {
        // 定义增量，并循环逐步缩小增量
        for (int i = nums.length / 2; i > 0; i /= 2) {
            // 只需要从增量开始的地方往前进行比较
            // 利用插入排序的思想，只不过往前比较的下标是根据增量进行跳跃
            for (int j = i; j < nums.length; j++) {
                int arr = nums[j];
                int z = j;
                while (z - i >= 0 && arr < nums[z - i]) {
                    nums[z] = nums[z - i];
                    z -= i;
                }
                nums[z] = arr;
            }
        }
    }

}
