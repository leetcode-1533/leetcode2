/**
 * public class NBCompare {
 *     public int cmp(String a, String b);
 * }
 * You can use compare.cmp(a, b) to compare nuts "a" and bolts "b",
 * if "a" is bigger than "b", it will return 1, else if they are equal,
 * it will return 0, else if "a" is smaller than "b", it will return -1.
 * When "a" is not a nut or "b" is not a bolt, it will return 2, which is not valid.
*/
public class Solution {
    /**
     * @param nuts: an array of integers
     * @param bolts: an array of integers
     * @param compare: a instance of Comparator
     * @return: nothing
     */
    public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
        // write your code here
        if (nuts == null || bolts == null)
        	return;
        	
        // for (String nut : nuts) {
        //     for (String bolt : bolts) {
        //         System.out.printf("%s, %s: %d\n", nut, bolt, compare.cmp(nut, bolt));
        //     }
        // }

        qsort(nuts, bolts, 0, nuts.length - 1, compare);
    }

    public void qsort(String[] nuts, String[] bolts, int li, int hi, NBComparator compare) {
    	if (li < hi) {
    		int j = nuts_partition(nuts, li, hi, bolts[li], compare);
    // 		System.out.println(j);
    // 		for (String nut : nuts) {
    // 		    System.out.printf("%s \t", nut);
    // 		}
    // 		System.out.println();
    		
    		bolts_partition(bolts, li, hi, nuts[j], compare);
    // 		for (String bolt : bolts) {
    // 		    System.out.printf("%s \t", bolt);
    // 		}
    // 		System.out.println();
    
    		qsort(nuts, bolts, li, j - 1, compare);
    		qsort(nuts, bolts, j + 1, hi, compare);
    	}
    }

    private int nuts_partition(String[] nuts, int li, int hi, String bolt, NBComparator compare) {
    	int i = li;
    	int j = hi;
    	while (true) {  
    		while (compare.cmp(nuts[i], bolt) == -1) {
    			i++;
    			if (i == hi) break;
    		}
    		while (compare.cmp(nuts[j], bolt) == 1) {
    			j--;
    			if (j == li) break;
    		}
    		if (i >= j) break;
    		exch(nuts, i, j);
    	}
    	return j;
    }

    private int bolts_partition(String[] bolts, int li, int hi, String nut, NBComparator compare) {
    	int i = li;
    	int j = hi;
    	while (true) {    	    
    		while (compare.cmp(nut, bolts[i]) == 1) {
    			i++;
    			if (i == hi) break;
    		} 
    		while (compare.cmp(nut, bolts[j]) == -1) {
    			j--;
    			if (j == li) break;
    		}
    		if (i >= j) break;
    		exch(bolts, i, j);
    	}
    	return j;
    }

    private void exch(String[] array, int i, int j) {
    	String temp = array[i];
    	array[i] = array[j];
    	array[j] = temp;
    }
};