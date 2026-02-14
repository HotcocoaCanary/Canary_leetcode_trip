package J645;

public class J645 {

    //集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
    //
    //给定一个数组 nums 代表了该集合发生错误后的结果。
    //
    //你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
    public int[] findErrorNums(int[] nums) {
        int errorNum = 0, notFoundNum = 0;
        int[] res = new int[nums.length];
        for (int num : nums) {
            res[num - 1]++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (res[i] == 0) {
                notFoundNum = i + 1;
            }
            if (res[i] == 2) {
                errorNum = i + 1;
            }
        }
        return new int[]{errorNum, notFoundNum};
    }
}
