import java.util.*;
class Solution {
    static int answer=0;
    static List<String>list = new ArrayList<>();
    static char[] arpa = {'A','E','I','O','U'};
    public int solution(String word) {
        dfs("");
        
        for (int i = 0; i < list.size(); i++) {//저장해놓은 리스트에서 찾으려는 단어 word가 몇번째인지
            if (list.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        return answer;
    }
    public static void dfs(String s){
        list.add(s);
        
        if (s.length() == 5) {
            return;
        }
        
        for (int i = 0; i < 5; i++) {
            dfs(s + arpa[i]);
        }
    }
}
