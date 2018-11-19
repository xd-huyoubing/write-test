package edu.xidian.searchtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_350 {

    /**
     * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
     *
     * 设nums1的长度为l1,nums2的长度为l2,
     * 用方法一：不考虑从list遍历到数组，则时间复杂度为O(l1+l2)
     * 用方式二：不考虑从list遍历到数组，则时间复杂度为O(l1)
     *
     * 如果nums2的元素存储在磁盘上，内存是有限的，你不能一次加载所有的元素到内存中，你该怎么办？
     * 　　如果nums2的元素多到无法一次性加载到内存中，那我们应该：
     *
     * 　　1、将nums1中的数字初始化计数器。
     *
     * 　　2、使用缓冲流读取文件的一部分数据，计数器中有记录且记录的次数大于1，将该数字新增到结果数组中，计数器中该数字记录的次数减1，这样完成了这一部分数据的统计。
     *
     * 　　3、接着再读取文件中下一部分数据，重复步骤2。
     *
     *
     */


    /**
     * 方式二：如果给定的数组已经排好序呢？你将如何优化你的算法？
     * 思路：如果给定的数组是有序的，也就是两个数组都是有序的，那么两个指针就可以解决了
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect1(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        int c1 = 0, c2 = 0;
        while (c1 < nums1.length && c2 < nums2.length) {
            if (nums1[c1] == nums2[c2]) {
                list.add(nums1[c1]);
                c1++;
                c2++;
            } else if (nums1[c1] > nums2[c2]) {
                c2++;
            } else {
                c1++;
            }
        }


        int[] arr = new int[list.size()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;

    }

    /**
     * 方式一：没有经过优化的
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i]))
                map.put(nums1[i], map.get(nums1[i]) + 1);
            else
                map.put(nums1[i], 1);
        }


        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
                list.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }

        int[] arr = new int[list.size()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;

    }

    public static void main(String[] args) {
        int[] nums1 = {4, 5, 9};
        int[] nums2 = {4, 4, 8, 9, 9};
        LeetCode_350 leetCode = new LeetCode_350();

        int[] intersect = leetCode.intersect1(nums1, nums2);

        for (int i = 0; i < intersect.length; i++) {
            System.out.print(intersect[i] + "  ");
        }

    }

}
