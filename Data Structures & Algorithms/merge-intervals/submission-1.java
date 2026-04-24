class Solution {
    public int[][] merge(int[][] interval) {
        ArrayList<List<Integer>> result=new ArrayList<>();
        Arrays.sort(interval,(a,b)->Integer.compare(a[0],b[0]));
        result.add(new ArrayList<>(Arrays.asList(interval[0][0],interval[0][1])));
        for(int i=1;i<interval.length;i++){
            if(result.get(result.size()-1).get(1)>=interval[i][0]){
                int x=Math.min(result.get(result.size()-1).get(0),interval[i][0]);
                int y=Math.max(result.get(result.size()-1).get(1),interval[i][1]);
                result.remove(result.size()-1);
                result.add(new ArrayList<>(Arrays.asList(x,y)));
            }
            else{
                result.add(new ArrayList<>(Arrays.asList(interval[i][0],interval[i][1])));
            }
        }
        System.out.println(result);
        int[][] ans=new int[result.size()][2];
        for(int i=0;i<result.size();i++){
            ans[i][0]=result.get(i).get(0);
            ans[i][1]=result.get(i).get(1);
        }
        return ans;
    }
}
