class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<List<Integer>> adj=new ArrayList<>();
        int[] indegree=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
            indegree[prerequisites[i][1]]++;
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        ArrayList<Integer> result=new ArrayList<>();
        while(queue.isEmpty()!=true){
            int current=queue.remove();
            result.add(current);
            for(int i=0;i<adj.get(current).size();i++){
                indegree[adj.get(current).get(i)]--;
                if(indegree[adj.get(current).get(i)]==0){
                    queue.add(adj.get(current).get(i));
                }
            }
        }
        System.out.println(result);
        return result.size()==numCourses;
    }
}
