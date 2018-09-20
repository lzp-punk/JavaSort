package com.example.administrator.myapplication;

/**
 * Created by Administrator on 2018/6/4.
 *
 * 基数排序
 *
 * 稳定排序
 *
 * 是一种非比较型整数排序算法，其原理是将整数按位数切割成不同的数字，然后按每个位数分别比较
 * 时间复杂度为O(n·log n)
 */

public class RadixSort {

    private static RadixSort sortIntance;

    private RadixSort() {}

    public static synchronized RadixSort getInstance(){
        if (sortIntance == null){
            sortIntance = new RadixSort();
        }
        return sortIntance;
    }

    public void sort(int[] arr){
        arr = new int[]{74, 62, 2, 1915, 85416515, 15515, 4454, 55, 66, 88, 71, 554};

        radixSort(arr, 100000000);
    }

    /**
     *
     * @param level 待排序数组中最大的那个数，或者比他高一位的整数位，比如最大数是99， level传入100
     *
     * */
    private void radixSort(int[] arr, int level){
        int n = 1;//位数，个位，十位，百位。。。
        int[][] temp = new int[10][arr.length];//十个桶，每个桶深度为arr.length
        int[] order = new int[10];//记录每个桶中有多少个元素，总共10个桶
        while (n < level){
            for (int num : arr){
                //获取元素在第n位的值
                int value = num / n % 10;
                //order[value]初始值为0，第value个桶中的第x(order[value])个元素是num
                temp[value][order[value]] = num;
                order[value]++;//第value个桶中的元素个数+1
            }
            int index = 0;
            for (int i = 0; i < 10; i++) {//遍历十个的桶
                if (order[i] > 0){//如果桶里面的元素个数大于0
                    for (int j = 0; j < order[i]; j++) {
                        arr[index] = temp[i][j];
                        index++;
                    }
                }
                order[i] = 0;//清空桶里的元素
            }
            n = n * 10;
        }
    }

}
