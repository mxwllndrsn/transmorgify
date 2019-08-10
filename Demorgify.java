import java.io.*;
import java.awt.*;
import java.util.*;
import javax.imageio.*;
import java.awt.image.*;

public class Demorgify {
	public static void main(String[] args)
		throws FileNotFoundException, IOException{
			File in = new File(args[0]);
			File out = new File(args[1]);
			BufferedImage img = ImageIO.read(in);
			PrintStream ostream = new PrintStream(out);
			decodeImage(img, ostream);
	}
	public static void decodeImage(BufferedImage img, PrintStream ostream){
		int WIDTH = img.getWidth();
		int HEIGHT = img.getHeight();

		for(int x=0; x<WIDTH; x++){
			for(int y=0; y<HEIGHT; y++){
				int c = img.getRGB(x, y);
                ostream.print((char)bit255(c, 16));
                ostream.print((char)bit255(c, 8));
                ostream.print((char)bit255(c));
			}
		}
	}
    public static int bit255(int bit, int shift){
        return (bit >> shift & 0xff);
    }
    public static int bit255(int bit){
        return (bit & 0xff);
    }
}