package Q1;
public class ConsoleInput{
	
	public static String getString() {
		try { 
			
				byte[]inputArr = new byte[10];
				int length = System.in.read(inputArr);
				byte[]arrFinal = new byte[length-2];
				System.arraycopy(inputArr, 0, arrFinal, 0,length-2);
				String ObjString = new String(arrFinal);
				return ObjString;
			
		}
		catch(Exception objectException) {
			System.out.println(objectException);
		}
		return null;
	}
	
	public static int getInt() {
		
		String ObjString = getString();
		return Integer.parseInt(ObjString);
	}
	public static float getFloat() {
		
		String ObjString = getString();
		return Float.parseFloat(ObjString);
	}
	public static Double getDouble() {
		
		String ObjString = getString();
		return Double.parseDouble(ObjString);
	}
}