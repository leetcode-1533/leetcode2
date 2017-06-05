public class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;

        Stack<Integer> stack = new Stack<>();
        int re = 0;
        int i = 0;
        while (i < heights.length) {
            if (stack.size() == 0 || heights[i] >= heights[stack.peek()]) {
                stack.push(i++);
            } else {
                int t = stack.pop();
                re = Math.max(re, heights[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }
        while (stack.size() != 0) {
            int t = stack.pop();
            re = Math.max(re, heights[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
        }
        return re;
    }
}