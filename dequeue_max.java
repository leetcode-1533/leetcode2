public class Solution {
	private Deque<Integer> deque;
	private int[] nums;

	private void add(int index) {
		while (deque.size() > 0 && nums[deque.getLast()] < nums[index]) {
			deque.removeLast();
		}
		deque.addLast(index);
	}

    public int[] maxSlidingWindow(int[] nums, int k) {
    	if (nums == null || nums.length <= 1) {
    		return nums;
    	}

    	this.nums = nums;
    	deque = new LinkedList<Integer>();
    	int[] re = new int[nums.length - k + 1];

    	for (int i = 0; i < k; i++) {
    		add(i);
    	}

    	for (int i = 0; i < re.length; i++) {
    		int lp = i;
    		int rp = i + k - 1;

    		while (deque.getFirst() < lp) {
    			deque.removeFirst();
    		}

    		re[i] = nums[deque.getFirst()];
    		
    		if (rp + 1 < nums.length) {
    		    add(rp + 1);
    		}
    	}
    	return re;
    }
}