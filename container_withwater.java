public class Solution {
    public int maxArea(int[] height) {
    	if (height == null || height.length == 0) {
    		return 0;
    	}

    	int i = 0, j = height.length - 1;
    	int size = 0;
    	while (i < j) {
    		int temp = (j - i) * Math.min(height[i], height[j]);
    		size = Math.max(size, temp);

    		if (height[i] < height[j]) {
    			i++; 
    		} else {
    			j--;
    		}
    	}
    	return size;
        
    }
}