package KB_ITL_CT;
import java.util.*;
public class w7_카드놓기 {
	static int n,k;
	static String[]arr;
	static boolean[]visited;
	static Set<String> set = new HashSet<>();
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		arr = new String[n];
		
		for(int i=0;i<n;i++) {
			arr[i]=sc.next();
		}
		
		for(int i=0;i<n;i++) {
			visited = new boolean[n];
			visited[i]=true;
			dfs(1,arr[i]);
		}
		System.out.println(set.size());
		sc.close();
	}
	public static void dfs(int depth,String word) {
		if(depth==k) {
			set.add(word);
			return;
		}
		for(int i=0;i<n;i++) {
			if(!visited[i]) {
				visited[i]=true;
				dfs(depth+1,word+arr[i]);
				visited[i]=false;
			}
		}
	}
}
