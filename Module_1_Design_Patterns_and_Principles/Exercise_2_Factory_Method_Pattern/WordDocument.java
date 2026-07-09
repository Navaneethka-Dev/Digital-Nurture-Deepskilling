/**
 * Represents a Microsoft Word document.
 */
public class WordDocument implements Document {
    @Override
    public void print() { 
        System.out.println("--> [Word Printer]: Spooling and printing Word Document pages..."); 
    }
}
