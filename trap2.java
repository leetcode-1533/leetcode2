import java.util.*;

class Solution_trap {
    class node implements Comparable<node> {
        int x, y;
        int[][] board;
        int height;
        public node(int x, int y, int[][] board) {
            this.x = x;
            this.y = y;
            this.height = board[x][y];
            this.board = board;
        }

        List<node> getNeighbors() {
            // get any valid neighbor
            int[] x_next = new int[]{0, 0, 1, -1};
            int[] y_next = new int[]{1, -1, 0, 0};

            List<node> re = new ArrayList<node>(4);

            for (int i = 0; i < 4; i++) {
                if (isvalid(x + x_next[i], y + y_next[i])) {
                    node temp = new node(x + x_next[i], y + y_next[i], board);
                    re.add(temp);
                }
            }
            return re;
        }

        private boolean isvalid(int x, int y) {
            return (x >= 0 && y >= 0 && x < board.length && y < board[0].length);
        }

        @Override
        public int hashCode() {
            return x * board[0].length + y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            node that = (node) obj;
            return (x == that.x && y == that.y);
        }

        @Override
        public int compareTo(node that) {
            return (this.height - that.height);
        }
    }

    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length <= 2 || heightMap[0].length <= 2)
            return 0;

        int x_size = heightMap.length;
        int y_size = heightMap[0].length;

        HashSet<node> visisted = new HashSet<>();
        PriorityQueue<node> pq = new PriorityQueue<>();

        for (int i = 1; i < x_size - 1; i++) {
            node node_l = new node(i, 0, heightMap);
            node node_r = new node(i, y_size - 1, heightMap);
            pq.offer(node_l);
            pq.offer(node_r);
            visisted.add(node_l);
            visisted.add(node_r);
        }

        for (int i = 1; i < y_size - 1; i++) {
            node node_u = new node(0, i, heightMap);
            node node_d = new node(x_size - 1, i, heightMap);
            pq.offer(node_u);
            pq.offer(node_d);
            visisted.add(node_u);
            visisted.add(node_d);
        }

        int[] cor_x = new int[]{0, 0, x_size - 1, x_size - 1};
        int[] cor_y = new int[]{0, y_size - 1, 0, y_size - 1};
        for (int i = 0; i < 4; i++) {
            node temp = new node(cor_x[i], cor_y[i], heightMap);
            pq.offer(temp);
            visisted.add(temp);
        }

        int re = 0;
        int max_h = pq.peek().height;


        while (visisted.size() < (x_size * y_size)) {
            max_h = pq.peek().height; // current sea level

            node current = pq.poll();
            for (node item : current.getNeighbors()) {
                // BFS
                if (!visisted.contains(item)) {
                    if (max_h > item.height) {
                        re += (max_h - item.height);
                        item.height = max_h; // filling in water
                    }

                    pq.offer(item);
                    visisted.add(item);
                }
            }
        }

        return re;
    }

    public static void main(String[] args) {
        int[][] test = new int[][] {
                {5, 5, 5, 1},
                {5, 1, 1, 5},
                {5, 1, 5, 5,},
                {5, 2, 5, 8}
        };

        Solution_trap sol = new Solution_trap();
        int re = sol.trapRainWater(test);
        System.out.print(re);
    }
}