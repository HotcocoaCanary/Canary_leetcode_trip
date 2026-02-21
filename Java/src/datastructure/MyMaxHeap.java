package datastructure;

// 限制 T 必须是可比较的
public class MyMaxHeap<T extends Comparable<T>> {
    private final T[] heap; // 泛型无法直接 new T[]，需用 Object[]
    private int size;
    private final int capacity;

    @SuppressWarnings("unchecked")
    public MyMaxHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = (T[]) new Comparable[capacity];
    }

    // 插入元素
    public void insert(T data) {
        if (size == capacity) {
            throw new RuntimeException("heap is full");
        }
        heap[size] = data;
        shiftUp(size);
        size++;
    }

    // 取出最大元素
    public T extractMax() {
        if (size == 0) {
            throw new RuntimeException("heap is empty");
        }
        T max = (T) heap[0];
        heap[0] = heap[size - 1];
        size--;
        shiftDown(0);
        return max;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 向下调整
    private void shiftDown(int index) {
        while (2 * index + 1 < size) {
            int j = 2 * index + 1;

            if (j + 1 < size && heap[j + 1].compareTo(heap[j]) > 0) {
                j++;
            }

            if (heap[index].compareTo(heap[j]) >= 0) break;

            swap(index, j);
            index = j;
        }
    }

    private void shiftUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            // heap[index] <= heap[parent] 变为 compareTo <= 0
            if (heap[index].compareTo(heap[parent]) <= 0) break;
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