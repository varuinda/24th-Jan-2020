import java.util.*;
class SumOfCubes{
	public static void main(String[] args) {
		Scanner n = new Scanner(System.in);
		int m = n.nextInt();
		System.out.print(new SumOfCubes().sumCube(m));
	}
	public int sumCube(int n){
		int m = n;
		int sum = 0;
		while(m!=0){
			int rem = m%10;
			sum = sum + (int)Math.pow(rem,3);
			m = m/10;
		}
		return sum;
	}
}