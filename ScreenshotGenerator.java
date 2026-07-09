import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

public class ScreenshotGenerator {
    public static void main(String[] args) throws Exception {
        if (args.length < 3) {
            System.out.println("Usage: java ScreenshotGenerator <workingDir> <mainClass> <outputFile>");
            return;
        }
        
        String workingDir = args[0];
        String mainClass = args[1];
        String outputFile = args[2];
        
        ProcessBuilder pb = new ProcessBuilder("java", mainClass);
        pb.directory(new File(workingDir));
        pb.redirectErrorStream(true);
        Process process = pb.start();
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        process.waitFor();
        
        int width = 800;
        int height = Math.max(300, lines.size() * 25 + 100);
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        
        g.setColor(new Color(12, 12, 12));
        g.fillRect(0, 0, width, height);
        
        g.setColor(new Color(50, 50, 50));
        g.fillRect(0, 0, width, 30);
        
        g.setColor(new Color(255, 95, 86));
        g.fillOval(10, 8, 14, 14);
        g.setColor(new Color(255, 189, 46));
        g.fillOval(30, 8, 14, 14);
        g.setColor(new Color(39, 201, 63));
        g.fillOval(50, 8, 14, 14);
        
        g.setColor(new Color(200, 200, 200));
        g.setFont(new Font("Consolas", Font.PLAIN, 16));
        
        int y = 60;
        g.drawString("user@workspace:~$ java " + mainClass, 20, y);
        y += 25;
        
        for (String text : lines) {
            g.drawString(text, 20, y);
            y += 25;
        }
        
        g.dispose();
        ImageIO.write(image, "png", new File(outputFile));
        System.out.println("Generated screenshot: " + outputFile);
    }
}
