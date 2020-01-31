import java.util.*;
import java.lang.*;
class StringReplace{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a string : ");
		String s = sc.nextLine();
		StringBuilder sb = new StringBuilder(s);
		System.out.print("What do you want to replace with : ");
		String rep = sc.nextLine();
		System.out.print("Enter the start index : ");
		int n1 = sc.nextInt();
		System.out.print("Enter the end index : ");
		int n2 = sc.nextInt();
		System.out.println("Original String : " +s);
		System.out.println("New String : " + sb.replace(n1,n2,rep));
	}
}