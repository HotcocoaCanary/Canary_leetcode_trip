package datastructure;

public class MyMinHeap<T extends Comparable<T>> {
    private final T[] heap;
    private int size;
    private final int capacity;

    @SuppressWarnings("unchecked")
    public MyMinHeap(int capacity) {
        this.capacity = capacity;
        // Java 不支持直接 new T[]，需要通过 Object 数组强转
        this.heap = (T[]) new Comparable[capacity];
        this.size = 0;
    }

    // 插入数据
    public void insert(T data) {
        if (size == capacity) {
            throw new RuntimeException("heap is full");
        }
        heap[size] = data;
        shiftUp(size);
        size++;
    }


    // 取出最小元素
    public T extractMin() {
        if (size == 0) {
            throw new RuntimeException("heap is empty");
        }
        T min = heap[0];
        heap[0] = heap[size - 1]; // 将最后一个元素移到堆顶
        size--;
        shiftDown(0);
        return min;
    }


    // 当前数据量
    public int size() {
        return size;
    }

    // 是否为空
    public boolean isEmpty() {
        return size == 0;
    }


    private void shiftDown(int index) {
        while (2 * index + 1 < size) { // 只要有左孩子
            int j = 2 * index + 1; // j 指向较小的孩子，初始为左孩子
            if (j + 1 < size && heap[j + 1].compareTo(heap[j]) < 0) {
                j++; // 如果右孩子更小，指向右孩子
            }

            if (heap[index].compareTo(heap[j]) <= 0) break; // 父亲比孩子都大，结束

            swap(index, j);
            index = j; // 继续向下比较
        }
    }

    private void shiftUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap[index].compareTo(heap[parent]) >= 0) break;
            swap(index, parent);
            index = parent;
        }
    }

    private void swap(int i, int j) {
        T temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
