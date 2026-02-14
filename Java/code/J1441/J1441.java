package J1441;

import java.util.ArrayList;
import java.util.List;

public class J1441 {

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
}
