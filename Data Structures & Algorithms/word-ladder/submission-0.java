class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set=new HashSet<>();
        for(int i=0;i<wordList.size();i++){
            set.add(wordList.get(i));
        }
        Queue<pair> queue=new LinkedList<>();
        queue.add(new pair(beginWord,1));
        while(queue.isEmpty()!=true){
            pair current=queue.remove();
            String value=current.value;
            if(value.equals(endWord)){
                return current.dist;
            }
            for(int i=0;i<value.length();i++){
                for(int j=0;j<26;j++){
                    char ele = (char) ('a' + j);
                    StringBuffer s1=new StringBuffer(value);
                    s1.replace(i,i+1,ele+"");
                    String s=s1.toString();
                    if(set.contains(s)==true){
                        set.remove(s);
                        queue.add(new pair(s,current.dist+1));
                    }
                }
            }
        }
        return 0;
    }
}
class pair{
    String value;
    int dist;
    public pair(String value,int dist){
        this.value=value;
        this.dist=dist;
    }
}
