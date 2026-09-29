class EmployeeSalary {
    double salary;
    double hoursPerDay;

    // parameter
    public void getInfo(double initialSalary, double hoursWorked) {
        salary = initialSalary;
        hoursPerDay = hoursWorked;
    }

    public void addSal() {
        if (salary < 500) {
            salary += 10;
        }
    }

    public void addWork() {
        if (hoursPerDay > 6) {
            salary += 5;
        }
    }

    public double getFinalSalary() {
        return salary;
    }
}

public class Question6 {
    public static void main(String[] args) {
        EmployeeSalary emp = new EmployeeSalary();
        
        emp.getInfo(450, 8); 
        emp.addSal();  
        emp.addWork(); 
        
        System.out.println("Final salary: $" + emp.getFinalSalary());
    }
}


