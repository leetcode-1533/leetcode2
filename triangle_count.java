import java.util.*;
public class triangle_count {
    private int maxbound(int[] nums, int target, int lp, int rp) {
	    if (nums == null || nums.length == 0)
	        return -1;

	    int mean = rp;
	    while (rp - lp > 1) {
	        mean = lp + (rp - lp) / 2;
	        if (target < nums[mean])
	            rp = mean;
	        else
	            lp = mean;
	    }
		if (nums[rp] <= target)
			return rp;
		else if (nums[lp] <= target)
			return lp;
		else 
			return -1;
    }

	private int minbound(int[] nums, int target, int lp, int rp) {
	    if (nums == null || nums.length == 0)
	        return -1;

	    int mean = lp;
	    while (rp - lp > 1) {
	        mean = lp + (rp - lp) / 2;
	        if (target > nums[mean])
	            lp = mean;
	        else
	            rp = mean;
	    }
		if (nums[lp] >= target)
			return lp;
		else if (nums[rp] >= target)
			return rp; 
		else 
			return -1;
    }
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int[] S) {
    	if (S == null || S.length < 3) 
    		return -1;
        // write your code here
        int[] s = S.clone();
        Arrays.sort(s);

        int re = 0;
        for (int i = 0; i < s.length - 2; i++) {
        	for (int j = i + 1; j < s.length - 1; j++) {
        		int minbound = s[j] - s[i];
        		int maxbound = s[j] + s[i];

        		int min_p = minbound(s, minbound + 1, j + 1, s.length - 1);
        		int max_p = maxbound(s, maxbound - 1, j + 1, s.length - 1);
        		System.out.printf("i %d, j %d, min_p %d, max_p %d\n", i, j, min_p, max_p);
        		if (min_p > -1 && max_p > -1 && max_p >= min_p) {
        			re += (max_p - min_p + 1);
        		}

        	}
        }
        return re;
    }

    public static void main(String[] args) {
    	triangle_count test = new triangle_count();
    	int re = test.triangleCount(new int[]{4,4 ,4 ,4});
    	System.out.println(re);
    }


}
