/**
 * <aside>
💡 **Question 3**

Given two strings word1 and word2, return *the minimum number of **steps** required to make* word1 *and* word2 *the same*.

In one **step**, you can delete exactly one character in either string.

**Example 1:**

**Input:** word1 = "sea", word2 = "eat"

**Output:** 2

**Explanation:** You need one step to make "sea" to "ea" and another step to make "eat" to "ea".

</aside>
 * 
 */
package in.ineuron.gouthami;


public class MinimumStepsToDelete {
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        int[][] dp = new int[m+1][n+1];
        
        // Fill the first row
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j-1] + 1;
        }
        
        // Fill the first column
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i-1][0] + 1;
        }
        
        // Fill the remaining cells
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j] + 1, dp[i][j-1] + 1);
                }
            }
        }
        
        return dp[m][n];
    }
    
    public static void main(String[] args) {
        String word1 = "sea";
        String word2 = "eat";
        int result = minDistance(word1, word2);
        System.out.println("Minimum Steps to Delete a string is ::"+result);
    }
}


