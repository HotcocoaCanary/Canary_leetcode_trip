package J84;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class J84 {
    /// 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
    /// 求在该柱状图中，能够勾勒出来的矩形的最大面积。
    public int largestRectangleArea(int[] heights) {
        //暴力
//        int max = 0;
//        for (int i = 0; i < heights.length; i++) {
//            int left = i;
//            int right = i;
//            for (; left >= 0; left--) {
//                if (heights[left] < heights[i]) {
//                    break;
//                }
//            }
//            for (; right < heights.length; right++) {
//                if (heights[right] < heights[i]) {
//                    break;
//                }
//            }
//            int wide = right - left - 1;
//            max = Math.max(max, wide * heights[i]);
//        }
//        return max;
        int max = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] newHeights = new int[heights.length + 2];
        System.arraycopy(heights, 0, newHeights, 1, heights.length);
        heights = newHeights;
        stack.push(0);
        for (int i = 1; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int height = heights[stack.pop()];
                int left = stack.peek();
                int width = i - left - 1;
                max = Math.max(max, height * width);
            }
            stack.push(i);
        }
        return max;
    }
}
