package edu.xidian.arrry;

import java.util.Arrays;

/**
 * 明确每一个变量的含义  是写出一个不出错误的程序的前提
 * @author huyoubing
 * @param <E>
 */

public class BinarySearch<E extends Comparable<E>> {

    //在 闭区间[l..r]上搜索
    public int binarySearchNR(E[] arr, E target) {
        //在区间[l...r]上搜索目标target
        int l = 0, r = arr.length - 1;

        //当l == r 时，这个区间还是有效的  还有一个元素存在
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid].compareTo(target) > 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    //递归实现二分搜索
    public int binarySearch(E[] arr, E target, int l, int r) {
        if (l > r) {
            return -1;
        }
        int mid = l + (r - l) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid].compareTo(target) > 0) {
            return binarySearch(arr, target, l, mid - 1);
        } else {
            return binarySearch(arr, target, mid + 1, r);
        }
    }


    public static void main(String[] args) {
        int n = 10;
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        BinarySearch<Integer> binarySearch = new BinarySearch<>();
        int res = binarySearch.binarySearch(arr, 8, 0, arr.length - 1);
        System.out.println("binarySearch: " + res);
        int searchNR = binarySearch.binarySearchNR(arr, 8);
        System.out.println("binarySearchNR: " + searchNR);
    }
}
