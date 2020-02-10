import java.io.*;
import java.util.*;
class Assignment3{
	public static void main(String[] args) {
		try{
			Scanner n = new Scanner(System.in);
			System.out.print("Enter the file name : ");
			String s = n.next();
			File f = new File(s);
			if(f.exists()){
				System.out.println("Exists? :"+ f.exists());
				System.out.println("Can Read? : "+f.canRead());
				System.out.println("Can Write? : "+f.canWrite());
				System.out.println("Extension : " + getExtension(s));
				System.out.println("Byte Size : " +f.length());
			}
			else{
				System.out.print("File does not exist");
			}
		}catch(Exception e){
			System.out.print(e);
		}
	}
	public static String getExtension(String s){
		StringBuilder sb = new StringBuilder("");
		char[] c = s.toCharArray();
		int index = 0;
		for(int i=0;i<c.length;i++){
			if(c[i]=='.'){
				index = i;
			}
		}
		for(int i = index;i<c.length;i++){
			sb.append(c[i]);
		}
		return sb.toString();
	}
}