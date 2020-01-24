import java.util.*;
class Arithtables{
	public static void main(String[] args) {
		int n1 = Integer.parseInt(args[0]);
		int n2 = Integer.parseInt(args[1]);
		for(int i=1;i<=n2;i++){
			int m = n1*i;
			System.out.print(n1 + " * " + i + " = " + m);
		}
	}
}