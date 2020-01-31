import java.util.*;
import java.lang.*;
class MyNewSplit{
	public static void main(String[] args) {
		Scanner n = new Scanner(System.in);
		String s = n.nextLine();
		String c = n.nextLine();
		String a[] = Spli(s,c);
		for(int i=0;i<a.length;i++){
			if(a[i]==null){
				break;
			}
			System.out.println(a[i]);
		}
	}
	public static int index(String s,String c){
		int n = s.indexOf(c);
		return n;
	}
	public static String[] a = new String[100];
	public static int count = 0;
	
	public static String[] Spli(String s,String c){
		StringBuilder sb1 = new StringBuilder("");
		if(index(s,c)!=-1){
			int m = s.indexOf(c);
			if(s.substring(0,m).length()!=0){
				a[count] = s.substring(0,m);
				count++;
			}
			sb1.append(s.substring(m+c.length(),s.length()));
			return Spli(sb1.toString(),c);
		}
		else{
			for(int i=0;i<s.length();i++){
				sb1.append(s.charAt(i));
			}
			if(sb1.length()!=0){
				a[count] = sb1.toString();
				count++;
			}
			return a;
		}
	}
}