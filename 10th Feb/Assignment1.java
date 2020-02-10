import java.util.*;
import java.io.*;
class Assignment1{
	public static void main(String[] args) {
		try{
			File f = new File("file1.txt");
			if(f.exists()){
				StringBuilder sb = new StringBuilder("");
				FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);
				String str = "";
				int i = 1;
				while((str=br.readLine())!=null){
					sb.append(i + " ");
					sb.append(str + "\n");
					i++;
				}
				System.out.print(sb);
			}
			else{
				System.out.print("File does not exist");
			}
		}catch(Exception e){
			System.out.print(e);
		}
	}
}