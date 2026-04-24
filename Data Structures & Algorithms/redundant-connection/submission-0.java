class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length+1;
        union un=new union(n);
        int[] result=new int[2];
        for(int i=0;i<edges.length;i++){
            if(un.findupar(edges[i][0])==un.findupar(edges[i][1])){
                result[0]=edges[i][0];
                result[1]=edges[i][1];
                return result;
            }
            else{
                un.add(edges[i][0],edges[i][1]);
            }
        }
        return result;
    }
}
class union{
    int[] parent;
    int[] rank;
    public union(int size){
        this.parent=new int[size+1];
        this.rank=new int[size+1];
        for(int i=0;i<size+1;i++){
            parent[i]=i;
        }
    }
    public int findupar(int node){
        if(parent[node]==node){
            return node;
        }
        int upar=findupar(parent[node]);
        return upar;
    }
    public void add(int u,int v){
        int u_paru=findupar(u);
        int u_parv=findupar(v);
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
