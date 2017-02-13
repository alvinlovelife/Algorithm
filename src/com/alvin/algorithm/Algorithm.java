package com.alvin.algorithm;

/**
 * @Author: Alvin
 * @Project_name Algorithm
 * @Package_name: com.alvin.algorithm
 * @Type_name Algorithm
 * @Date: 2017/2/13
 * @TODO:  常用算法
 */
public class Algorithm {
    public static void main(String arg[]){
        int[] a = {3,2,5,1,4,6,7,9,8};
        bubbleSort(a);
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+" ");
    }

    //冒泡排序
    public static void bubbleSort(int[] a) {
        int temp = 0;
        for (int i = a.length - 1; i > 0; --i) {
            for (int j = 0; j < i; ++j) {
                if (a[j + 1] < a[j]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;

                }
            }
        }
    }
    //选择排序
    public static void selectSort(int[] a){
        for(int i=0;i<a.length;i++){
            int temp=0,min=i;
            for(int j=i+1;j<a.length;j++){
                if(a[j]<a[min])	min=j;
            }
            temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }
    //直接插入排序
    public static void straitSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            // 待插入元素
            int temp = a[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                // 将大于temp的往后移动一位
                if (a[j] > temp) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = temp;
        }
    }
    //直接插入排序2
    public static void straitSort2(int[] a){
        int temp = 0;
        for(int i=1; i<a.length; i++){
            for(int j=i; j>0; j--){
                if(a[j]<a[j-1]) {
                    temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }
    }
    //快速排序
    public static void quickSort(int[] numbers, int start, int end){
        if(start < end) {
            int base = numbers[start];
            int temp;
            int i = start, j = end;
            do {
                while ((numbers[i] < base) && (i<end))
                    i++;
                while ((numbers[j] > base) && (j >start))
                    j--;
                if(i<=j) {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                    i++;
                    j--;
                }
            }while(i<=j);
            if(start <j){
                quickSort(numbers,start,j);
            }
            if(end >i){
                quickSort(numbers,i,end);
            }
        }
    }
}
