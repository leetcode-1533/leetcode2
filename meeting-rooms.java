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

    public boolean canAttendMeetings(Interval[] intervals) {
    	List<timePoint> scanLines = new ArrayList<timePoint>(intervals.length);
    	for (Interval item : intervals) {
    		scanLines.add(new timePoint(item.start, true));
    		scanLines.add(new timePoint(item.end, false));
    	}

    	Collections.sort(scanLines);
    	boolean lastStatus = false;
    	for (timePoint item : scanLines) {
    		if (item.isStart == lastStatus) 
    			return false;
            else
                lastStatus = item.isStart;
    	}

    	return true;
    }
}