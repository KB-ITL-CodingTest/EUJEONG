import java.util.*;
public class Main {
	public static void main(String[]args) {
		Map<String,String> map = new HashMap<>();
		map.put("ADD", "00000");
		map.put("ADDC", "00001");
		map.put("SUB", "00010");
		map.put("SUBC", "00011");
		map.put("MOV", "00100");
		map.put("MOVC", "00101");
		map.put("AND", "00110");
		map.put("ANDC", "00111");
		map.put("OR", "01000");
		map.put("ORC", "01001");
		map.put("NOT", "01010");
		map.put("MULT", "01100");
		map.put("MULTC", "01101");
		map.put("LSFTL", "01110");
		map.put("LSFTLC", "01111");
		map.put("LSFTR", "10000");
		map.put("LSFTRC", "10001");
		map.put("ASFTR", "10010");
		map.put("ASFTRC", "10011");
		map.put("RL", "10100");
		map.put("RLC", "10101");
		map.put("RR", "10110");
		map.put("RRC", "10111");
		
		StringBuilder answer = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		
		for(int i=0;i<N;i++) {
			String line = sc.nextLine();
		
			String answers[]=line.split(" ");
			answer.append(map.get(answers[0]));//opcode
			answer.append("0"); //5번 비트는 항상 0
			char bit_four = map.get(answers[0]).charAt(4);//4번 비트의 값 저장
			
			//결과값을 저장하는 rD의 번호를 이진수로
			answer.append(tobinary(answers[1]));
			//연산에 사용되는 레지스터 rA의 번호를 이진수로
			answer.append(tobinary(answers[2]));
			//연산에 사용되는 레지스터 rB 혹은 #C의 번호를 이진수로
			if(bit_four=='0') {
				answer.append(tobinary(answers[3]));
				answer.append("0");
			}else if(bit_four=='1') {
				answer.append(String.format("%4s",Integer.toBinaryString(Integer.parseInt(answers[3]))).replace(' ','0'));
			}
			
			System.out.println(answer.toString());
			answer = new StringBuilder();
			
		}
		sc.close();
	}
	static String tobinary(String s) {
		return String.format("%3s",Integer.toBinaryString(Integer.parseInt(s))).replace(' ','0');
	}
}
