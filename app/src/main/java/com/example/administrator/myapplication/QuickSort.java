package com.example.administrator.myapplication;

/**
 * Created by Administrator on 2018/5/29.
 *
 * 快速排序
 *
 * 通过一趟排序将待排序记录分割成独立的两部分，其中一部分记录的关键字均比另一部分关键字小，则分别对这两部分继续进行排序，直到整个序列有序
 *
 * 快速排序是通常被认为在同数量级（O(nlogn)）的排序方法中平均性能最好的。
 * 但若初始序列按关键码有序或基本有序时，快排序反而蜕化为冒泡排序。
 * 为改进之，通常以“三者取中法”来选取基准记录，即将排序区间的两个端点与中点三个记录关键码居中的调整为支点记录
 *
 * 快速排序平均时间复杂度也为O(nlogn)， 不稳定排序
 *
 */

public class QuickSort {


    private static QuickSort sortIntance;

    private QuickSort() {}

    public static synchronized QuickSort getInstance(){
        if (sortIntance == null){
            sortIntance = new QuickSort();
        }
        return sortIntance;
    }



    public void sort(int[] arr){
        arr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};

        quickSort(arr, 0, arr.length - 1);
    }

    //递归形式的分治排序算法
    private void quickSort(int[] arr, int left, int right){
        if (left < right){
            int middle = sortAndGetMiddle(arr, left, right);
            quickSort(arr, left, middle - 1);
            quickSort(arr, middle + 1, right);
        }
    }


    /**
     * 通过一趟排序，查找出中轴（默认是最低位low）的在numbers数组排序后所在位置，
     * 左边的都比中轴小，右边的都比中轴大，然后递归继续把左边和右边的快排
     *
     * @param arr 带查找数组
     * @param left   开始位置
     * @param right  结束位置
     * @return  中轴所在位置
     */
    private int sortAndGetMiddle(int[] arr, int left, int right){
        int key = arr[left];//默认数组的第一个作为中轴
        while (left < right){
            while (left < right && key <= arr[right]){
                right--;
            }
            arr[left] = arr[right];//比中轴小的元素赋值到低位
            while (left < right && key > arr[left]){
                left++;
            }
            arr[right] = arr[left];//比中轴大的元素赋值到高位
        }
        arr[left] = key;
        return left;
    }

}
