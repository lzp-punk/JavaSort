package com.example.administrator.myapplication;

import android.util.Log;

/**
 * Created by Administrator on 2018/5/10
 *
 * 选择排序.
 * 每一趟从待排序的数据元素中选择最小（或最大）的一个元素作为首元素，直到所有元素排完为止
 *
 * 简单选择排序是不稳定排序，在还未完全确定当前最小元素之前，这些交换都是无意义的
 *
 * 其时间复杂度为O(n^2）
 */

public class SelectSort {


    private static SelectSort sortIntance;

    private SelectSort() {}

    public static synchronized SelectSort getInstance(){
        if (sortIntance == null){
            sortIntance = new SelectSort();
        }
        return sortIntance;
    }

    public void sort(int[] arr){
        arr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]){
                    min = j;
                }
            }
            if (i != min){
                SwapElementUtil.getInstance().swap(arr, i, min);
            }
        }

    }


}
