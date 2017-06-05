public class Solution {
    public int maximalRectangle(char[][] matrix) {
    	if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
    		return 0;

        cal_max_byrow(matrix);
    }

    private int cal_max_byrow(char[][] matrix) {
    	int row = matrix.length;
    	int col = matrix[0].length;
    	int re = 0;

    	int[] cal_vec = matrix[0].clone();
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

    private int cal_max_hist(int[] hist) {
        Deque<Integer> queue = new ArrayDeque<Integer>();
        int re = 0;
        for (int i = 0; i < hist.length; i++) {
            if (queue.size() == 0 || hist[i] >= hist[queue.peekFirst()])
                queue.offerFirst(i);
            else {
                while (queue.size() != 0 && hist[i] < hist[queue.peekFirst()]) {
                    int start_i = queue.peekLast();
                    int end_i = queue.peekFirst();
                    int current_capacity = (end_i - start_i + 1) * hist[start_i];
                    re = re > current_capacity ? re : current_capacity;
                    queue.pollFirst();
                }
                queue.offerFirst(i);
            }
        }
        int start_i = queue.peekLast();
        int end_i = queue.peekFirst();
        int current_capacity = (end_i - start_i + 1) * hist[start_i];
        re = re > current_capacity ? re : current_capacity;
        return re;
    }
}