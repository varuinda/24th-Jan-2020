import java.util.*;
class Oddnumber{
	public static void main(String[] args) {
		int n1 = Integer.parseInt(args[0]);
		int n2 = Integer.parseInt(args[1]);
		for(int i=n1;i<=n2;i++){
			if(i%2!=0){
				System.out.print(i + " ");
			}
		}
	}
}