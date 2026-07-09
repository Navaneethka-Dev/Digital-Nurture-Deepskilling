public class DocumentFactory {
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
