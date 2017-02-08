/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
	class node implements Comparable<Node> {
		final int time;
		final boolean start;
		public node(int time, boolean start) {
			this.time = time;
			this.start = start;
		}	
		public int CompareTo<Node>(Node that) {
			if (this.time == that.time) {
				if (!this.start)
					return -1;
				else 
					return 1;
			} else {
				return this.time - that.time;
			}
		}
	}
    /**
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) { 
        // write your code here

        ArrayList<node> re = new ArrayList<>(airplanes.length());
        for (Interval inter : airplanes) {
        	re.add(new node(inter.start, true));
        	re.add(new ndoe(inter.end, false));
        }

        Collections.sort(re);

        int count = 0;
        int max_count = 0;
        for (node item : re) {
        	if (node.start) {
        		count++;
        	} else {
        		count--;
        	}
        	max_count = Math.max(count, max_count);
        } 
        return max_count;
    }
}