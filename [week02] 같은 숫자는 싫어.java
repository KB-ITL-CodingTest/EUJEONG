import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        List<Integer> list = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        for(int i=arr.length-1;i>=0;i--)stack.push(arr[i]); //스택에 넣기 위해 arr 맨 뒷 원소부터 push
        
        while(!stack.isEmpty()){
            int now = stack.pop();//스택의 가장 위에 있는 것 꺼내서
            list.add(now);//결과 리스트에 넣기
            while(true){
                if(stack.isEmpty())break;
                int next = stack.pop();//그 다음 원소를 꺼냈는데
                if(next!=now){//이전 원소와 같지 않을 경우에만
                    stack.push(next);//다시 스택에 넣어 다음 과정 진행
                    break;
                }
            }
        }

        answer = list.stream().mapToInt(i -> i).toArray();//list를 int 배열로 변환 (시간 단축)
        return answer;
    }
}
