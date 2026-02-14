package J485;

public class J485 {
    // 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
    public int findMaxConsecutiveOnes(int[] nums) {
        int pre_sum = 0;
        int max_sum = 0;
        for (int num : nums) {
            if (num == 0) {
                max_sum = Math.max(max_sum, pre_sum);
                pre_sum = 0;
            } else {
                pre_sum += num;
            }
        }
        return Math.max(max_sum, pre_sum);
    }
}
