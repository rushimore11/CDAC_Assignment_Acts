//Create a menu driven program for calculator to add , subtract, multiply and divide two integers, two floats, two doubles.
//The application will continuously display the menu till the exit choice is not selected
package Q1;

public class Calculator {
    
  
    public int add(int num1, int num2) { 
    	return num1 + num2;
    	}
    
    public float add(float num1, float num2) { 
    	return num1 + num2;
    	}
    
    public double add(double num1, double num2) { 
    	return num1 + num2; 
    	}

    
    public int subtract(int num1, int num2) { 
    	return num1 - num2; 
    	}
    public float subtract(float num1, float num2) { 
    	return num1 - num2; 
    	}
    public double subtract(double num1, double num2) { 
    	return num1 - num2;
    	}

    
    public int multiply(int num1, int num2) { 
    	return num1 * num2; 
    }
    public float multiply(float num1, float num2) {
    	return num1 * num2;
    	}
    public double multiply(double num1, double num2) { 
    	return num1 * num2; 
    	}

   
    public int divide(int num1, int num2) { 
        if (num2 == 0) { 
        	System.out.println("Error: Divide by zero!");
        	return 0; 
        	}
        return num1 / num2; 
    }
    public float divide(float num1, float num2) { 
        if (num2 == 0.0f) { 
        	System.out.println("Error: Divide by zero!");
        	return 0.0f;
        	}
        return num1 / num2; 
    }
    public double divide(double num1, double num2) { 
        if (num2 == 0.0) { 
        	System.out.println("Error: Divide by zero!");
        	return 0.0; 
        	}
        return num1 / num2; 
    }
}
