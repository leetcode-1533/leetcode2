import java.util.*;

public class two_sum_ii {
    /**
     * @param nums: an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public int twoSum2(int[] nums, int target) {
        // Write your code here
        int[] temp = nums.clone();
        Arrays.sort(temp);
        int count = 0;
        for (int i = temp.length - 1; i >= 0; i--) {
        	// int j = temp.length() - i; // increment by one each time
        	int j = 0;
        	while (j < i && temp[i] + temp[j] <= target) 
        		j++;
        	// System.out.printf("i: %d, j: %d\n", i, j);
        	if (temp[i] + temp[j] > target) {
	        	// System.out.printf("**i: %d, j: %d\n", i, j);
        	    count += i - j;
        	}
        }
        return count;
    }

    public static void main(String[] args) {
    	two_sum_ii sol = new two_sum_ii();
    	int re = sol.twoSum2(new int[] {0, -1, 1}, 0);
    	System.out.println(re);
    }
}