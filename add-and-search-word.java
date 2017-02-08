public class WordDictionary {
    private class Node {
        private boolean value;
        private Node[] next = new Node[R]; // implicit
    }

    private static final int R = 26;
    private Node root = new Node();

    /** Inserts a word into the trie. */
    public void addWord(String word) {
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
        x.next[c - 'a'] = put(x.next[c - 'a'], word, d + 1);
        return x;
    }

    public boolean search(String word) {
        return get(root, word, 0);
    }

    private boolean get(Node x, String word, int d) {
        if (x == null) return false;

        if (d == word.length()) {
            return x.value;
        }

        if (word.charAt(d) != '.') {
            return get(x.next[word.charAt(d) - 'a'], word, d + 1);
        } else {
            boolean re = false; 
            for (Node x_next : x.next) {
                if (x_next != null) {
                    re = re || get(x_next, word, d + 1);
                }
            }
            return re;
        }
    }

    // public boolean startsWith(String prefix) {
    //     Node re = get(root, prefix, 0);
    //     return (re != null);
    // }
}
