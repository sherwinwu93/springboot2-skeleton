package com.wusd.skeleton.designpattern.adapter;

/**
 * @author wusd
 * @date 2020/1/12 20:04
 */
public class BinarySearch {
    public int binarySearch(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int midVal = array[mid];
            if (midVal < key) {
                low = mid + 1;
            } else if (midVal > key) {
                high = mid - 1;
            } else {
                return 1;
            }
        }
        return -1;
    }
}
