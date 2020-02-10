import java.util.*;
import java.io.*;
class Assignment2{
	public static void main(String[] args) {
		char[] a = new char[10000];
		try{
			File f = new File("file1.txt");
			if(f.exists()){
				FileReader fr = new FileReader(f);
				int size = fr.read(a);
				int words = 1,lines=1;
				for(int i=0;i<a.length;i++){
					if(a[i]==' ' || a[i]=='\n'){
						words++;
					}
					if(a[i]=='\n'){
						lines++;
					}
				}
				System.out.println("The number of characters in the file are : " +size);
				System.out.println("The number of words in the file are : " + words);
				System.out.println("The number of lines in the file are : " + lines);
			}
			else{
				System.out.print("File does not exist");
			}
		}catch(Exception e){
			System.out.print(e);
		}
	}
}