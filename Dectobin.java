import java.util.*;
class Dectobin{
	public static void main(String[] args) {
		int n1 = Integer.parseInt(args[0]);
		int m = n1;
		StringBuffer sb = new StringBuffer("");
		while(m!=0){
			int rem = m%2;
			sb.append(rem);
			m = m/2;
		}
		String s = sb.toString();
		char[] c = s.toCharArray();
		for(int i=c.length-1;i>=0;i--){
			System.out.print(c[i]);
		}
	}
}