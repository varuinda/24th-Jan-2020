import java.util.Scanner;
class NumberIncCheck{
	public static void main(String[] args) {
		Scanner n = new Scanner(System.in);
		int n1 = n.nextInt();
		if(new NumberIncCheck().check(n1)){
			System.out.println("It is an increasing number");
		}
		else{
			System.out.println("It is not an increasing number");
		}
	}
	public boolean check(int n){
		String s = String.valueOf(n);
		for(int i=0;i<s.length()-1;i++){
			if((int)s.charAt(i)>(int)s.charAt(i+1)){
				return false;
			}
		}
		return true;	
	}
}