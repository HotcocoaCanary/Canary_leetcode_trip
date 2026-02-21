package code.J1700;

import java.util.LinkedList;
import java.util.Queue;

public class J1700 {

    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new LinkedList<>();
        for (int student : students) {
            queue.offer(student);
        }
        for (int sandwich : sandwiches) {
            int r = 0;
            while (!queue.isEmpty() && queue.peek() != sandwich){
                if (r == queue.size()) {
                    break;
                }
                queue.offer(queue.poll());
                r++;
            }
            if (!queue.isEmpty() && queue.peek() != sandwich) {
                return queue.size();
            }
            queue.poll();
        }
        return queue.size();
    }
}
