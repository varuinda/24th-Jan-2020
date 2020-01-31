import java.util.*;
import java.lang.*;
class CharCheck{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the String : ");
		String s = sc.nextLine();
		System.out.print("Enter the char you want to find : ");
		char c = sc.next().charAt(0);
		int flag = 0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)==c){
				System.out.println("Found the character and it is : " + c);
				flag =1;
				break;
			}
		}
		if(flag==0){
			System.out.println("Character not found");
		}
	}
}