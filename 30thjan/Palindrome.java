import java.util.*;
import java.lang.*;
class Palindrome{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a string : ");
		String s = sc.nextLine();
		int flag = 0;
		for(int i=0;i<s.length()/2;i++){
			if(s.charAt(i)!=s.charAt(s.length()-1-i)){
				flag = 1;
				break;
			}
		}
		if(flag==1){
			System.out.print("NO!! The string " + s + " is not a palindrome");
		}
		else{
			System.out.print("YES!! The string " + s + " is a palindrome");
		}
	}
}