class Fibonocci{
	public static void main(String[] args) {
		int sum = 1;
		int n1 = 0;
		int n2 = 1;
		System.out.print(n1 + " " + n2 + " " + n2 + " ");
		while(true){
			n1 = n2;
			n2 = sum;
			sum = n1 + n2;
			if(sum<=89){
				System.out.print(sum + " ");
			}
			else{
				break;
			}
		}
	}
}