package com.example.administrator.myapplication;

import android.util.Log;

/**
 * Created by Administrator on 2018/5/10.
 *
 * 插入排序
 * 把待排序的数组，每个元素取出来，按照排序的要求，插入到前面已经排好序的有序序列中去，直到插完所有元素为止
 *
 * 其时间复杂度为O(n^2），稳定排序
 *
 * 在数组元素随机排列的情况下，插入排序要优于选择和冒泡排序
 */

public class InsertSort {

    private static volatile InsertSort sortIntance;

    private InsertSort() {}

    public static InsertSort getInstance(){
        if (sortIntance == null){
            synchronized (InsertSort.class){
                if (sortIntance == null){
                    sortIntance = new InsertSort();
                }
            }
        }
        return sortIntance;
    }

    public void sort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]){
                    SwapElementUtil.getInstance().swap(arr, j, j - 1);
                }
            }
        }
    }

}
