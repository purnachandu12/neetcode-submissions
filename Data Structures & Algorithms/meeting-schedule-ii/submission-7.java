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
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((a, b) -> a.start - b.start);
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        for(int i=0;i<intervals.size();i++){
            if(queue.isEmpty()!=true && queue.peek()<=intervals.get(i).start){
                queue.remove();
            }
            queue.add(intervals.get(i).end);
        }
        return queue.size();
    }
}

