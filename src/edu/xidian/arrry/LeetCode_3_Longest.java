package edu.xidian.arrry;

public class LeetCode_3_Longest {
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[256];
        int l = 0, r = -1;//在滑动窗口[l...r]上寻找满足条件的字符串
        int len = 0;
        while (l < s.length()) {
            if (r + 1 < s.length() && freq[s.charAt(r + 1)] == 0) {
                freq[s.charAt(++r)] = 1;
            } else {
                freq[s.charAt(l)] = 0;
                l++;
            }
            len = Math.max(len, r - l + 1);
        }
        return len;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        LeetCode_3_Longest longest = new LeetCode_3_Longest();

        int length = longest.lengthOfLongestSubstring(s);

        System.out.println(length);
    }

}
