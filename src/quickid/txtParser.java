package quickid;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class txtParser {

    private File file;
    private LinkedList<ItemEntry> all = new LinkedList();
    private ArrayList<BufferedImage> allImg = new ArrayList();

    public txtParser(String filename) {
        file = new File(filename);
        processLineByLine();
    }

    public final void processLineByLine() {
        //Note that FileReader is used, not File, since File is not Closeable
        Scanner scanner;
        try {
            scanner = new Scanner(new FileReader(file));
            //first use a Scanner to get each line
            while (scanner.hasNextLine()) {
                processLine(scanner.nextLine());
            }
            scanner.close();
        } catch (IOException e) {}
    }


    private BufferedImage bi;
    protected void processLine(String aLine) {
        //use a second Scanner to parse the content of each line
        try {
            Scanner scanner = new Scanner(aLine);
            if (scanner.hasNext()) {
                if (aLine.charAt(0) != '#' && aLine.charAt(0) != ':' && aLine.charAt(0) != '~') {
                    String[] parts = scanner.nextLine().split("\\s+");
                    if(parts.length >= 4){
                        Point d = new Point(Integer.valueOf(parts[4].split(",")[0]),
                                            Integer.valueOf(parts[4].split(",")[1]));
                        bi = ImageIO.read(new File(parts[3]));
                        ImageIcon icon = new ImageIcon();
                        icon.setImage(bi.getSubimage(d.x * 16, d.y * 16, 16, 16));

                            all.add(new ItemEntry(parts[1] + "  -  " + parts[2].replace("_", " "), icon));
                    }
                }
            }
        } catch (IOException e) {}
    }

    public LinkedList<ItemEntry> getItems () {
        return all;
    }
}
