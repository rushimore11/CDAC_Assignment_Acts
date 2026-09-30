package Q2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.io.Reader;

public class FileManager {

    /**
     * Saves code string to disk using Writer streams (FileWriter wrapped in BufferedWriter).
     */
    public static File saveClassToFile(String className, String sourceCode) throws IOException {
        String fileName = className + ".java";
        File file = new File(fileName);

        // Using Character Output Writer Stream
        try (Writer fileWriter = new FileWriter(file);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(sourceCode);
            bufferedWriter.flush();
        }
        return file;
    }

    /**
     * Reads file content using Reader streams (FileReader wrapped in BufferedReader).
     */
    public static String loadFileContent(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        File file = new File(filePath);

        if (!file.exists()) {
            throw new IOException("File not found: " + filePath);
        }

        // Using Character Input Reader Stream
        try (Reader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }
}