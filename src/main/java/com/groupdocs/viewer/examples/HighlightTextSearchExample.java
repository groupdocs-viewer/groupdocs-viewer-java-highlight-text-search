package com.groupdocs.viewer.examples;

import com.groupdocs.viewer.License;
import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.options.LoadOptions;
import com.groupdocs.viewer.options.SearchHighlightOptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * HighlightTextSearchExample demonstrates how to search for a specific word or phrase inside a document
 * and highlight all occurrences in the generated HTML output using GroupDocs Viewer.
 *
 * <p>Before running the example place your GroupDocs Viewer license file (GroupDocs.Viewer.Java.lic) in the project
 * root directory. If a license is not provided, the library will work in evaluation mode with watermarks
 * and other limitations.</p>
 */
public class HighlightTextSearchExample {

    /**
     * Loads the GroupDocs Viewer license.
     *
     * @param licensePath relative path to the license file (e.g., "GroupDocs.Viewer.Java.lic")
     * @throws IOException if the license file cannot be read
     */
    public static void loadLicense(String licensePath) throws IOException {
        Path path = Paths.get(licensePath);
        if (Files.exists(path)) {
            License license = new License();
            license.setLicense(path.toAbsolutePath().toString());
            System.out.println("License loaded from " + path.toAbsolutePath());
        } else {
            System.out.println("License file not found at " + path.toAbsolutePath() + ". Running in evaluation mode.");
        }
    }

    /**
     * Searches the input document for the specified term and creates an HTML file where all matches are highlighted.
     * The method reads the document from "resources/input/" directory and writes the highlighted HTML to
     * "resources/output/" directory.
     *
     * @param inputFilePath  relative path to the source document (e.g., "resources/input/sample.docx")
     * @param outputFilePath relative path where the highlighted HTML will be saved (e.g., "resources/output/highlighted.html")
     * @param searchTerm     word or phrase to search for inside the document
     * @throws Exception if any error occurs during processing
     */
    public static void highlightSearch(String inputFilePath, String outputFilePath, String searchTerm) throws Exception {
        // Ensure output directory exists
        Path outputPath = Paths.get(outputFilePath);
        if (outputPath != null && !Files.exists(outputPath)) {
            Files.createDirectories(outputPath);
        }
        // Write the final highlighted HTML files
        Path pageFilePathFormat = outputPath.resolve("page_{0}.html");
        // Load the document
        Viewer viewer = new Viewer(inputFilePath, new LoadOptions());

        // Prepare HTML viewer options – we generate a single HTML file with embedded resources
        HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
        // Use literal search term (not a regex).
        SearchHighlightOptions byLiteral = new SearchHighlightOptions();
        byLiteral.setSearchTerm(searchTerm);
        byLiteral.setSearchTermRegEx(false);

        // Performing search in both Viewer instances
        viewer.search(byLiteral);
        // Render the document to HTML (this will create a temporary folder with HTML pages)
        viewer.view(options);

        System.out.println("Highlighted HTML saved to: " + Paths.get(outputFilePath).toAbsolutePath());
    }

    public static void main(String[] args) {
        try {
            // Step 1: Load license if present
            loadLicense("GroupDocs.Viewer.Java.lic");

            // Step 2: Define paths relative to project root
            String inputPath = "resources/input/sample.docx";
            String outputPath = "resources/output/";
            String term = "GroupDocs"; // Example search term – change as needed

            // Step 3: Execute highlight search demo
            highlightSearch(inputPath, outputPath, term);
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
