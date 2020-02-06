import java.util.*;
class Computer{
	int id,hddSize,ram;
	String brand,color;
	Computer(int id,String brand,String color,int hddSize,int ram){
		this.id = id;
		this.brand = brand;
		this.color = color;
		this.hddSize = hddSize;
		this.ram = ram;
	}
	public int getID(){
		return this.id;
	}
	public String getBrand(){
		return this.brand;
	}
	public String getColor(){
		return this.color;
	}
	public int getHDDSize(){
		return this.hddSize;
	}
	public int getRam(){
		return this.ram;
	}
	public String toString(){
		return this.getID() +  " " + this.getBrand() + " " + this.getColor() + " " + this.getHDDSize() + " " + this.getRam();
	}
}
class CompShop{
	public static void main(String[] args) {
		Scanner n = new Scanner(System.in);
		ArrayList<Computer> list = new ArrayList<Computer>();
		int button = 1;
		System.out.println("Welcome to the CompShop Database");
		while(button!=0){
			System.out.println("Please select an option : ");
			System.out.println("1. Add new computer");
			System.out.println("2. Display all the computers");
			System.out.println("3. Search the computers");
			System.out.println("4. Delete a computer");
			System.out.println("5. Update computer details");
			System.out.println("6. Exit");
			int n1 = n.nextInt();
			if(n1==1){
				System.out.print("Enter the ID : ");
				int id = n.nextInt();
				int flag = 0;
				for(int i=0;i<list.size();i++){
					if(list.get(i).getID()==id){
						System.out.println("Sorry the IDs cannot be same!!");
						flag = 1;
						break;
					}
				}
				if(flag==0){
					System.out.print("Enter the brand name : ");
					String brand = n.next();
					n.nextLine();
					System.out.print("Enter the color : ");
					String color = n.next();
					System.out.print("Enter the HDD size : ");
					int hdd = n.nextInt();
					System.out.print("Enter the RAM size : ");
					int ram = n.nextInt();
					list.add(new Computer(id,brand,color,hdd,ram));
				}
			}
			else if(n1==2){
				System.out.println("All the computers in the database : ");
				for(int i=0;i<list.size();i++){
					System.out.println(list.get(i));
				}
			}
			else if(n1==3){
				System.out.println("a. By brand");
				System.out.println("b. By color");
				System.out.println("c. By HDD size");
				System.out.println("d. By RAM size");
				String sea = n.next();
				n.nextLine();
				char search = sea.charAt(0);
				if(search=='a'){
					System.out.print("Enter the brand name: ");
					String searching = n.next();
					searching = searching.toLowerCase();
					int flag = 0;
					for(int i=0;i<list.size();i++){
						if(list.get(i).getBrand().toLowerCase().contains(searching)){
							System.out.println(list.get(i));
							flag = 1;
						}
					}
					if(flag==0){
						System.out.println("Sorry no such brand Computer exists in our database");
					}
				}
				else if(search=='b'){
					System.out.print("Enter the color: ");
					String searching = n.next();
					searching = searching.toLowerCase();
					int flag = 0;
					for(int i=0;i<list.size();i++){
						if(list.get(i).getColor().toLowerCase().contains(searching)){
							System.out.println(list.get(i));
							flag = 1;
						}
					}
					if(flag==0){
						System.out.println("Sorry no such color Computer exists in our database ");
					}
				}
				else if(search=='c'){
					System.out.print("Enter the HDD size: ");
					int searching = n.nextInt();
					int flag = 0;
					for(int i=0;i<list.size();i++){
						if(list.get(i).getHDDSize()==searching){
							System.out.println(list.get(i));
							flag = 1;
						}
					}
					if(flag==0){
						System.out.println("Sorry no such HDD size Computer exists in our database");
					}
				}
				else{
					System.out.print("Enter the RAM size: ");
					int searching = n.nextInt();
					int flag = 0;
					for(int i=0;i<list.size();i++){
						if(list.get(i).getRam()==searching){
							System.out.println(list.get(i));
							flag = 1;
						}
					}
					if(flag==0){
						System.out.print("Sorry no such RAM size Computer exists in our database");
					}
				}
			}
			else if(n1==4){
				System.out.print("Please enter the computer ID which you want to delete : ");
				int id = n.nextInt();
				int flag = 0;
				for(int i=0;i<list.size();i++){
					if(list.get(i).getID()==id){
						list.remove(i);
						System.out.println("Successfully removed!!");
						flag = 1;
						break;
					}
				}
				if(flag==0){
						System.out.println("No such Computer ID is there in the database");
				}
			}
			else if(n1==5){
				System.out.print("Please enter the computer ID which you want to update : ");
				int id = n.nextInt();
				int flag = 0;
				int index = 0;
				for(int i=0;i<list.size();i++){
					if(list.get(i).getID()==id){
						flag = 1;
						index = i;
						break;
					}
				}
				if(flag==1){
					System.out.println("What do you want to update : ");
					System.out.println("a. By brand");
					System.out.println("b. By color");
					System.out.println("c. By HDD size");
					System.out.println("d. By RAM size");
					String sea = n.next();
					n.nextLine();
					char search = sea.charAt(0);
					if(search=='a'){
						System.out.print("Enter the new brand : ");
						String newBrand = n.next();
						list.set(index,new Computer(list.get(index).getID(),newBrand,list.get(index).getColor(),list.get(index).getHDDSize(),list.get(index).getRam()));
					}
					else if(search=='b'){
						System.out.print("Enter the new color : ");
						String newColor = n.next();
						list.set(index,new Computer(list.get(index).getID(),list.get(index).getBrand(),newColor,list.get(index).getHDDSize(),list.get(index).getRam()));
					}
					else if(search=='c'){
						System.out.print("Enter the new HDD size : ");
						int newHdd = n.nextInt();
						list.set(index,new Computer(list.get(index).getID(),list.get(index).getBrand(),list.get(index).getColor(),newHdd,list.get(index).getRam()));
					}
					else if(search=='d'){
						System.out.print("Enter the new RAM : ");
						int newRam = n.nextInt();
						list.set(index,new Computer(list.get(index).getID(),list.get(index).getBrand(),list.get(index).getColor(),list.get(index).getHDDSize(),newRam));
					}
				}
				else{
						System.out.println("No such Computer ID is there in the database");
				}
			}
			else{
				System.out.println("Thank you for using the CompShop Database");
				button = 0 ;
			}
		}
	}
}