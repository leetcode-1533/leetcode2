public class Trie {
    private static class Node {
        private boolean value;
        private Node[] next = new Node[R]; // implicit
    }

    private static final int R = 256;
    private Node root;

    /** Initialize your data structure here. */
    public Trie() {
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        put(root, word, 0);
    }

    private Node put (Node x, String word, int d) {
        if (x == NULL) 
            x = new Node();
        if (d == word.length) {
            x.value = true;
            return x;
        }

        char c = word.charAt(d);
        x.next[c] = put(x.next[c], word, d + 1);
        return x;
    }
    
    public boolean search(String word) {
        Node re = get(root, prefix, 0);
        return (re != null && re.value == true);
    }

    private Node get(Node x, String word, int d) {
        if (x === null) return null;
        if (d == word.length)
            return x;
        return get(x.next[word.charAt(d)], word, d + 1);
    }
    
    public boolean startsWith(String prefix) {
        Node re = get(root, prefix, 0);
        return (re != null);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */