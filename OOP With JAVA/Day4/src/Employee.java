
public abstract sealed class Employee permits Manager, Engineer, Salesman {
    protected String name;
    protected String address;
    protected int age;
    protected String gender;
    protected int basicSalary;

    Employee(String name, String address, int age, String gender, int basicSalary) {
        if (!setName(name)) {
            this.name = "Unknown";
        }
        if (!setAddress(address)) {
            this.address = "Not Provided";
        }
        if (!setAge(age)) {
            this.age = 18; 
        }
        if (!setGender(gender)) {
            this.gender = "Not Specified";
        }
        if (!setBasicSalary(basicSalary)) {
            this.basicSalary = 0;
        }
    }

    public String getName() { return name; }
    public boolean setName(String name) { 
        if (name == null || name.strip().isEmpty()) { 
            System.out.println("Error: Name cannot be blank."); 
            return false; 
        } 
        this.name = name.strip(); 
        return true;
    } 

    public String getAddress() { return address; }
    public boolean setAddress(String address) { 
        if (address == null || address.strip().isEmpty()) { 
            System.out.println(" Address cannot be blank."); 
            return false; 
        } 
        this.address = address.strip(); 
        return true;
    } 
	
    public int getAge() { return age; }
    public boolean setAge(int age) { 
        if (age < 18) { 
            System.out.println(" Age must be 18 or above."); 
            return false;
        } 
        this.age = age; 
        return true;
    } 

    public String getGender() { return gender; }
    public boolean setGender(String gender) { 
        if (gender == null || gender.strip().isEmpty()) { 
            System.out.println("Error: Gender cannot be blank."); 
            return false; 
        } 
        this.gender = gender.strip(); 
        return true;
    } 

    public int getBasicSalary() { return basicSalary; }
    public boolean setBasicSalary(int basicSalary) { 
        if (basicSalary < 0) { 
            System.out.println("Error: Basic salary cannot be negative."); 
            return false; 
        } 
        this.basicSalary = basicSalary; 
        return true;
    } 
	
    // --- Abstract Methods ---
    public abstract void displayDetails(); 
    public abstract String getRole();      
   
}
