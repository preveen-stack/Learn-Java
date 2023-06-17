import java.io.IOException;
import java.io.StringWriter;
import java.util.Collections;
import javax.tools.Diagnostic;
import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.ToolProvider;

public class ASTExample {
    public static void main(String[] args) throws IOException {
        String sourceCode = "public class HelloWorld {\n" +
                "    public static void main(String[] args) {\n" +
                "        System.out.println(\"Hello, world!\");\n" +
                "    }\n" +
                "}";
        
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        Iterable<? extends JavaFileObject> compilationUnits = 
            Collections.singletonList(new StringJavaFileObject("HelloWorld", sourceCode));
        CompilationTask task = compiler.getTask(null, null, null, null, null, compilationUnits);
        Iterable<? extends CompilationUnitTree> asts = 
            task.parse();
        
        // Print the AST for debugging
        for (CompilationUnitTree ast : asts) {
            StringWriter writer = new StringWriter();
            ast.accept(new PrettyPrintVisitor(writer), null);
            System.out.println(writer.toString());
        }
    }
    
    private static class StringJavaFileObject extends SimpleJavaFileObject {
        private final String code;

        public StringJavaFileObject(String name, String code) {
            super(toURI(name), Kind.SOURCE);
            this.code = code;
        }

        @Override
        public CharSequence getCharContent(boolean ignoreEncodingErrors) {
            return code;
        }

        private static java.net.URI toURI(String name) {
            return java.net.URI.create("string:///" + name.replace('.', '/') + Kind.SOURCE.extension);
        }
    }
    
    private static class PrettyPrintVisitor extends TreeScanner<Void, Void> {
        private final StringWriter writer;

        public PrettyPrintVisitor(StringWriter writer) {
            this.writer = writer;
        }

        @Override
        public Void visitCompilationUnit(CompilationUnitTree node, Void p) {
            writer.write(node.getPackageName().toString());
            writer.write("\n");
            super.visitCompilationUnit(node, p);
            return null;
        }

        @Override
        public Void visitClass(ClassTree node, Void p) {
            writer.write(node.getSimpleName().toString());
            writer.write("\n");
            super.visitClass(node, p);
            return null;
        }

        @Override
        public Void visitMethod(MethodTree node, Void p) {
            writer.write(node.getName().toString());
            writer.write("\n");
            super.visitMethod(node, p);
            return null;
        }
    }
}

