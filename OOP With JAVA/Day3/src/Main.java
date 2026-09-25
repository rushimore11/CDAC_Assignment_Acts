import Q1.ConsoleInput;

public class Main{
	public static void main(String[]args) {
		Date date = new Date();
		ConsoleInput console = new ConsoleInput();
		while (true) {
			int Choice = 6;
		
            System.out.println("\n===== Calendar Menu=====");
            System.out.println("1. Set date");
            System.out.println("2. Add Days");
            System.out.println("3.Add Months");
            System.out.println("4. Add Years");
            System.out.println("5. Display");
            System.out.println("6. Exit");
            System.out.print("Enter Choice : ");
           
            Choice = console.getInt();
            
            switch (Choice) {
                case 1: {
		 System.out.println("enter year:");
		int year = console.getInt();
		date.setYear(year);
		
		System.out.println("enter month:");
		int month = console.getInt();
		date.setMonth(month);
		
		System.out.println("enter Day:");
		int day = console.getInt();
		date.setDay(day);
		
	    break;
                }
       
                case 2: {
	    System.out.println("enter days to add:");
	    int days = console.getInt();
	    date.addDays(days);
	    date.displayDate();
	    break;
                }
                
                case 3: {
            	    System.out.println("enter months to add:");
            	    int months  = console.getInt();
            	    date.addMonths(months);
            	    date.displayDate();
            	    break;
                           }
                
                case 4: {
            	    System.out.println("enter years to add:");
            	    int years = console.getInt();
            	    date.addYears(years);
            	    date.displayDate();
            	    break;
                            }
                
                case 5: {
                	System.out.println(" The set date is : "  );
                	date.displayDate();
            	    break;
                            }
                case 6: {
                	System.out.println(" Exiting Program successfully...");
            	    return;
                            }
                default: {
                	System.out.println(" Invalid input.. Plz Try again ");
                	break;
                	}
                }
	} 
		}
}