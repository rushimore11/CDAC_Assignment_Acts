import java.util.TreeSet;

public class TreeSetOperations {
    private TreeSet<String> colors = new TreeSet<>();

    public TreeSetOperations() {
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
    }

    public void printTreeSet() {
        System.out.println("TreeSet contents: " + colors);
    }

    public void addAllToAnother() {
        TreeSet<String> benchmarkSet = new TreeSet<>();
        benchmarkSet.addAll(colors);
        System.out.println("Elements successfully copied into a new set: " + benchmarkSet);
    }

    public void showReverseView() {
        System.out.println("Reverse order view: " + colors.descendingSet());
    }

    public void showFirstAndLast() {
        if (!colors.isEmpty()) {
            System.out.println("First Element: " + colors.first());
            System.out.println("Last Element: " + colors.last());
        } else {
            System.out.println("The set is empty.");
        }
    }

    public void showCeilingElement(String checkVal) {
        String match = colors.ceiling(checkVal);
        if (match != null) {
            System.out.println("Resulting element (>= " + checkVal + "): " + match);
        } else {
            System.out.println("No elements found matching the condition.");
        }
    }
}


