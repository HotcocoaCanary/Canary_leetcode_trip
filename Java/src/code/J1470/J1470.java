package code.J1470;

public class J1470 {
    //    给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
    //
    //    请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];
        int i = 0;
        for (int j = 0; j < n; j++) {
            ans[i++] = nums[j];
            ans[i++] = nums[j + n];
        }
        return ans;
    }
}
