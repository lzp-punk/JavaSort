package com.example.administrator.myapplication;

public class SwapElementUtil {

    private SwapElementUtil() {}

    public static SwapElementUtil getInstance(){
        return SwapElementUtilInner.instance;
    }
    private static class SwapElementUtilInner{
        private static SwapElementUtil instance = new SwapElementUtil();
    }

    /**
     * 交换数组元素
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int[]arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
