package Q2;

import java.util.ArrayList;
import java.util.List;

public class ClassModel {
    private String classAccessSpecifier;
    private String className;
    private final List<FieldModel> fields = new ArrayList<>();
    private final List<MethodModel> methods = new ArrayList<>();

    public static class FieldModel {
        public String accessSpecifier;
        public String type;
        public String name;

        public FieldModel(String accessSpecifier, String type, String name) {
            this.accessSpecifier = accessSpecifier;
            this.type = type;
            this.name = name;
        }
    }

    public static class MethodModel {
        public String accessSpecifier;
        public String returnType;
        public String name;

        public MethodModel(String accessSpecifier, String returnType, String name) {
            this.accessSpecifier = accessSpecifier;
            this.returnType = returnType;
            this.name = name;
        }
    }

    public String getClassAccessSpecifier() { return classAccessSpecifier; }
    public void setClassAccessSpecifier(String specifier) { this.classAccessSpecifier = specifier; }

    public String getClassName() { return className; }
    public void setClassName(String className) { this.className = className; }

    public void addField(String accessSpecifier, String type, String name) {
        fields.add(new FieldModel(accessSpecifier, type, name));
    }

    public void addMethod(String accessSpecifier, String returnType, String name) {
        methods.add(new MethodModel(accessSpecifier, returnType, name));
    }

    public List<FieldModel> getFields() { return fields; }
    public List<MethodModel> getMethods() { return methods; }
}