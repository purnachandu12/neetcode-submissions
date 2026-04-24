class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,Integer> map=new HashMap<>();
        ArrayList<List<String>> result=new ArrayList<>();
        int k=0;
        for(int i=0;i<strs.length;i++){
            String s = strs[i];
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedString = new String(chars);
            System.out.println(sortedString);
            if(map.containsKey(sortedString)!=true){
                ArrayList<String> temp=new ArrayList<>();
                temp.add(strs[i]);
                result.add(temp);
                map.put(sortedString,k);
                k++;
            }
            else{
                int place=map.get(sortedString);
                result.get(place).add(strs[i]);
            }
        }
        return result;
    }
    public static int convert(String s){
        int value=0;
        for(int i=0;i<s.length();i++){
            value=value+s.charAt(i);
        }
        return value;
    }
}
