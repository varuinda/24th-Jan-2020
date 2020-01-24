import java.util.*;
class Factorial{
	public static void main(String[] args) {
		int v = Integer.parseInt(args[0]);
		System.out.println(fact(v));
	}
	public static int fact(int n){
		if(n==0 || n==1){
			return 1;
		}
		else{
			return n * fact(n-1);
		}
	}
}