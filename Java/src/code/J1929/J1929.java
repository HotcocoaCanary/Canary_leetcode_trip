package code.J1929;

public class J1929 {

    /**
     * 给你一个长度为 n 的整数数组 nums。
     * <p>
     * 请你构建一个长度为 2n 的答案数组 ans ，数组下标 从 0 开始计数 ，对于所有 0 <= i < n 的 i ，满足下述所有要求：
     * <p>
     * ans[i] == nums[i]
     * <p>
     * ans[i + n] == nums[i]
     * <p>
     * 具体而言，ans 由两个 nums 数组 串联 形成。
     *
     * @param nums
     * @return ans
     */
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i];
            ans[i + nums.length] = nums[i];
        }
        return ans;
    }
}
