package com.example.administrator.myapplication;

/**
 * Created by Administrator on 2018/5/11.
 *
 * 希尔排序
 * 是简单插入排序经过改进之后的一个更高效的版本，也称为缩小增量排序,属于不稳定排序
 *
 * 原理：将待排序的数组元素分成多个子序列， 使得每个子序列的元素个数相对较少，
 * 然后对各个子序列分别进行直接插入排序
 *
 *
 * 希尔排序最好时间复杂度和平均时间复杂度都是O(nlogn)，最坏时间复杂度为O(n^2)
 *
 */

public class ShellSort {

    private static ShellSort sortIntance;

    private ShellSort() {}

    public static ShellSort getInstance(){
        if (sortIntance == null){
            synchronized (ShellSort.class){
                if (sortIntance == null){
                    sortIntance = new ShellSort();
                }
            }
        }
        return sortIntance;
    }


    /**
     * 希尔排序 针对有序序列在插入时采用交换法
     *
     * */
    public static void sort(int []arr){
        arr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};

        //gap 两个元素间的步长
        for (int gap = arr.length / 2; gap > 0 ; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                while(j - gap >= 0 && arr[j] < arr[j-gap]){
                    //插入排序采用交换法
                   SwapElementUtil.getInstance().swap(arr, j, j - gap);
                   j -= gap;
                }
            }
        }

    }

}
