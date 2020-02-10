import java.io.*;
import java.util.Scanner;

class Assignment4{
	public static void main(String[] args) {
		Scanner n = new Scanner(System.in);
		System.out.print("Enter word to be replaced: ");
		String s1 = n.next();
		System.out.print("Enter new word: ");
		String s2 = n.next();
		File f= new File("file1.txt");
		StringBuffer sb = new StringBuffer("");
		try{
			String str = "";
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			while((str = br.readLine()) != null){
				str = str.replaceAll(s1, s2);
				sb.append(str);
				sb.append("\n");
			}
			br.close();
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(sb.toString());
			bw.close();
			System.out.print("String Replaced");
		} catch(Exception e){
			System.out.println(e);
		}
	}
}