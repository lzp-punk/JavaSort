package com.example.administrator.myapplication;

/**
 * Created by Administrator on 2018/5/10.
 *
 * 冒泡排序
 *
 * 对相邻的元素进行两两比较，顺序相反则进行交换
 *
 * 其时间复杂度为O(n^2）,稳定排序
 */

public class BubbleSort {

    private static volatile BubbleSort sortIntance;

    private BubbleSort() {}

    public static BubbleSort getInstance(){
        if (sortIntance == null){
            synchronized (BubbleSort.class){
                if (sortIntance == null){
                    sortIntance = new BubbleSort();
                }
            }
        }
        return sortIntance;
    }

    public void sort(int[] arr){
        for (int i = arr.length; i >= 0 ; i--) {
            boolean flag = true;
            for (int j = 0; j < i - 1; j++) {
                if (arr[j] > arr[j+1]){
                    SwapElementUtil.getInstance().swap(arr, j, j+1);
                    flag = false;
                }
            }
            if (flag){//如果一轮比较下去没有进行过元素的换位，说明数组已经排序完成，跳出循环
                break;
            }
        }
    }



}
