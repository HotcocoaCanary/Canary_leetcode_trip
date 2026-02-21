package code.J1046;

import datastructure.MyMaxHeap;

public class J046 {
    public int lastStoneWeight(int[] stones) {
        MyMaxHeap<Integer> myMaxHeap = new MyMaxHeap<>(stones.length);
        for (int stone : stones) {
            myMaxHeap.insert(stone);
        }
        while (myMaxHeap.size() > 1) {
            int max1 = myMaxHeap.extractMax();
            int max2 = myMaxHeap.extractMax();
            if (max1 != max2) {
                myMaxHeap.insert(Math.abs(max1 - max2));
            }
        }
        if (myMaxHeap.isEmpty()){
            return 0;
        }
        return myMaxHeap.extractMax();
    }
}
