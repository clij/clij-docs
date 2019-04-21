package net.haesleinhuepf.clij.macro.documentation;

import java.io.IOException;

public class RunAll {
    public static void main(String... args) throws IOException {
        MarkdownGroovyOpDocumentationGenerator.main(args);
        MarkdownJavaOpDocumentationGenerator.main(args);
        MarkdownIJMacroDocumentationGenerator.main(args);
    }
}
