//Minimum Insertion Steps to Make a String Palindrome

class Solution {
    public int minInsertions(String s) {
     
     String reverse = new StringBuilder(s).reverse().toString();
     int[][] dp = new int[s.length() + 1][s.length() + 1];
     
     for (int i = 1; i <= s.length(); i++) {
         for (int j = 1; j <= s.length(); j++) {
             if (s.charAt(i - 1) == reverse.charAt(j - 1)) {
                 dp[i][j] = dp[i - 1][j - 1] + 1;
             } else {
                 dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
             }
         }
     }
     return s.length() - dp[s.length()][s.length()];
 }
 
 
 }