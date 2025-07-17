package com.wusd.skeleton.designpattern.adapter;

/**
 * @author wusd
 * @date 2020/1/12 20:08
 */
public class OperationAdapter implements ScoreOperation {
    private QuickSort sortObj;
    private BinarySearch searchObj;

    public OperationAdapter() {
        this.sortObj = new QuickSort();
        this.searchObj = new BinarySearch();
    }

    @Override
    public int[] sort(int[] array) {
        return sortObj.quickSort(array);
    }

    @Override
    public int search(int[] array, int key) {
        return searchObj.binarySearch(array, key);
    }
}
