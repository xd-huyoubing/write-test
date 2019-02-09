package edu.xidian.binarysearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author 有兵
 * @date 2019/1/26 18:01
 */
public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int[] nums = new int[10];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(100);
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "\t");
        }
        System.out.println();
        BST<Integer> bst = new BST<>();
        for (int i = 0; i < nums.length; i++) {
            bst.addNR(nums[i]);
        }

        bst.preOrder();
        System.out.println("---------------");
        bst.inOrder();
        System.out.println("---------------");
        bst.postOrder();
        System.out.println("---------------");

        System.out.println("*******************************************");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(bst.removeMax());
        }
        System.out.println(list);
    }
}
