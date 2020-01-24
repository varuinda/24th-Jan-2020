import java.util.*;
class Numberpassfail{
	public static void main(String[] args) {
		int n1 = Integer.parseInt(args[0]);
		int n2 = Integer.parseInt(args[1]);
		int n3 = Integer.parseInt(args[2]);
		int sum = n1 + n2 + n3;
		int flag = 0;
		if(n1<40){
			flag = 1;
		}
		if(n2<40){
			flag = 1;
		}
		if(n3<40){
			flag = 1;
		}
		if(sum<125){
			flag = 1;
		}
		if(flag==1){
			System.out.print("FAILING");
		}
		if(flag==0){
			System.out.print("PASSING");
		}
	}
}