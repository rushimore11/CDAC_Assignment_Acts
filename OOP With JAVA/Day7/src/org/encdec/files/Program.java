package org.encdec.files;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Program {
	
	static String filePath= "C:\\Users\\PGCP-AC.STUDENTSDC\\Desktop\\JAVA165\\Day3\\src\\Date.java";
	
	static int key=5;
	
 public static void encryptFile() {
		 
		File originalFile= new File(filePath);
		File newFile= new File(filePath + ".temp");
		
		try (FileInputStream fileIn = new FileInputStream(originalFile);
		         FileOutputStream fileOut = new FileOutputStream(newFile)){
			int data;
	        while ((data = fileIn.read()) != -1) {
	          
	            int encryptedData = data + key; 
	            fileOut.write(encryptedData);
	        }
	        System.out.println("File encrypted successfully!");

	    } catch (IOException e) {
	        e.printStackTrace();
	        return;
	    }

	    // Replace the original file with the encrypted temporary file
//	    if (originalFile.delete()) {
//	        if (!newFile.renameTo(originalFile)) {
//	            System.out.println("Failed to rename temporary file.");
//	        }
//	    } else {
//	        System.out.println("Failed to delete original file for replacement.");
//		}
		}
         
      public static void decryptFile() {
    	  File decryptedFile= new File(filePath + ".temp");
  		File encryptedFile= new File(filePath);
  		
  		try (FileInputStream fileIn = new FileInputStream(encryptedFile);
  		         FileOutputStream fileOut = new FileOutputStream(decryptedFile)){
  			int data;
  	        while ((data = fileIn.read()) != -1) {
  	          
  	            int decryptedData = data - key; 
  	            fileOut.write(decryptedData);
  	        }
  	        System.out.println("File decrypted successfully!");

  	    } catch (IOException e) {
  	        e.printStackTrace();
  	        return;
  	    }

      }
	 
 public static void main(String[] args) {
	 Scanner sc= new Scanner(System.in);
	 
	 while(true) {
		 
		 System.out.println("---FILE MENU---");
		 System.out.println("1. Encrypt File");
		 System.out.println("2. Decrypt File");
		 System.out.println("3. Exit");
		 System.out.println("Enter your choice");
		 int choice = sc.nextInt();
		 
		 switch(choice) {
		 case 1: 
			 encryptFile();
			break;
		 case 2: 
			 decryptFile();
		 case 3: 
			 System.out.println("Exit");
			
			 break;
		default: 
			System.out.println("Invalid choice");
			break;
		 }
	 }
	 
	
	 
 }    
	
}
