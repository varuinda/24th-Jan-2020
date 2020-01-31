import java.util.*;
class PositiveString{
	public static void main(String[] args) {
		Scanner n = new Scanner(System.in);
		System.out.print("Enter a string : ");
		String s = n.nextLine();
		String c = s.toLowerCase();
		if(new PositiveString().check(c)){
			System.out.print(s + " is positive");
		}
		else{
			System.out.print(s + " is not positive");
		}
	}
	public boolean check(String s){
		for(int i=0;i<s.length()-1;i++){
			if((int)s.charAt(i)>(int)s.charAt(i+1)){
				return false;
			}
		}
		return true;
	}
}