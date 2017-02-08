public class Solution {
    private class Trie {
        private class Node {
            private boolean value;
            private Node[] next = new Node[R]; // implicit
        }

        private static final int R = 256;
        private Node root = new Node();

        /** Initialize your data structure here. */
        public Trie() {

        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            put(root, word, 0);
        }

        private Node put (Node x, String word, int d) {
            if (x == null)
                x = new Node();
            if (d == word.length()) {
                x.value = true;
                return x;
            }

            char c = word.charAt(d);
            x.next[c] = put(x.next[c], word, d + 1);
            return x;
        }

        public boolean search(String word) {
            Node re = get(root, word, 0);
            return (re != null && re.value == true);
        }

        private Node get(Node x, String word, int d) {
            if (x == null) return null;
            if (d == word.length())
                return x;
            return get(x.next[word.charAt(d)], word, d + 1);
        }

        public boolean startsWith(String prefix) {
            Node re = get(root, prefix, 0);
            return (re != null);
        }
    }
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */

    // private int ij2index(int i, int j) {
    //     return i * ysize + j;
    // }

    // private int[] index2ij(int index) {
    //     int i = index / ysize;
    //     int j = index - ysize * i;
    //     return new int[]{i, j};
    // }

    private static boolean[][] marked;
    private static int i_size;
    private static int j_size;
    private static Trie trie;

    public static void dfs(char[][] grid, Trie trie, int[] node, String str, HashSet<String> container) {
        str = str + grid[node[0]][node[1]];
        marked[node[0]][node[1]] = true;

        int[] i_dir = new int[]{0, 0, -1, 1};
        int[] j_dir = new int[]{1, -1, 0, 0};

        if (!trie.startsWith(str)) {
            marked[node[0]][node[1]] = false;
            return;
        } else if (trie.search(str)) {
            container.add(str);
        }

            for (int i = 0; i < 4; i++) {
                int i_next = node[0] + i_dir[i];
                int j_next = node[1] + j_dir[i];
                if (i_next < i_size && i_next >= 0 &&
                        j_next < j_size && j_next >= 0 &&
                        !marked[i_next][j_next]) {
                        dfs(grid, trie, new int[]{i_next, j_next}, str, container);
                }
            }

        marked[node[0]][node[1]] = false;
    }

    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        marked = new boolean[board.length][board[0].length];
        trie = new Trie();
        for (String item : words) {
            trie.insert(item);
        }
        HashSet<String> temp = new HashSet<>();

        i_size = board.length;
        j_size = board[0].length;

       // write your code here
        for (int i = 0; i < i_size; i++) {
            for (int j = 0; j < j_size; j++) {
                dfs(board, trie, new int[] {i, j}, "", temp);
            }
        }
        ArrayList<String> container = new ArrayList<>(temp.size());
        for (String item : temp) {
            container.add(item);
        }
        return container;
    }

    // public static void main(String[] args) {
    //     dfs_grid sol = new dfs_grid();
    //     char[][] test = new char[][] {
    //             "ABCE".toCharArray(),
    //             "SFES".toCharArray(),
    //             "ADEE".toCharArray()
    //     };
    //     boolean re = sol.exist(test, "ABCESEEEFS");
    //     System.out.println(re);
    // }

}