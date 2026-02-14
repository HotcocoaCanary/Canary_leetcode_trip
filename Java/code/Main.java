import java.util.*;

class Solution {

//    给你一个长度为 n 的整数数组 nums 。请你构建一个长度为 2n 的答案数组 ans ，数组下标 从 0 开始计数 ，对于所有 0 <= i < n 的 i ，满足下述所有要求：
//
//    ans[i] == nums[i]
//    ans[i + n] == nums[i]
//    具体而言，ans 由两个 nums 数组 串联 形成。
//
//    返回数组 ans 。

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

    public int[] smallerNumbersThanCurrent(int[] nums) {
//        int[] res = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] > nums[j]) {
//                    res[i]++;
//                }
//            }
//        }
//        return res;

//        int[] cnt = new int[101];
//        int n = nums.length;
//
//        for (int x : nums) {
//            cnt[x]++;
//        }
//
//        for (int i = 1; i <= 100; i++) {
//            cnt[i] += cnt[i - 1];
//        }
//
//        int[] res = new int[n];
//        for (int i = 0; i < n; i++) {
//            res[i] = nums[i] == 0 ? 0 : cnt[nums[i] - 1];
//        }
//
//        return res;

        int[] nums2 = nums.clone();
        Arrays.sort(nums2);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])) {
                int num = map.get(nums2[i]);
                map.put(nums2[i], Math.min(num, i));
            } else {
                map.put(nums2[i], i);
            }
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = map.get(nums[i]);
        }
        return res;
    }

    // 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }

    public List<String> buildArray(int[] target, int n) {
//        List<String> res = new ArrayList<>();
//        int current = 1;
//        for (int num : target) {
//            if (num != current) {
//                while (current < num) {
//                    res.add("Push");
//                    res.add("Pop");
//                    current++;
//                }
//            }
//            res.add("Push");
//            current++;
//        }
//        return res;
        List<String> res = new ArrayList<>();
        int[] ans = new int[n];
        for (int i : target) {
            ans[i - 1] = 1;
        }

        int index = 0;
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] == 1) {
                index = i;
            }
        }

        for (int i = 0; i <= index; i++) {
            res.add("Push");
            if (ans[i] == 0) {
                res.add("Pop");
            }
        }
        return res;
    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String s : tokens) {
            if ("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s)) {
                int num2 = stack.pop();
                int num1 = stack.pop();

                switch (s) {
                    case "+": stack.push(num1 + num2); break;
                    case "-": stack.push(num1 - num2); break;
                    case "*": stack.push(num1 * num2); break;
                    case "/": stack.push(num1 / num2); break;
                }
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[n];
        int prevTime = 0;
        for (String str : logs) {
            String[] split = str.split(":");
            int function_id = Integer.parseInt(split[0]);
            String op = split[1];
            int time = Integer.parseInt(split[2]);

            if (op.equals("start")){
                if (!deque.isEmpty()){
                    res[deque.peek()] += time - prevTime;
                }
                deque.push(function_id);
                prevTime = time;
            }
            if(op.equals("end")){
                res[deque.pop()] += time - prevTime + 1;
                prevTime = time + 1;
            }
        }
        return res;
    }

}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 5, 1, 3, 4, 7};
        int n = 3;
        solution.shuffle(nums, n);
    }
}