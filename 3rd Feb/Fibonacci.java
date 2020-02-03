import java.util.*;
class Fibonacci{
	public static void main(String[] args) {
		Scanner n = new Scanner(System.in);
		int n1 = n.nextInt();
		if(n1==1){
			System.out.println("0");
		}
		else if(n1==2){
			System.out.println("1");
		}
		else{
			int m1 = 0;
			int m2 = 1;
			int m3 = 0;
			for(int i=2;i<n1;i++){
				m3 = m2+m1;
				m1 = m2;
				m2 = m3;
			}
			System.out.print(m3);
		}
		System.out.print(recursiveFibo(n1));
	}
	public static int recursiveFibo(int n){
		if(n<=1){
			return n;
		}
		else{
			return recursiveFibo(n-1) + recursiveFibo(n-2);
		}
	}
}