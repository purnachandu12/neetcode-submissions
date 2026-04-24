
class Solution {
    public int numDecodings(String s) {
        HashMap<String, Character> map = new HashMap<>();
        for (int i = 1; i <= 26; i++) {
            map.put(i + "", (char) ('a' + i - 1));
        }
        return solve(s, 0, map);
    }

    public static int solve(String s, int index, HashMap<String, Character> map) {
        if (index == s.length()) {
            return 1;
        }
        if (s.charAt(index) == '0') {
            return 0;
        }
        int count = 0;
        if (index+1<=s.length() && map.containsKey(s.substring(index, index + 1))) {
            count += solve(s, index + 1, map);
        }
        if (index+2<=s.length() && map.containsKey(s.substring(index, index + 2))) {
            count += solve(s, index + 2, map);
        }
        return count;
    }
}
