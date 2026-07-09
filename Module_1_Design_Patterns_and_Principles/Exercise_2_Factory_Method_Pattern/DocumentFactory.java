/**
 * Factory class to create different types of Documents.
 */
public class DocumentFactory {
    
    /**
     * Factory method to instantiate Document objects based on the requested format.
     * @param docFormat "PDF" or "WORD"
     * @return Document instance
     * @throws IllegalArgumentException if docFormat is unsupported
     */
    public static Document createDocument(String docFormat) {
        if (docFormat == null || docFormat.trim().isEmpty()) {
            throw new IllegalArgumentException("Document format cannot be null or empty.");
        }
        
        switch (docFormat.toUpperCase()) {
            case "PDF":
                return new PdfDocument();
            case "WORD":
                return new WordDocument();
            default:
                throw new IllegalArgumentException("Unsupported document format: " + docFormat);
        }
    }
}
