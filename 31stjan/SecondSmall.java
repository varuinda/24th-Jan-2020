import java.util.*;
class SecondSmall{
	public static void main(String[] args) {
		Scanner n=new Scanner(System.in);
		System.out.println("Enter the Size of the array");
		int n1=n.nextInt();
		int[] arr=new int[n1];
		System.out.println("Enter the elements of the array");
        for(int i=0;i<n1;i++){
        	arr[i]=n.nextInt();
        }
        System.out.println("Second Smallest element is:" + new SecondSmall().SecondSmallest(arr));
	}
  public int SecondSmallest(int[] array){
       for(int i=0;i<array.length;i++){
          for(int j=i+1;j<array.length;j++){
              if(array[i]>array[j]){
                  int temp = array[i];
                  array[i] = array[j];
                  array[j] = temp;
              }
          }
       }
       int sc = 0;
       for(int i=0;i<array.length-1;i++){
          if(array[i]!=array[i+1]){
            sc=array[i+1];
            break;
          }
       }
       return sc;  
     }
}
	