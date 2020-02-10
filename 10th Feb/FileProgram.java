import java.util.*;
import java.io.*;
class CopyDataThread implements Runnable{
	public void run(){
		try{
			File f = new File("source.txt");
			StringBuilder sb2 = new StringBuilder("");
			StringBuilder sb = new StringBuilder("");
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String str = "";
			while((str=br.readLine())!=null){
				sb.append(str + "\n");
			}
			File f2 = new File("target.txt");
			FileWriter fr2 = new FileWriter(f2);
			BufferedWriter br2 = new BufferedWriter(fr2);
			String tocopy = sb.toString();
			for(int i=0;i<tocopy.length();i++){
				sb2.append(tocopy.charAt(i));
				if((i+1)%10==0){
					System.out.println("Ten characters are copied");
					try{
						Thread.sleep(5000);
					}catch(Exception e){
						System.out.print(e);
					}
				}
			}
			br2.write(sb2.toString());
			br2.close();
			System.out.print("File copied");
		}catch(Exception e){
			System.out.print(e);
		}
	}
}
class FileProgram{
	public static void main(String[] args) {
		CopyDataThread cdt = new CopyDataThread();
		Thread t = new Thread(cdt);
		t.start();

	}
}
