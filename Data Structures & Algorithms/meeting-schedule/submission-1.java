/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        Comparator comparator=new Comparator<Interval>(){
            public int compare(Interval i1,Interval i2){
                return i1.start-i2.start;
            }
        };
        Collections.sort(intervals,comparator);
        for(int i=0;i<intervals.size()-1;i++){
            if(intervals.get(i+1).start<intervals.get(i).end){
                return false;
            }
        }
        return true;
    }
}
