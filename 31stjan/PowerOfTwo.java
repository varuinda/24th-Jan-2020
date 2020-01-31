import java.util.*;
class PowerOfTwo{
	public static void main(String[] args) {
		Scanner n = new Scanner(System.in);
		System.out.print("Enter the number : ")
		int n1 = n.nextInt();
		System.out.println(PowerOftwo(n1));

	}
	static boolean PowerOftwo(int n){

		if(n<=1){
		   return false;
		}
   
  		while(n>1){
   			int m = n%2;
   			if(m!=0){
   				return false;
   			}
   			n = n/2;
  		}
  		return true;
 	}
}