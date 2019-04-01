package com.example.administrator.myapplication;

/**
 * Created by Administrator on 2018/5/25.
 *
 * 堆排序
 *
 * 堆排序的基本思想是：将待排序序列构造成一个大顶堆，此时，整个序列的最大值就是堆顶的根节点。将其与末尾元素进行交换，此时末尾就为最大值。
 * 然后将剩余n-1个元素重新构造成一个堆，这样会得到n个元素的次小值。如此反复执行，便能得到一个有序序列了
 *
 * 堆排序是一种选择排序，它的最坏，最好，平均时间复杂度均为O(nlogn)，它也是不稳定排序
 */

public class HeapSort {

    private static volatile HeapSort sortIntance;

    private HeapSort() {}

    public static HeapSort getInstance(){
        if (sortIntance == null){
            synchronized (HeapSort.class){
                if (sortIntance == null){
                    sortIntance = new HeapSort();
                }
            }
        }
        return sortIntance;
    }


    public void sort(int[] arr){
        for (int i = arr.length - 1; i > 0; i--) {
            buildHeap(arr, i);
            SwapElementUtil.getInstance().swap(arr, 0, i);
        }
    }

    /**
     *                      5
     *              2                1
     *         6        9       4           3
     *    8         7
     *
     * 构建大顶堆
     * */
    public void buildHeap(int[] arr, int endIndex){
        for (int i = (endIndex + 1)/2 - 1; i >= 0; i--) {//堆排序的所有非叶子节点
            int tempIndex;
            if (2 * i + 2 <= endIndex && arr[2 * i + 2] > arr[2 * i + 1]){
                tempIndex = 2;
            }else{
                tempIndex = 1;
            }

            if (arr[2 * i + tempIndex] > arr[i]){
                SwapElementUtil.getInstance().swap(arr, i, 2 * i + tempIndex);
            }
        }
    }


}
