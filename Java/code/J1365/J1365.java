package J1365;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class J1365 {

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
}
