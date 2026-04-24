class Solution {
    public String foreignDictionary(String[] words) {
      ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
      for(int i=0;i<26;i++){
        adj.add(new ArrayList<>());
      }
      boolean[] present=new boolean[26];
      for (String word : words) {
            for (char c : word.toCharArray()) {
                present[c - 'a'] = true;
            }
        }
      int[] indegree=new int[26];
       for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            int minLength = Math.min(word1.length(), word2.length());
            boolean found = false;

            for (int j = 0; j < minLength; j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);

                if (Character.isLetter(c1) && Character.isLetter(c2)) {
                   int index1 = c1 - 'a';
                   int index2 = c2 - 'a';

                    if (index1 >= 0 && index1 < 26 && index2 >= 0 && index2 < 26) {
                        if (index1 != index2) {
                            adj.get(index1).add(index2);
                            indegree[index2]++;
                            found = true;
                            break;
                        }
                    }
                }
            }
            if (!found && word1.length() > word2.length()) {
                return "";
            }
        }
      Queue<Integer> queue=new LinkedList<>();
      for(int i=0;i<indegree.length;i++){
        if(indegree[i]==0 && present[i]==true){
            queue.add(i);
        }
      }
      ArrayList<Integer> a1=new ArrayList<>();
      while(queue.isEmpty()!=true){
        int current=queue.remove();
        a1.add(current);
        for(int i=0;i<adj.get(current).size();i++){
            indegree[adj.get(current).get(i)]--;
            if(indegree[adj.get(current).get(i)]==0){
                queue.add(adj.get(current).get(i));
            }
        }
      }
      String ans="";
      for(int i=0;i<a1.size();i++){
        char b=(char)(a1.get(i)+'a');
        ans=ans+b+"";
      }
      for(int i=0;i<indegree.length;i++){
        if(indegree[i]!=0){
            return "";
        }
      }
      return ans;
    }
}
