public class Date { 
    private int day; 
    private int month; 
    private int year; 
    private boolean leap = false; 
    private int monthsDay = 0; 
    // Constructors
    public Date() { 
        this(1, 1, 1999); 
    } 

    public Date(int d) { 
        this(d, 1, 1999); 
    } 

    public Date(int d, int m) { 
        this(d, m, 1999); 
    } 

    public Date(int d, int m, int y) { 
        setYear(y); 
        setMonth(m); 
        setDay(d); 
    } 

    // Year Setter with proper Leap Year Logic
    public void setYear(int y) { 
        year = y; 
        
        if ((y % 400 == 0) || (y % 4 == 0 && y % 100 != 0)) { 
            leap = true; 
        } else {
            leap = false; 
        }
        
        if (month >= 1 && month <= 12) {
            setMonth(month);
        }
    } 

    // Month Setter
    public void setMonth(int m) { 
        if (m < 1 || m > 12) { 
            System.out.println("Invalid month"); 
            return; 
        } 
        month = m; 
        
        if (m == 2) { 
            this.monthsDay = leap ? 29 : 28; 
        } else if (m == 4 || m == 6 || m == 9 || m == 11) { 
            this.monthsDay = 30; 
        } else { 
            this.monthsDay = 31; 
        } 
    } 

    // Day Setter
    public void setDay(int d) { 
       
        if (d < 1 || d > this.monthsDay) { 
            System.out.println("Invalid day: " + d + " for month " + month); 
            return; 
        } 
        day = d; 
    } 

    public void displayDate() { 
        System.out.println(this.day + "/" + this.month + "/" + this.year); 
    } 

    
    public void addDays(int days) { 
        if (days < 0) { 
            System.out.println("Invalid days input"); 
            return; 
        } 
        
        day += days;
        while (day > monthsDay) {
            day -= monthsDay;
            int nextMonth = month + 1;
            if (nextMonth > 12) {
                setYear(year + 1);
                setMonth(1);
            } else {
                setMonth(nextMonth);
            }
        }
    } 

    
    public void addMonths(int months) { 
        if (months < 0) { 
            System.out.println("Invalid months input"); 
            return; 
        }
        
        int totalMonths = month - 1 + months; 
        int newYear = year + (totalMonths / 12);
        int newMonth = (totalMonths % 12) + 1;
        
        setYear(newYear);
        setMonth(newMonth);
        
        
        if (day > monthsDay) {
            day = monthsDay;
        }
    } 

    
    public void addYears(int years) { 
        if (years < 0) { 
            System.out.println("Invalid years input"); 
            return; 
        }
        setYear(year + years);
        
       
        if (day > monthsDay) {
            day = monthsDay;
        }
    } 
}
