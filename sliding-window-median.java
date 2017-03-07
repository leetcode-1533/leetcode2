import java.util.*;

class Solution {
    private class median_stream {
        PriorityQueue<Integer> lower = new PriorityQueue<>(1, Collections.reverseOrder());
        PriorityQueue<Integer> higher = new PriorityQueue<>();

        void balance() {
            while (lower.size() >= (higher.size() + 2)) {
                higher.offer(lower.poll());
            }

            while (higher.size() >= (lower.size() + 2)) {
                lower.offer(higher.poll());
            }
        }

        void add(int val) {
            if (lower.size() == 0 || val < lower.peek()) {
                lower.add(val);
            } else {
                higher.add(val);
            }
            balance();
        }

        void remove(int val) {
            if (val <= lower.peek()) {
                lower.remove(val);
            } else {
                higher.remove(val);
            }

            balance();
        }

        double median() {
            int k = lower.size() + higher.size();
            if (k % 2 == 0) {
                double t1 = lower.peek();
                double t2 = higher.peek();
                return (t1 + t2) / 2.0;
            } else {
                return lower.size() > higher.size() ? lower.peek() : higher.peek();
            }
        }
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        median_stream buffer = new median_stream();
        double[] re = new double[nums.length - k + 1];

        for (int i = 0; i < k; i++) {
            buffer.add(nums[i]);
        }

        for (int i = 0; i < re.length; i++) {
            re[i] = buffer.median();
            if ((i + k) < nums.length) {
                buffer.add(nums[i + k]);
                buffer.remove(nums[i]);
            }
        }

        return re;
    }
    public static void main(String[] args) {
        int[] test = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 1;
        Solution sol = new Solution();
        double[] re = sol.medianSlidingWindow(test, 1);
        for (double item : re) {
            System.out.printf("%f\t", item);
        }
    }
}