/*
 * <aside>
💡 **Question 6**

Given two strings s and p, return *an array of all the start indices of* p*'s anagrams in* s. You may return the answer in **any order**.

An **Anagram** is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

**Example 1:**

**Input:** s = "cbaebabacd", p = "abc"

**Output:** [0,6]

**Explanation:**

The substring with start index = 0 is "cba", which is an anagram of "abc".

The substring with start index = 6 is "bac", which is an anagram of "abc".

</aside>
 * 
 */
package in.ineuron.gouthami;

import java.util.ArrayList;
import java.util.List;

public class AnagramIndices {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> indices = new ArrayList<>();

        if (s.length() < p.length()) {
            return indices;
        }

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        for (char ch : p.toCharArray()) {
            pCount[ch - 'a']++;
        }

        for (int i = 0; i < p.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
        }

        if (matches(pCount, sCount)) {
            indices.add(0);
        }

        for (int i = p.length(); i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
            sCount[s.charAt(i - p.length()) - 'a']--;

            if (matches(pCount, sCount)) {
                indices.add(i - p.length() + 1);
            }
        }

        return indices;
    }

    private static boolean matches(int[] pCount, int[] sCount) {
        for (int i = 0; i < 26; i++) {
            if (pCount[i] != sCount[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        List<Integer> indices = findAnagrams(s, p);
        System.out.println("Anagram indices ::"+indices);
    }
}
