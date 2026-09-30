public class Student {

    private int var;

    public void setVar() {
        System.out.println("Executing method: setVar");
    }

    public static void main(String[] args) {
        System.out.println("Executing Student main method...");
        Student student = new Student();
        student.setVar();
    }
}
