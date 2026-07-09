import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import javax.imageio.ImageIO;

public class ScreenshotGenerator {
    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            System.out.println("Usage: java ScreenshotGenerator <inputFile> <outputFile>");
            return;
        }
        
        List<String> lines = Files.readAllLines(Paths.get(args[0]));
        
        int width = 800;
        int height = Math.max(300, lines.size() * 25 + 60);
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        
        // Anti-aliasing for smooth text
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        
        // Terminal background (dark gray/black)
        g.setColor(new Color(12, 12, 12));
        g.fillRect(0, 0, width, height);
        
        // Terminal header bar
        g.setColor(new Color(50, 50, 50));
        g.fillRect(0, 0, width, 30);
        
        // Window buttons (red, yellow, green)
        g.setColor(new Color(255, 95, 86));
        g.fillOval(10, 8, 14, 14);
        g.setColor(new Color(255, 189, 46));
        g.fillOval(30, 8, 14, 14);
        g.setColor(new Color(39, 201, 63));
        g.fillOval(50, 8, 14, 14);
        
        // Terminal text
        g.setColor(new Color(200, 200, 200)); // Light gray text
        g.setFont(new Font("Consolas", Font.PLAIN, 16));
        
        int y = 60;
        g.drawString("user@workspace:~$ java Program", 20, y);
        y += 25;
        
        for (String line : lines) {
            g.drawString(line, 20, y);
            y += 25;
        }
        
        g.dispose();
        ImageIO.write(image, "png", new File(args[1]));
        System.out.println("Generated screenshot: " + args[1]);
    }
}
