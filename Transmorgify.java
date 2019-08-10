import java.io.*;
import java.awt.*;
import java.util.*;
import javax.imageio.*;
import java.awt.image.*;

public class Transmorgify {
	public static void main(String[] args)
		throws FileNotFoundException, IOException{
			File in = new File(args[0]);
			File out = new File(args[1]);
			Scanner s = new Scanner(in);
			s.useDelimiter("");

			ArrayList<Integer> charVAL = getVals(s);
			int docSIZE = charVAL.size();
			Point imgSIZE = imgDims(docSIZE);
			BufferedImage img = drawIMAGE(charVAL, imgSIZE);
        	ImageIO.write(img, "png", out);
	}
	public static Point imgDims(int size){
		int x = 500;
		int y = size/500;
		return new Point(x, y);
	}
	public static ArrayList<Integer> getVals(Scanner s){
		ArrayList<Integer> c = new ArrayList<Integer>();
		while(s.hasNext()){
			c.add((int)s.next().charAt(0));
		}
		return c;
	}
	public static BufferedImage drawIMAGE(ArrayList<Integer> c, Point size){
		int a = (int)size.getX();
		int b = (int)size.getY();
		BufferedImage temp = new BufferedImage(a, b, BufferedImage.TYPE_INT_RGB);
		for(int x=0; x<size.getX(); x++){
			for(int y=0; y<size.getY(); y++){
				Color color = new Color(getColor(c), getColor(c), getColor(c));
				int clr = color.getRGB();
				temp.setRGB(x, y, clr);
			}
		}
		return temp;
	}
	public static int getColor(ArrayList<Integer> c){
		int i = 0;
		if(c.size()!=0){
			i = c.remove(0);
		}
		return i;
	}
}