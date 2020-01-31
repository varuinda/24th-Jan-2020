import java.util.*;
class ReverseArray{
	public static void main(String[] args) {
		Scanner n = new Scanner(System.in);
		System.out.print("Enter the size of input : ");
		int n1 = n.nextInt();
		System.out.print("Enter the elements : ");
		int[] a = new int[n1];
		for(int i=0;i<n1;i++){
			a[i] = n.nextInt();
		}
		int[] ans = new ReverseArray().sortReverse(a);
		for(int i=0;i<ans.length;i++){
			System.out.print(a[i] + " ");
		}
		System.out.println();
		for(int i=0;i<ans.length;i++){
			System.out.print(ans[i] + " ");
		}
	}
	public int[] sortReverse(int[] a){
		int[] anew = new int[a.length];
		for(int i=0;i<a.length;i++){
			anew[i] = reverse(a[i]);
		}
		for(int i=0;i<anew.length;i++){
			for(int j=i+1;j<anew.length;j++){
				if(anew[i]>anew[j]){
					int temp  = anew[i];
					anew[i] = anew[j];
					anew[j] = temp;
				}
			}
		}
		return anew;
	}
	public int reverse(int n){
		String s = String.valueOf(n);
		StringBuilder sb = new StringBuilder(s);
		sb.reverse();
		int sum = Integer.parseInt(sb.toString());
		return sum;
	}
}