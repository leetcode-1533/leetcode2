public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        return cal_max_byrow(matrix);
    }

    private int cal_max_byrow(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int re = 0;

        int[] cal_vec = new int[matrix[0].length]; 
        for (int i = 0; i < matrix[0].length; i++) {
            cal_vec[i] = (matrix[0][i] == '0' ? 0 : 1);    
        }
        
        re = cal_max_hist(cal_vec);
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '0')
                    cal_vec[j] = 0;
                else 
                    cal_vec[j] += 1;
            }
            int current_capacity = cal_max_hist(cal_vec);
            re = re > current_capacity ? re : current_capacity;
        }
        return re;
    }

    private int cal_max_hist(int[] heights) {
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