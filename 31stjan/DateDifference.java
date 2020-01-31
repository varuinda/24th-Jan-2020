import java.util.*;
import java.time.LocalDate;

class DateDifference{
	public static void main(String[] args) {
		Scanner n = new Scanner(System.in);

		String sysdate = (LocalDate.now()).toString();
		System.out.println(sysdate);

		System.out.println("Enter date in yyyy-mm-dd format: ");
		String userdate = n.nextLine();

		String userDay, userMonth, userYear;
		String sysDay, sysMonth, sysYear;

		int isy = Integer.parseInt(sysdate.substring(0,4));
		int ism = Integer.parseInt(sysdate.substring(5,7));
		int isd = Integer.parseInt(sysdate.substring(8,10));

		int iuy = Integer.parseInt(userdate.substring(0,4));
		int ium = Integer.parseInt(userdate.substring(5,7));
		int iud = Integer.parseInt(userdate.substring(8,10));

		int fd, fm, fy;

		if(iud<=isd){

			if(ium<=ism){

				if(iuy<=isy){

					fd = (isd - iud);
					fm = (ism - ium);
					fy = (isy - iuy);

				}
				else{

					fd = (isd - iud);
					fm = (ism - ium);
					fy = (iuy - isy);

				}
			}
			else{

				if(iuy<=isy){

					fd = (isd - iud);
					fm = 12-(ium - ism);
					fy = (isy - iuy-1);

				}
				else{

					fd = (isd - iud);
					fm = (ium - ism);
					fy = (iuy - isy);
				}
			}
		}
		else
		{
			if(ium<=ism){

				if(iuy<=isy){

					fd = (iud - isd);
					fm = (ism - ium-1);
					fy = (isy - iuy-1);

				}
				else{

					fd = 30-(iud - isd);
					fm = (ism - ium);
					fy = (iuy - isy);

				}
			}
			else{

				if(iuy<=isy){

					fd = (iud - isd);
					fm = (ium - ism-1);
					fy = (isy - iuy-1);

				}
				else{

					fd = 30-(iud - isd);
					fm = (ium - ism);
					fy = (iuy - isy);
				}
			}
		}
	
		System.out.println("The difference is: " + fd + " days " + fm + " months "+ fy + " years.");
	
	}
}