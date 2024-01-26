public class LongestCommonSubsequence {

    public static int longestCommonSubsequence(String text1, String text2) {
        char[] string1 = text1.toCharArray();
        char[] string2 = text2.toCharArray();

        int m = string1.length;
        int n = string2.length;

        int[][] table = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (string1[i - 1] == string2[j - 1]) {
                    table[i][j] = table[i - 1][j - 1] + 1;
                } else {
                    table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
                }
            }
        }

        return table[m][n];
    }

    public static void main(String[] args) {
        String text1 = "abc";
        String text2 = "abc";
        System.out.println(longestCommonSubsequence(text1, text2));  // Output: 3

        text1 = "almanacs";
        text2 = "albatross";
        System.out.println(longestCommonSubsequence(text1, text2));  // Output: 4

        text1 = "almanac";
        text2 = "ferris";
        System.out.println(longestCommonSubsequence(text1, text2));  // Output: 0
    }
}