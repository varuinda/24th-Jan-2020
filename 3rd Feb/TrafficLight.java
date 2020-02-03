import java.util.*;
class TrafficLight{
	public static void main(String[] args) throws ArithmeticException{
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose a color : ");
		System.out.println("1.Red");
		System.out.println("2.Yellow");
		System.out.println("3.Green");
		int n1 = sc.nextInt();
		switch(n1){
			case 1:
				System.out.print("Stop");
				break;
			case 2:
				System.out.print("Ready");
				break;
			case 3:
				System.out.print("Go");
				break;
			default:
				throw new ArithmeticException("Wrong Number");
		}
	}
}
