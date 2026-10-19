package hashing;

public class Main {
    public static void main(String[] args) {
       
        HashTable myMap = new HashTable(5);

        System.out.println("--- Inserting Entries ---");
        myMap.put("Apple", 50);
        myMap.put("Banana", 30);
        myMap.put("Cherry", 85);
        myMap.put("Date", 90);
        myMap.put("Elderberry", 110);
        
     
        myMap.display();

        System.out.println("\n--- Retrieval Verifications ---");
        System.out.println("Value for 'Cherry': " + myMap.get("Cherry"));
        System.out.println("Value for 'Mango' (Absent): " + myMap.get("Mango"));

        System.out.println("\n--- Removing 'Banana' ---");
        myMap.remove("Banana");
        myMap.display();
    }
}
