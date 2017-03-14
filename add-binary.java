public class Solution {
    public String addBinary(String a, String b) {
    	if (a == null || b == null)
    		return null;

        LinkedList<Integer> re = new LinkedList<>();
        if (a.length() < b.length()) {
        	a = fill(b, a) + a;
        } else if (b.length() < a.length()) {
        	b = fill(a, b) + b;
        }

        int indent = 0;
        for (int i = a.length() - 1; i >= 0; i--) {
        	int a_i = a.charAt(i) == '1' ? 1 : 0;
        	int b_i = b.charAt(i) == '1' ? 1 : 0;
        	switch (a_i + b_i + indent) {
        		case 0:	
        			re.addFirst(0);
        			indent = 0;
        			break;
        		case 1:
        			re.addFirst(1);
        			indent = 0;
        			break;
        		case 2:
        			re.addFirst(0);
        			indent = 1;
        			break;
        		case 3:
        			re.addFirst(1);
        			indent = 1;
        			break;
        	}
        }
        if (indent == 1)
        	re.addFirst(1);
        char[] buffer = new char[re.size()];
        Iterator it = re.iterator();
        int counter = 0;
        while (it.hasNext()) {
        	buffer[counter++] = (it.next().equals(1) ? '1' : '0');
        }
        return new String(buffer);
    }

    private String fill(String longer, String shorter) {
   	    char[] chars = new char[longer.length() - shorter.length()];
		Arrays.fill(chars, '0');
		return new String(chars);
    }
}