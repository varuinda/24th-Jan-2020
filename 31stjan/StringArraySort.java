import java.util.*;
class StringArraySort{
	public static void main(String[] args) {
		Scanner n = new Scanner(System.in);
		System.out.print("Enter the number of elements : ");
		int n1 = n.nextInt();
		String[] a = new String[n1];
		System.out.print("Enter the words : ");
		for(int i=0;i<n1;i++){
			a[i] = n.nextLine();
		}
		String[] ans = new StringArraySort().sortArray(a);
		for(int i=0;i<n1;i++){
			System.out.print(a[i] + " ");
		}
		System.out.println();
		for(int i=0;i<n1;i++){
			System.out.print(ans[i] + " ");
		}
	}
	public String[] sortArray(String[] a){
		for(int i=0;i<a.length;i++){
			a[i]  = a[i].toLowerCase();
		}
		for(int i=0;i<a.length;i++){
			for(int j=i+1;j<a.length;j++){
				if(a[i].compareTo(a[j])>0){
					String temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		for(int i=0;i<a.length/2;i++){
			a[i]  = a[i].toLowerCase();
		}
		for(int i=a.length/2;i<a.length;i++){
			a[i] = a[i].toUpperCase();
		}
		if(a.length%2!=0){
			a[a.length/2] = a[a.length/2].toLowerCase();
		}
		return a;
	}
}