class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        return solve(s1, s2, s3, s1.length(), s2.length());
    }
    public boolean solve(String s1, String s2, String s3, int i, int j) {
        if (i == 0 && j == 0) return true;
        int k = i + j; 
        if (i > 0 && s1.charAt(i - 1) == s3.charAt(k - 1)) {
            if (solve(s1, s2, s3, i - 1, j)) return true;
        }
        if (j > 0 && s2.charAt(j - 1) == s3.charAt(k - 1)) {
            if (solve(s1, s2, s3, i, j - 1)) return true;
        }
        return false;
    }
}
