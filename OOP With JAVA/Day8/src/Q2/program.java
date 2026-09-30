package Q2;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class program {
    public static void main(String[] args) {
        // Character stream for console user input
        try (BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in))) {
            ClassModel model = new ClassModel();

            System.out.println("=== Java Class Generator (Reader/Writer Based) ===");

            // 1. Class Access Specifier & Name
            System.out.print("Enter Class Access Specifier (public, default [press Enter]): ");
            model.setClassAccessSpecifier(inputReader.readLine());

            System.out.print("Enter Class Name: ");
            model.setClassName(inputReader.readLine().trim());

            // 2. Member Variables Input
            System.out.print("\nHow many variables do you want to add? ");
            int varCount = Integer.parseInt(inputReader.readLine().trim());

            for (int i = 0; i < varCount; i++) {
                System.out.println("\n-- Variable " + (i + 1) + " --");
                System.out.print("Access Specifier (private, public, protected, default [press Enter]): ");
                String spec = inputReader.readLine();

                System.out.print("Data Type (e.g., String, int, double): ");
                String type = inputReader.readLine().trim();

                System.out.print("Variable Name: ");
                String name = inputReader.readLine().trim();

                model.addField(spec, type, name);
            }

            // 3. Member Methods Input
            System.out.print("\nHow many methods do you want to add? ");
            int methodCount = Integer.parseInt(inputReader.readLine().trim());

            for (int i = 0; i < methodCount; i++) {
                System.out.println("\n-- Method " + (i + 1) + " --");
                System.out.print("Access Specifier (public, private, protected, default [press Enter]): ");
                String spec = inputReader.readLine();

                System.out.print("Return Type (e.g., void, int, String): ");
                String returnType = inputReader.readLine().trim();

                System.out.print("Method Name: ");
                String name = inputReader.readLine().trim();

                model.addMethod(spec, returnType, name);
            }

            // 4. Generate & Save Source File using Writer
            String generatedCode = CodeGenerator.generateSourceCode(model);
            File savedFile = FileManager.saveClassToFile(model.getClassName(), generatedCode);
            System.out.println("\n[Writer Output] File written to: " + savedFile.getAbsolutePath());

            // 5. Load and Verify File Content using Reader
            System.out.println("\n--- [Reader Input] Loading File Preview from Disk ---");
            String loadedContent = FileManager.loadFileContent(savedFile.getName());
            System.out.println(loadedContent);

        } catch (IOException e) {
            System.err.println("IO Error encountered: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Invalid numeric input entered.");
        }
    }
}