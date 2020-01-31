import java.util.*;
import java.lang.*;
class StringReverse{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a String: ");
		String s = sc.nextLine();
		StringBuilder sb  = new StringBuilder(s);
		System.out.print("The reversed streing is : " +sb.reverse());
	}
}