class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] result=new int[intervals.length+1][2];
        int i=0;
        int j=0;
        while(i<intervals.length && intervals[i][1]<newInterval[0]){
            result[j][0]=intervals[i][0];
            result[j][1]=intervals[i][1];
            i++;
            j++;
        }
        while(i<intervals.length && intervals[i][0]<=newInterval[1]){
            newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
            newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        result[j][0]=newInterval[0];
        result[j][1]=newInterval[1];
        j++;
        while(i<intervals.length){
            result[j][0]=intervals[i][0];
            result[j][1]=intervals[i][1];
            j++;
            i++;
        }
        return java.util.Arrays.copyOf(result,j);
    }
}
