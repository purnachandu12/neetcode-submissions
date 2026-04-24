class Solution {
    public int eraseOverlapIntervals(int[][] interval) {
        Arrays.sort(interval,(a,b)->Integer.compare(a[0],b[0]));
        ArrayList<List<Integer>> result=new ArrayList<>();
        result.add(new ArrayList<>(Arrays.asList(interval[0][0],interval[0][1])));
        int count=0;
        for(int i=1;i<interval.length;i++){
            if(result.get(result.size()-1).get(1)>interval[i][0]){
                int size1=Math.abs(interval[i][0]-interval[i][1]);
                int size2=Math.abs(result.get(result.size()-1).get(0)-result.get(result.size()-1).get(0));
                if(interval[i][1]<result.get(result.size()-1).get(1)){
                    result.remove(result.size()-1);
                    result.add(new ArrayList<>(Arrays.asList(interval[i][0],interval[i][1])));
                }
                count++;
            }
            else{
                result.add(new ArrayList<>(Arrays.asList(interval[i][0],interval[i][1])));
            }
        }
        return count;
    }
}
