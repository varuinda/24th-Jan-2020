import com.cg.eis.exception.EmployeeException;
import java.util.*;
class SalaryCheck{
	public static void main(String[] args) {
		Scanner n = new Scanner(System.in);
		System.out.print("Enter your salary : ");
		int n1 = n.nextInt();
		try{
			checkSalary(n1);
			System.out.print("Your salary is above 3000  : " + n1);
		}catch(Exception e){
			System.out.print(e);
		}
	}
	public static void checkSalary(int n)throws EmployeeException{
		if(n<=3000){
			throw new EmployeeException("Salary should be above 3000");
		}
	}
}