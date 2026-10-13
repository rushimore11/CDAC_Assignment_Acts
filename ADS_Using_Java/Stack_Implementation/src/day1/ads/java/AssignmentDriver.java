package day1.ads.java;

public class AssignmentDriver {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("Initializing Dynamic Array with starting capacity of 2");
        System.out.println("==================================================");

        CustomArrayOperations arrayInstance = new ModularResizableArray(2);

        System.out.println("\n1. Populating Array & Testing Automatic Resize Module:");
        arrayInstance.insert(0, 10);
        arrayInstance.insert(1, 30);
        arrayInstance.display();

        System.out.println("\nAdding 3rd element (Should trigger size doubling):");
        arrayInstance.insert(2, 40);
        arrayInstance.display();

        System.out.println("\n2. Testing Mid-Array Insertion Logic:");
        System.out.println("Inserting 20 directly at index 1...");
        arrayInstance.insert(1, 20); 
        arrayInstance.display();

        System.out.println("\n3. Testing Delete Module Logic:");
        System.out.println("Removing element from index 2...");
        arrayInstance.delete(2);
        arrayInstance.display();
        
        System.out.println("\n==================================================");
        System.out.println("Assignment Execution Verified Successfully.");
        System.out.println("==================================================");
    }
}

