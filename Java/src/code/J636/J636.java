package code.J636;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class J636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[n];
        int prevTime = 0;
        for (String str : logs) {
            String[] split = str.split(":");
            int function_id = Integer.parseInt(split[0]);
            String op = split[1];
            int time = Integer.parseInt(split[2]);

            if (op.equals("start")) {
                if (!deque.isEmpty()) {
                    res[deque.peek()] += time - prevTime;
                }
                deque.push(function_id);
                prevTime = time;
            }
            if (op.equals("end")) {
                res[deque.pop()] += time - prevTime + 1;
                prevTime = time + 1;
            }
        }
        return res;
    }

}
