public class Solution {
    public int lengthLongestPath(String input) {
    	Stack<Integer> stack = new Stack<Integer>();
    	int re = 0;

    	String[] inputs = input.split("\n");
    	for (String item : inputs) {
    		int level = item.lastIndexOf("\t") + 1;
    		while (stack.size() != level)
    			stack.pop();
    		int len = item.length - level;
    		if (stack.isEmpty()) {
    			stack.push(len);
    		} else {
    			stack.push(stack.peek() + len);
    		}

    		if (item.contains(".")) {
    			re = Math.max(re, stack.peek() + stack.size() - 1);
    		}
    	} 
    	return re;  
    }
}