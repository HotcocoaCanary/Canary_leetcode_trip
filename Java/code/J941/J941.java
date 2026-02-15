package J941;

public class J941 {

    //    给定一个整数数组 arr，如果它是有效的山脉数组就返回 true，否则返回 false。
//
//    让我们回顾一下，如果 arr 满足下述条件，那么它是一个山脉数组：
//
//    arr.length >= 3
//    在 0 < i < arr.length - 1 条件下，存在 i 使得：
//    arr[0] < arr[1] < ... arr[i-1] < arr[i]
//    arr[i] > arr[i+1] > ... > arr[arr.length - 1]
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 2) {
            return false;
        }
        int i = 0;
        for (; i < arr.length - 1; i++) {
            if (arr[i] >= arr[i + 1]) {
                break;
            }
        }
        for (int j = i; j < arr.length - 1; j++) {
            if (arr[j] <= arr[j + 1]) {
                return false;
            }
        }
        return i != 0 && i != arr.length - 1;
    }
}
