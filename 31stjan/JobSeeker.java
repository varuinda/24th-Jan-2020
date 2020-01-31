import java.util.*;
class JobSeeker{
	public static void main(String[] args) {
		Scanner n = new Scanner(System.in);
		System.out.print("Please enter the username : ");
		String s = n.nextLine();
		if(new JobSeeker().check(s)){
			System.out.print("Username accepted!!");
		}
		else{
			System.out.print("Username does not fit the criteria");
		}
	}
	public boolean check(String s){
		if(s.length()>=12){
			int flag = 0;
			if(s.charAt(s.length()-1)=='b'){
				if(s.charAt(s.length()-2)=='o'){
					if(s.charAt(s.length()-3)=='j'){
						if(s.charAt(s.length()-4)=='_'){
							flag = 1;
						}
					}
				}
			}
			if(flag==1){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}
}