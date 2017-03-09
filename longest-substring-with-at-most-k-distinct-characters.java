class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null) {
            return 0;
        }
        
    	HashMap<Character, Integer> occurence = new HashMap<>(k);
    	int bestl = 0;
    	for (int i = 0, j = 0; j < s.length(); j++) {
    		if (occurence.containsKey(s.charAt(j))) {
    			occurence.put(s.charAt(j), occurence.get(s.charAt(j)) + 1);
    		} else {
    			occurence.put(s.charAt(j), 1);
    		}
    		while (occurence.size() > k) {
    			if (occurence.get(s.charAt(i)) == 1) {
    				occurence.remove(s.charAt(i));
    			} else {
    				occurence.put(s.charAt(i), occurence.get(s.charAt(i)) - 1);
    			}
    			i++;
    		}
    		bestl = Math.max(bestl, j - i + 1);
    	}
    	return bestl;      
    }
}