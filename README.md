# GroupDocs Viewer Java Highlight Text Search Showcase

## Overview

This showcase project demonstrates **how to search for a word or phrase inside a document and highlight all occurrences** in the generated HTML output using **GroupDocs Viewer** (Java, version **25.12**).

The example loads a document from the `resources/input/` folder, searches for a user‑defined term, highlights every match and writes a single HTML file to `resources/output/`.

## Prerequisites

- **Java Development Kit (JDK) 8** or higher
- **Apache Maven** (3.6.x or later)
- Internet connection (to download GroupDocs Maven repository artifacts)

## License

GroupDocs Viewer is a commercial library. To run the example without the evaluation watermarks you need a license.

- **Temporary license:** Obtain a free 30‑day temporary license at
  https://purchase.groupdocs.com/temporary-license/
- **Placement:** Put the license file named **`GroupDocs.Viewer.lic`** in the **project root directory** (the same folder that contains `pom.xml`).
- **Without a license:** The library will run in evaluation mode – outputs will contain watermarks and some functionality may be limited.

## Project Structure

```
groupdocs-viewer-java-highlight-text-search/
├─ pom.xml
├─ GroupDocs.Viewer.lic          # <-- optional, place your license here
├─ src/
│  └─ main/java/com/groupdocs/viewer/examples/HighlightTextSearchExample.java
├─ resources/
│  ├─ input/
│  │   └─ sample.docx            # <-- sample document (replace with your own)
│  └─ output/                    # <-- generated files will be placed here
└─ README.md
```

## Getting Started

1. **Clone or download the project**
   ```bash
   git clone https://github.com/your-repo/groupdocs-viewer-java-highlight-text-search.git
   cd groupdocs-viewer-java-highlight-text-search
   ```
2. **Place your license file** (if you have one) as described above.
3. **Replace the sample document** (optional) – drop any `.docx`, `.pdf`, `.xlsx`, etc., into `resources/input/` and rename it to `sample.docx` or adjust the path in the code.
4. **Build the project**
   ```bash
   mvn clean compile
   ```
5. **Run the example**
   ```bash
   mvn exec:java
   ```


## What the Example Does

1. **Loads the license** (if present).
2. **Initialises the Viewer** with the document located at `resources/input/sample.docx`.
3. **Searches** for the term defined in the `term` variable (default is `GroupDocs`) using `SearchHighlightOptions` with literal matching.
4. **Renders HTML** pages with embedded resources via `HtmlViewOptions.forEmbeddedResources`.
5. **Writes** the highlighted HTML pages to `resources/output/` using the `page_{0}.html` naming pattern.

Open the generated `resources/output/page_*.html` files in any web browser to see the highlighted results.

## Customisation

- **Change the search term:** modify the `term` variable in `main`.
- **Use a different input file:** replace `sample.docx` with your file and update the `inputPath` variable accordingly.
- **Adjust output format:** the example uses HTML, but GroupDocs Viewer also supports PDF, PNG, etc. Adjust the `HtmlViewerOptions` to other formats if needed.

## Troubleshooting

- **`NoClassDefFoundError` or missing dependencies:** ensure you have an active internet connection for Maven to download the GroupDocs repository artifacts.
- **License not loaded:** verify that `GroupDocs.Viewer.lic` is at the project root and the filename matches exactly.
- **Output folder not created:** the code creates `resources/output/` automatically; check file system permissions if you encounter errors.

---

**Enjoy exploring GroupDocs Viewer!**
