import java.util.Arrays;

public class HeapSort {

    /**
     * 堆
     * 索引i的左节点2i + 1，右节点2i + 2
     * 索引i的父节点 Math.floor((i - 1) / 2)即向下取整
     * 先整体将数组构建成最大堆或者最小堆
     * 构建好后每次都将未排序数组的最后一位跟最大堆/最小堆的第一位交换位置
     * 交换好位置后重新构建最大堆或者最小堆
     * @param args
     */

    public static void main(String[] args) {
        Integer[] nums = { 8, 2, 5, 9, 7, 1, 4, 6, 7, 13, 1, 2, 3, 3, 4, 5};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(Integer[] nums) {
        int len = nums.length;
        // 先构建堆
        for (int i = len / 2; i >= 0; i--) {
            buildHeap(nums, i, len);
        }
        // 每次将头跟位替换数据，再重新排序
        for (int i = len - 1; i > 0; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            buildHeap(nums, 0, --len);
        }
    }

    public static void buildHeap(Integer[] nums, int index, int len) {
        // 左节点
        int left = 2 * index + 1;
        // 右节点
        int right = 2 * index + 2;
        int cur = index;
        // 先比较左节点跟当前节点的大小
        if (left < len && nums[left] > nums[cur]) {
            cur = left;
        }
        // 再已经比完左节点的基础上 再比较右节点的大小
        if (right < len && nums[right] > nums[cur]) {
            cur = right;
        }
        // 如果下标变了，则说明被替换过，交换位置，并且需要再判断子节点是否满足最大堆/最小堆的要求
        if (cur != index) {
            int temp = nums[cur];
            nums[cur] = nums[index];
            nums[index] = temp;
            buildHeap(nums, cur, len);
        }
    }

}
