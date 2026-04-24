class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<triplets.length;i++){
            if(triplets[i][0]>target[0] || triplets[i][1]>target[1] || triplets[i][2]>target[2]){
                continue;
            }
            for(int j=0;j<triplets[i].length;j++){
                if(triplets[i][j]==target[j]){
                    set.add(j);
                }
            }
        }
        if(set.size()==3){
            return true;
        }
        else{
            return false;
        }
    }
}
