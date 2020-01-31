import java.util.*;
class DivisibleSum{
	public static void main(String[] args) {
		Scanner n = new Scanner(System.in);
		System.out.print("Enter the number : ");
		int n1 = n.nextInt();
		System.out.print(new DivisibleSum().sum(n1));
	}
	public int sum(int a){
		int sum = 0;
		for(int i=1;i<=a;i++){
			if(i%3==0 || i%5==0){
				sum = sum + i;
			}
		}
		return sum;
	}
}