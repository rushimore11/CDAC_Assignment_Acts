package Q2;

public class ConsoleInput {
    public static int getInt() {
        try {
            byte[] inputArr = new byte[100]; 
            int length = System.in.read(inputArr);
            String str = new String(inputArr, 0, length).trim();
            return Integer.parseInt(str);
        } catch (Exception e) {
            return 0;
        }
    }
}

