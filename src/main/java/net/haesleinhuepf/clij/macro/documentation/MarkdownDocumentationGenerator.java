package net.haesleinhuepf.clij.macro.documentation;

import net.haesleinhuepf.clij.CLIJ;
import net.haesleinhuepf.clij.macro.CLIJMacroPlugin;
import net.haesleinhuepf.clij.macro.CLIJMacroPluginService;
import net.haesleinhuepf.clij.macro.documentation.MarkDownDocumentationTemplate;
import net.haesleinhuepf.clij.macro.documentation.OffersDocumentation;
import org.scijava.Context;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * MarkdownDocumentationGenerator
 * <p>
 * <p>
 * <p>
 * Author: @haesleinhuepf
 * 12 2018
 */
public class MarkdownDocumentationGenerator {
    public static void main(String... args) throws IOException {
        generateMethodReference();
    }

    private static void generateMethodReference() throws IOException {
        CLIJMacroPluginService service = new Context(CLIJMacroPluginService.class).getService(CLIJMacroPluginService.class);

        StringBuilder documentation = new StringBuilder();
        documentation.append("# CLIJ reference\n\n");

        ArrayList<String> methodNames = new ArrayList<String>();
        methodNames.addAll(service.getCLIJMethodNames());
        Collections.sort(methodNames);

        for (String name : methodNames) {
            CLIJMacroPlugin plugin = service.getCLIJMacroPlugin(name);
            if (plugin instanceof OffersDocumentation) {
                OffersDocumentation documentedPlugin = (OffersDocumentation) plugin;
                documentation.append(new MarkDownDocumentationTemplate(documentedPlugin.getDescription(), documentedPlugin.getAvailableForDimensions(), plugin));
            } else {
                documentation.append("## " + name);
                documentation.append("Parameters: " + plugin.getParameterHelpText());
            }
        }

        FileWriter writer = new FileWriter(new File("reference.md"));
        writer.write(documentation.toString());
        writer.close();
    }
}
