package lcr.J061;

import datastructure.MyMinHeap;

import java.util.*;

class Node implements Comparable<Node> {
    int sum;
    int i; // nums1 的索引
    int j; // nums2 的索引

    public Node(int sum, int i, int j) {
        this.sum = sum;
        this.i = i;
        this.j = j;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.sum, other.sum);
    }
}

public class J061 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int heapCap = Math.min(nums1.length, k);
        MyMinHeap<Node> minHeap = new MyMinHeap<>(heapCap);
        for (int i = 0; i < heapCap; i++) {
            minHeap.insert(new Node(nums1[i] + nums2[0], i, 0));
        }
        while (k > 0 && !minHeap.isEmpty()) {
            Node cur = minHeap.extractMin();

            List<Integer> pair = new ArrayList<>();
            pair.add(nums1[cur.i]);
            pair.add(nums2[cur.j]);
            result.add(pair);

            k--;

            if (cur.j + 1 < nums2.length) {
                minHeap.insert(new Node(nums1[cur.i] + nums2[cur.j + 1], cur.i, cur.j + 1));
            }
        }

        return result;
    }
}
