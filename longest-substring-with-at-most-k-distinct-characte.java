public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
		int start = 0;
		int diff = 0;
		int[] counter = new int[256];
		int best = 0;

    	for (int i = 0 ; i < s.length(); i++) {
    		if (counter[s.charAt(i)] == 0) {
    			diff++;
    		}

    		counter[s.charAt(i)]++;

    		while (diff > k) {
    			if (counter[s.charAt(start)] > 0) {
    				counter[s.charAt(start)]--;
    				if (counter[s.charAt(start)] == 0) {
    					diff--;
    				}
    				start++;
    			}
    		}

    	best = Math.max(best, i - start);
    	}
    }
}