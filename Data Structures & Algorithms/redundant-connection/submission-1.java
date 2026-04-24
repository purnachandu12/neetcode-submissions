class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] result=new int[2];
        union u=new union(edges.length);
        for(int i=0;i<edges.length;i++){
            if(u.find_upar(edges[i][0])!=u.find_upar(edges[i][1])){
                u.add(edges[i][0],edges[i][1]);
            }
            else{
                //int[] result=new int[2];
                result[0]=edges[i][0];
                result[1]=edges[i][1];
                return result;
            }
        }
        return result;
    }
}
class union{
    int[] parent;
    int[] rank;
    public union(int size){
        parent=new int[size+1];
        rank=new int[size+1];
        for(int i=0;i<parent.length;i++){
            parent[i]=i;
        }
    }
    public int find_upar(int value){
        if(parent[value]==value){
            return value;
        }
        int upar=find_upar(parent[value]);
        return upar;
    }
    public void add(int u,int v){
        int u_paru=find_upar(u);
        int u_parv=find_upar(v);
        if(u_paru==u_parv){
            return;
        }
        if(rank[u_paru]<rank[u_parv]){
            parent[u_parv]=parent[u_paru];
        }
        else if(rank[u_paru]>rank[u_parv]){
            parent[u_paru]=parent[u_parv];
        }
        else{
            parent[u_paru]=parent[u_parv];
            rank[u_paru]++;
        }
    }
}
