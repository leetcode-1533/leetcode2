public class Solution {
    // using quick select to find the kth largest element
    // put the smaller value on the left and larger value on the right
    public int findKthLargest(int[] nums, int k) {
        int[] num2 = nums.clone();
        k = nums.length - k;
  		
  		int li = 0, hi = num2.length - 1;
  		while (hi > li) {
  			int j = shuffle(num2, li, hi);
  			if (j < k) li = j + 1;
  			else if (j > k) hi = j - 1;
  			else return num2[k];
  		}

        return num2[k];
    }

    public int shuffle(int[] nums, int li, int ri) {
        int i = li, j = ri + 1;
        while (true) {
            while (nums[++i] < nums[li])
                if (i == ri) break;

            while (nums[li] < nums[--j])
                if (j == li) break;

            if (i >= j) break;
            exchange(nums, i, j);
        }
        exchange(nums, li, j);
        return j;
    }

    private void exchange(int[] nums, int p1, int p2) {
        int temp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = temp;
    }

}