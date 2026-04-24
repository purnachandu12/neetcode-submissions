class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree=new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            indegree[prerequisites[i][1]]++;
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        ArrayList<Integer> temp=new ArrayList<>();
        while(queue.isEmpty()!=true){
            int current=queue.remove();
            temp.add(current);
            for(int i=0;i<prerequisites.length;i++){
                if(prerequisites[i][0]==current){
                    indegree[prerequisites[i][1]]--;
                    if(indegree[prerequisites[i][1]]==0){
                        queue.add(prerequisites[i][1]);
                    }
                }
            }
        }
        int[] arr=new int[temp.size()];
        if(temp.size()!=numCourses){
            return new int[0];
        }
        Collections.reverse(temp);
        for(int i=0;i<arr.length;i++){
            arr[i]=temp.get(i);
        }
        return arr;
    }
}
