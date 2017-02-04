public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
    	int best = 0;
        // write your code here
        int[][] memory = new int[A.length() + 1][];
        memory[0] = new int[B.length() + 1];
        for (int i = 1; i <= A.length(); i++) {
            memory[i] = new int[B.length() + 1];
        	for (int j = 1; j <= B.length(); j++) {
        		if (A.charAt(i - 1) == B.charAt(j - 1)) {
        			memory[i][j] = memory[i - 1][j - 1] + 1;
        			best = Math.max(best, memory[i][j]);
        		}
        	}
        }
        return best;
    }
}