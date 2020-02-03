import java.util.*;
class NameValidate{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the name : ");
		String s = sc.nextLine();
		try{
			validate(s);
			System.out.print("Hello " + s);
		}catch(UserException e){
			System.out.print(e);
		}
	}
	public static void validate(String s)throws UserException{
		String[] a = s.split("");
		int c = 0;
		for(int i=0;i<a.length;i++){
			if(a[i].equals(" ")){
				c++;
				if(c>=2){
					break;
				}
			}
		}
		if(c>=2){
			throw new UserException("Name should not have blanks");
		}
	}
}
class UserException extends Exception{
	UserException(String s){
		super(s);
	}
}