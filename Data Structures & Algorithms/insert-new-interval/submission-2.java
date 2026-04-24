class Solution {
    public int[][] insert(int[][] interval, int[] newInterval) {
        ArrayList<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<interval.length;i++){
         if(newInterval==null || interval[i][1]<newInterval[0]){
            result.add(new ArrayList<>(Arrays.asList(interval[i][0],interval[i][1])));
         }
         else if(interval[i][0]>newInterval[1]){
            result.add(new ArrayList<>(Arrays.asList(newInterval[0],newInterval[1])));
            result.add(new ArrayList<>(Arrays.asList(interval[i][0],interval[i][1])));
            newInterval=null;
         }
         else{
            newInterval[0]=Math.min(newInterval[0],interval[i][0]);
            newInterval[1]=Math.max(newInterval[1],interval[i][1]);
         }   
        }
        if(newInterval!=null){
            result.add(new ArrayList<>(Arrays.asList(newInterval[0],newInterval[1])));
        }
        int[][] answer=new int[result.size()][2];
        for(int i=0;i<result.size();i++){
            answer[i][0]=result.get(i).get(0);
            answer[i][1]=result.get(i).get(1);
        }
        return answer;
    }
}
