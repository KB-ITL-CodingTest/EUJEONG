import java.util.*;
public class Main {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int DNA_leng = sc.nextInt();
		int pas_leng = sc.nextInt();
		String DNA = sc.next();
		int[]count = new int[4];
		int[]min_count = new int[4];
		for(int i=0;i<4;i++)min_count[i]=sc.nextInt();
		
		int start = 0;
		int end = pas_leng-1;
		Map<Character, Integer>map = new HashMap<>();
		map.put('A', 0);
		map.put('C', 1);
		map.put('G', 2);
		map.put('T', 3);
		
		for(int i=0;i<=end;i++) {
			char now = DNA.charAt(i);
			int index = map.get(now);
			count[index]+=1;
		}
		int answer = 0;
	
		while(end<DNA_leng) {
			boolean part = true;
			for(int i=0;i<4;i++) {
				if(count[i]<min_count[i])part=false;
			}
			if(part)answer+=1;
			
			char before = DNA.charAt(start);
			int before_index = map.get(before);
			count[before_index]-=1;
			start+=1;
			end+=1;
			if(end>=DNA_leng)break;
			char next = DNA.charAt(end);
			int next_index = map.get(next);
			count[next_index]+=1;
			
		}
		System.out.println(answer);
		sc.close();
	}
}
