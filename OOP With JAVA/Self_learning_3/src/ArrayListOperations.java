import java.util.ArrayList;
import java.util.Collections;

public class ArrayListOperations {
    private ArrayList<String> colors = new ArrayList<>();

    public ArrayListOperations() {
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
    }

    public void printCollection() {
        System.out.println("Colors list: " + colors);
    }

    public void insertAtFirst(String color) {
        colors.add(0, color);
        System.out.println("Updated list: " + colors);
    }

    public void retrieveByIndex(int idx) {
        if (idx >= 0 && idx < colors.size()) {
            System.out.println("Element: " + colors.get(idx));
        } else {
            System.out.println("Index out of range.");
        }
    }

    public void updateByIndex(int upIdx, String newColor) {
        if (upIdx >= 0 && upIdx < colors.size()) {
            colors.set(upIdx, newColor);
            System.out.println("Updated list: " + colors);
        } else {
            System.out.println("Index out of range.");
        }
    }

    public void removeThird() {
        if (colors.size() >= 3) {
            colors.remove(2); 
            System.out.println("3rd element removed. Updated list: " + colors);
        } else {
            System.out.println("List is too short to remove a 3rd element.");
        }
    }

    public void searchElement(String term) {
        int foundIdx = colors.indexOf(term);
        if (foundIdx != -1) {
            System.out.println("Found at index: " + foundIdx);
        } else {
            System.out.println("Color not found.");
        }
    }

    public void sortList() {
        Collections.sort(colors);
        System.out.println("Sorted list: " + colors);
    }

    public void copyList() {
        ArrayList<String> copy = new ArrayList<>(Collections.nCopies(colors.size(), ""));
        Collections.copy(copy, colors);
        System.out.println("Original: " + colors);
        System.out.println("Copied list: " + copy);
    }

    public void shuffleList() {
        Collections.shuffle(colors);
        System.out.println("Shuffled list: " + colors);
    }

    public void reverseList() {
        Collections.reverse(colors);
        System.out.println("Reversed list: " + colors);
    }

    public int getSize() {
        return colors.size();
    }
}



