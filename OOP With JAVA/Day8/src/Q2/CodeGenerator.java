package Q2;


public class CodeGenerator {

    public static String generateSourceCode(ClassModel model) {
        StringBuilder sb = new StringBuilder();
        String classSpec = model.getClassAccessSpecifier().trim();
        if (!classSpec.isEmpty()) {
            classSpec += " ";
        }

        // Class Declaration
        sb.append(classSpec).append("class ").append(model.getClassName()).append(" {\n\n");

        // Fields
        for (ClassModel.FieldModel field : model.getFields()) {
            String acc = field.accessSpecifier.trim();
            if (!acc.isEmpty()) acc += " ";
            sb.append("    ").append(acc).append(field.type).append(" ").append(field.name).append(";\n");
        }

        if (!model.getFields().isEmpty()) {
            sb.append("\n");
        }

        // Methods
        for (ClassModel.MethodModel method : model.getMethods()) {
            String acc = method.accessSpecifier.trim();
            if (!acc.isEmpty()) acc += " ";

            sb.append("    ").append(acc).append(method.returnType).append(" ")
              .append(method.name).append("() {\n");
            
            sb.append("        System.out.println(\"Executing method: ").append(method.name).append("\");\n");
            
            if (!method.returnType.equalsIgnoreCase("void")) {
                sb.append("        return ").append(getDefaultReturnValue(method.returnType)).append(";\n");
            }
            sb.append("    }\n\n");
        }

        // Executable Main Method
        sb.append("    public static void main(String[] args) {\n");
        sb.append("        System.out.println(\"Executing ").append(model.getClassName()).append(" main method...\");\n");
        
        String instanceName = model.getClassName().substring(0, 1).toLowerCase() + model.getClassName().substring(1);
        sb.append("        ").append(model.getClassName()).append(" ").append(instanceName)
          .append(" = new ").append(model.getClassName()).append("();\n");

        for (ClassModel.MethodModel method : model.getMethods()) {
            sb.append("        ").append(instanceName).append(".").append(method.name).append("();\n");
        }

        sb.append("    }\n");
        sb.append("}\n");

        return sb.toString();
    }

    private static String getDefaultReturnValue(String type) {
        switch (type.toLowerCase()) {
            case "int": case "long": case "short": case "byte": return "0";
            case "double": case "float": return "0.0";
            case "boolean": return "false";
            case "char": return "'\\0'";
            default: return "null";
        }
    }
}