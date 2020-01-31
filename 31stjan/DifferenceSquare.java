import java.util.Scanner;
class DifferenceSquare{
	public static void main(String[] args) {
		Scanner n = new Scanner(System.in);
		int m = n.nextInt();
		System.out.println(new DifferenceSquare().difference(m));
	}
	public int difference(int n){
		int sum1 = 0;
		int sum2 = 0;
		for(int i=1;i<=n;i++){
			sum1 = sum1 + i;
			sum2 = sum2 + (int)Math.pow(i,2);
		}
		sum1 = (int)Math.pow(sum1,2);
		return sum2 - sum1;
	}
}