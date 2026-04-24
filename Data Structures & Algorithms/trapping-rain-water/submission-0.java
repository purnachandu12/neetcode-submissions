class Solution {
    public int trap(int[] height) {
        ArrayList<Integer> a1=maxl(height);
        ArrayList<Integer> a2=maxr(height);
        Collections.reverse(a2);
        ArrayList<Integer> a3=new ArrayList<>();
        for(int i=0;i<a2.size();i++){
            a3.add(Math.min(a1.get(i),a2.get(i))-height[i]);
        }
        int sum=0;
        for(int i=0;i<a3.size();i++){
            sum=sum+a3.get(i);
        }
        return sum;
    }
     public static ArrayList<Integer> maxl(int[] arr){
        ArrayList<Integer> a1=new ArrayList<>();
        int max=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=max){
                a1.add(max);
            }
            else{
                max=arr[i];
                a1.add(max);
            }
        }
        return a1;
    }
    public static ArrayList<Integer> maxr(int[] arr){
        ArrayList<Integer> a1=new ArrayList<>();
        int max=0;
        for(int j=arr.length-1;j>=0;j--){
            if(arr[j]<=max){
                a1.add(max);
            }
            else{
                max=arr[j];
                a1.add(max);
            }
        }
        return a1;
    }
}
