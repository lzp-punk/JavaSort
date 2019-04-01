package com.example.administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.HashMap;

public class Test {

    public static void main(String[] args){
        Test test = new Test();
        test.sort();
    }

    private void sort(){
        int[] arr = new int[]{5, 2, 1, 6, 9, 4, 3, 8, 7};
        HeapSort.getInstance().sort(arr);
    }

}
