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
                    return -1;
                else 
                    return 1;
            }
            else 
                return this.time - that.time;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        List<timePoint> scanlines = new ArrayList<>(intervals.size() * 2);
        for (Interval item : intervals) {
            scanlines.add(new timePoint(item.start, true));
            scanlines.add(new timePoint(item.end, false));
        }
        Collections.sort(scanlines);
                
        int currentIntervals = 0;
        int current_start = 0;

        List<Interval> re = new ArrayList<>();
        for (timePoint item : scanlines) { 
            if (item.isStart) {
                if (currentIntervals == 0)
                    current_start = item.time;
                currentIntervals++;
            } else {
                currentIntervals--;
                if (currentIntervals == 0) 
                    re.add(new Interval(current_start, item.time));
            }            
        }

        return re;
    }
}