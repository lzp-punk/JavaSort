package com.example.administrator.myapplication;

import android.util.Log;

import java.util.logging.Logger;

/**
 * Created by Administrator on 2018/5/9.
 *
 * 归并排序
 * 把数组不断对半分解，最后把两个不同的小数组根据要求排序合并起来
 *
 * 归并排序是稳定排序，它也是一种十分高效的排序，能利用完全二叉树特性的排序
 * 平均时间复杂度为O(nlogn)
 */

public class MergeSort {

    private static MergeSort sortIntance;

    private MergeSort() {}

    public static synchronized MergeSort getInstance(){
        if (sortIntance == null){
            sortIntance = new MergeSort();
        }
        return sortIntance;
    }

    public void sort(int[] arr){
        arr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] temp = new int[arr.length];
        sort(arr, temp, 0, arr.length - 1);
    }

    private void sort(int[] arr, int[] temp, int left, int right){
        if (right > left){
            int mid = (right + left)/2;
            sort(arr, temp, left, mid);
            sort(arr, temp, mid + 1, right);
            merge(arr, temp, left, right, mid);
        }
    }


    private void merge(int[] arr,int[] temp, int left, int right, int mid){
        int x = left;
        int y = mid + 1;
        int z = 0;
        while (x <= mid && y <= right){
            if (arr[x] <= arr[y]){
                temp[z++] = arr[x++];
            }else{
                temp[z++] = arr[y++];
            }
        }
        while (x <= mid){
            temp[z++] = arr[x++];
        }
        while (y <= right){
            temp[z++] = arr[y++];
        }
        z = 0;
        while (left <= right){
            arr[left++] = temp[z++];
        }
    }

}
