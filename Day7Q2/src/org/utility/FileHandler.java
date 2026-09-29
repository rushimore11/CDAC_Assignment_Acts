package org.utility;

import java.io.*;

public class FileHandler {

    @SuppressWarnings("unchecked")
    public static <T> LinkedList<T> loadFromFile(String filePath) throws IOException, ClassNotFoundException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException("File not found: " + filePath);
        }

        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (LinkedList<T>) ois.readObject();
        }
    }

    public static <T> void saveToFile(String filePath, LinkedList<T> list) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(filePath);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(list);
        }
    }
    
    
}