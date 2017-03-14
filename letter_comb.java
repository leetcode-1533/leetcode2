public class Solution {
	private HashMap<Character, String> map = new HashMap<Character, String>() {{
		put('2', "abc");
		put('3', "def");
		put('4', "ghi");
		put('5', "jkl");
		put('6', "mno");
		put('7', "pqrs");
		put('8', "tuv");
		put('9', "wxyz");
	}};

    public List<String> letterCombinations(String digits) {
    	List<String> re = new LinkedList<>();
    	for (int i = 0; i < digits.length(); i++) {
    		re = append(re, map.get(digits.charAt(i)));
    	}
    	return re;
    }

    private List<String> append(List<String> li, String letters) {
    	if (li.size() == 0) {
    		for (int i = 0; i < letters.length(); i++) {
    			li.add("" + letters.charAt(i));
    		}
    		return li;
    	} else {
    		List<String> re = new LinkedList<>();
    		for (String buffer : li)
				for (int i = 0; i < letters.length(); i++) {
    				re.add(buffer + letters.charAt(i));
    			}
    			return re;
    		}
    	}
}