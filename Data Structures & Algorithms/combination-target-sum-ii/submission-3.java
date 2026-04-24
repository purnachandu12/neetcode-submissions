class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<Integer> temp=new ArrayList<>();
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        solve(candidates,0,temp,result,target,0);
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        for(int i=0;i<result.size();i++){
            set.add(result.get(i));
        }
        ArrayList<List<Integer>> result1=new ArrayList<>();
        for (ArrayList<Integer> num : set) {
            result1.add(num);
        }
        return result1;
    }
    public void solve(int[] candidates,int index,ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> result,int target,int sum){
        if(sum==target){
            result.add(new ArrayList<Integer>(temp));
        }
        if(sum>target){
            return;
        }
        if(index>=candidates.length){
            return;
        }
        temp.add(candidates[index]);
        solve(candidates,index+1,temp,result,target,sum+candidates[index]);
        temp.remove(temp.size()-1);
        solve(candidates,index+1,temp,result,target,sum);
    }
}
