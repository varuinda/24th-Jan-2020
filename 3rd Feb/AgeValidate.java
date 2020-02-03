import java.util.*;
class AgeValidate{
	public static void main(String[] args) {
		Scanner n = new Scanner(System.in);
		System.out.print("Enter the age : ");
		int n1 = n.nextInt();
		try{
			validate(n1);
			System.out.print("You satisfy the restrictions, Age " + n1);
		}catch(MyException e){
			System.out.print(e);
		}
	}
	public static void validate(int age)throws MyException{
		if(age<=15){
			throw new MyException("Age should be above 15");
		}
	}
}
class MyException extends Exception{
	MyException(String s){
		super(s);
	}
}