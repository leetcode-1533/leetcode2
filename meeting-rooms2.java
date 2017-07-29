/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
	class timePoint implements Comparable<timePoint>{
		int time;
		boolean isStart;

		public timePoint(int time, boolean isStart) {
			this.time = time;
			this.isStart = isStart;
		}

		public int compareTo(timePoint that) {
			if (this.time == that.time) {
				if (this.isStart)
					return 1;
				else 
					return -1;
			}
			else 
				return this.time - that.time;
		}
	}

    public int minMeetingRooms(Interval[] intervals) {
    	List<timePoint> scanlines = new ArrayList<>(intervals.length * 2);
    	for (Interval item : intervals) {
    		scanlines.add(new timePoint(item.start, true));
    		scanlines.add(new timePoint(item.end, false));
    	}
    	Collections.sort(scanlines);

    	int currentroom = 0;
    	int maxroom = 0;
    	for (timePoint item : scanlines) {
    		if (item.isStart) {
    			currentroom++;
    			maxroom = Math.max(maxroom, currentroom);
    		} else {
    			currentroom--;
    		}
    	}

    	return maxroom;
    }
}