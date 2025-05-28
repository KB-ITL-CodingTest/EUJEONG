package KB_ITL_CT;
import java.util.*;
import java.math.*;
public class w9_32437 {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(answer(n).stripTrailingZeros().toPlainString());
	}
	public static BigDecimal answer(int n) {
		if(n==0)return BigDecimal.ONE;
		return BigDecimal.ONE.divide(BigDecimal.ONE.add(answer(n-1),new MathContext(100)));
	}
}
