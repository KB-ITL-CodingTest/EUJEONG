class Solution {
    public static int answer=0;
    public static List<Integer>[] list;
    public int solution(int[] info, int[][] edges) {
        int n = info.length;
        list = new ArrayList[n];
        for(int i=0;i<n;i++)list[i]=new ArrayList<>();//트리 구조 저장할 리스트
        
        for(int i=0;i<edges.length;i++){
            int parent = edges[i][0];
            int child = edges[i][1];
            list[parent].add(child);//부모-자식 관계 저장하기
        }
        
        List<Integer> childs = new LinkedList<>();//현재 노드의 자식 노드를 저장하는 연결리스트
        childs.add(0);//시작 지점이 루트이므로
        dfs(info,0,0,0,childs);
        return answer;
    }
    public static void dfs(int[]info, int now, int sheep, int wolf, List<Integer>childs){
        if(info[now]==0)sheep+=1;
        else if(info[now]==1)wolf+=1;
        
        if(sheep<=wolf)return;
        
        answer = Math.max(answer,sheep);//정답 갱신
        
        List<Integer> next_child = new LinkedList<>(childs);
        for(Integer e:list[now]){//현재 탐색 중인 노드의 자식 노드들 추가
            next_child.add(e);
        }
        next_child.remove(Integer.valueOf(now));
        for(Integer e:next_child){
            dfs(info,e,sheep,wolf,next_child);
        }
    }
} ```
