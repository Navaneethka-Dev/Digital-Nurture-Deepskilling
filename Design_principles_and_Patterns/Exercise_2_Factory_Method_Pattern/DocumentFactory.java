public class DocumentFactory {
    public static Document createDocument(String type) {
        if ("PDF".equalsIgnoreCase(type)) return new PdfDocument();
        else if ("WORD".equalsIgnoreCase(type)) return new WordDocument();
        throw new IllegalArgumentException("Unknown type");
    }
}
