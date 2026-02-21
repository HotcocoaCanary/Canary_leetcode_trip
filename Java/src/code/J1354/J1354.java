package code.J1354;

import datastructure.MyMaxHeap;

public class J1354 {
    public boolean isPossible(int[] target) {
        MyMaxHeap<Long> maxHeap = new MyMaxHeap<>(target.length);

        long sum = 0;

        for (int i : target) {
            sum += i;
            maxHeap.insert((long) i);
        }

        while (true) {
            long max = maxHeap.extractMax();
            long rest = sum - max;

            if (max == 1 || rest == 1) return true;

            // 异常情况判定：
            // 1. 其余之和 rest < 1 (说明有非正数，不符合题意)
            // 2. max <= rest (说明最大值还没剩下的大，无法逆向还原)
            // 3. max % rest == 0 (说明无法还原到正整数状态，除非 rest 为 1，但上面已判断)
            if (rest < 1 || max <= rest || max % rest == 0) return false;

            long nextVal = max % rest;
            sum = rest + nextVal;
            maxHeap.insert(nextVal);
        }
    }
}
