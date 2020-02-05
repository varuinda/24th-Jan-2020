import java.util.*;
abstract class Item{
	private int id;
	private String title;
	private int noOfCopies;
	Item(int id,String title,int noOfCopies){
		this.id  = id;
		this.title = title;
		this.noOfCopies = noOfCopies;
	}
	public int getId(){
		return this.id;
	}
	public String getTitle(){
		return this.title;
	}
	public int getNoOfCopies(){
		return this.noOfCopies;
	}
	public void checkIn(){
		noOfCopies++;
	}
	public void checkOut(){
		noOfCopies--;
	}
	abstract int getPrice();
	abstract void show();
}
abstract class WrittenItem extends Item{
	private String author;
	WrittenItem(int id,String title,int noOfCopies,String author){
		super(id,title,noOfCopies);
		this.author = author;
	}
	public String getAuthor(){
		return this.author;
	}
}
class Book extends WrittenItem{
	private int price;
	Book(int id,String title,int noOfCopies,String author,int price){
		super(id,title,noOfCopies,author);
		this.price = price;
	}
	@Override 
	public void show(){
		System.out.println(getId() + " " + getTitle() + " " + getNoOfCopies() + " " + getAuthor() + " " + getPrice());
	}
	@Override
	public int getPrice(){
		return this.price;
	}
}
class JournalPaper extends WrittenItem{
	private int price;
	private int year;
	JournalPaper(int id,String title,int noOfCopies,String author,int price,int year){
		super(id,title,noOfCopies,author);
		this.price = price;
		this.year = year;
	}
	@Override
	public void show(){
		System.out.println(getId() + " " + getTitle() + " " + getNoOfCopies() + " " + getAuthor() + " " + getPrice() + " " + getYear());
	}
	@Override
	public int getPrice(){
		return this.price;
	}
	public int getYear(){
		return this.year;
	}
}
abstract class MediaItem extends Item{
	private int runtime;
	MediaItem(int id,String title,int noOfCopies,int runtime){
		super(id,title,noOfCopies);
		this.runtime = runtime;
	}
	@Override
	public void show(){
		System.out.println(getId() + " " + getTitle() + " " + getNoOfCopies() + " " + getRunTime());
	}
	public int getRunTime(){
		return this.runtime;
	}
}
class Video extends MediaItem{
	private String category;
	private String director;
	private int year;
	private int price;
	Video(int id,String title,int noOfCopies,int runtime,String category,String director,int year,int price){
		super(id,title,noOfCopies,runtime);
		this.category = category;
		this.director = director;
		this.year = year;
		this.price = price;
	}
	@Override
	public void show(){
		System.out.println(getId() + " " + getTitle() + " " + getNoOfCopies() + " " + getRunTime() + " " + getCategory() + " " + getDirector() + " " + getYear() + " " + getPrice());
	}
	@Override
	public int getPrice(){
		return this.price;
	}
	public String getCategory(){
		return this.category;
	}
	public int getYear(){
		return this.year;
	}
	public String getDirector(){
		return this.director;
	}
}
class CD extends MediaItem{
	private String category;
	private String artist;
	private int price;
	CD(int id,String title,int noOfCopies,int runtime,String category,String artist,int price){
		super(id,title,noOfCopies,runtime);
		this.artist = artist;
		this.category = category;
		this.price = price;
	}
	@Override
	public void show(){
		System.out.println(getId() + " " + getTitle() + " " + getNoOfCopies() + " " + getRunTime() + " " + getCategory() + " " + getArtist() + " " + getPrice());
	}
	@Override
	public int getPrice(){
		return this.price;
	}
	public String getCategory(){
		return this.category;
	}
	public String getArtist(){
		return this.artist;
	}
}
class Library{
	public static void main(String[] args) {
		Scanner n = new Scanner(System.in);
		while(true){
			System.out.println("Select the entry type : ");
			System.out.println("1 WrittenItem");
			System.out.println("2 MediaItem");
			System.out.println("3 Abort");
			int n1 = n.nextInt();
			if(n1==1){
				System.out.print("Enter the ID : ");
				int id = n.nextInt();
				System.out.print("Enter the title : ");
				String title = n.nextLine();
				System.out.print("Enter the number of copies : ");
				int copy = n.nextInt();
				System.out.print("Enter the author name : ");
				String author = n.nextLine();
				System.out.println("1 Book");
				System.out.println("2 Journal");
				int n2 = n.nextInt();
				if(n2==1){
					System.out.print("Enter the price : ");
					int price = n.nextInt();
					Book b = new Book(id,title,copy,author,price);
					b.show();
				}
				else if(n2==2){
					System.out.print("Enter the price : ");
					int price = n.nextInt();
					System.out.print("Enter the year : ");
					int year = n.nextInt();
					JournalPaper jb = new JournalPaper(id,title,copy,author,price,year);
					jb.show();
				}
			}
			else if(n1==2){
				System.out.print("Enter the ID : ");
				int id = n.nextInt();
				System.out.print("Enter the title : ");
				String title = n.nextLine();
				System.out.print("Enter the number of copies : ");
				int copy = n.nextInt();
				System.out.print("Enter the runtime : ");
				int runtime = n.nextInt();
				System.out.println("1 Video");
				System.out.println("2 CD");
				int n2 = n.nextInt();
				if(n2==1){
					System.out.print("Enter the category : ");
					String category = n.nextLine();
					System.out.print("Enter the director : ");
					String director = n.nextLine();
					System.out.print("Enter the year : ");
					int year = n.nextInt();
					System.out.print("Enter the price : ");
					int price = n.nextInt();
					Video vd = new Video(id,title,copy,runtime,category,director,year,price);
					vd.show();
				}
				else if(n2==2){
					System.out.print("Enter the category : ");
					String category = n.nextLine();
					System.out.print("Enter the artist : ");
					String artist  = n.nextLine();
					System.out.print("Enter the price : ");
					int price = n.nextInt();
					CD vd = new CD(id,title,copy,runtime,category,artist,price);
					vd.show();
				}
			}
			else{
				System.out.print("Thank you for using the application!!");
				break;
			}
		}
	}
}