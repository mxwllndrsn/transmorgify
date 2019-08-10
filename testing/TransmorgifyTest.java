import java.io.*;
import java.awt.*;
import java.util.*;
import javax.imageio.*;
import java.awt.image.*;

public class TransmorgifyTest {
	public static void main(String[] args)
		throws FileNotFoundException, IOException{
			File in = new File(args[0]);
			File out = new File(args[1]);
			Scanner s = new Scanner(in);
			s.useDelimiter("");

			ArrayList<Integer> charVAL = getVals(s);
						//System.out.println("charVAL.size(): "+charVAL.size());
			int docSIZE = charVAL.size();
			Point imgSIZE = imgDims(docSIZE);
			BufferedImage img = drawIMAGE(charVAL, imgSIZE);
        	ImageIO.write(img, "png", out);
	}
	public static Point imgDims(int size){
		int x = 500;
		int y = size/500;
		//System.out.println("imgDims x: "+x);
		//System.out.println("imgDims y: "+y);
		return new Point(x, y);
	}
	public static ArrayList<Integer> getVals(Scanner s){
		ArrayList<Integer> c = new ArrayList<Integer>();
		while(s.hasNext()){
			//System.out.print(s.next()+" ");
			c.add((int)s.next().charAt(0));
			//System.out.print(c.remove(0)+" ");
		}
		return c;
	}
	public static BufferedImage drawIMAGE(ArrayList<Integer> c, Point size){
		int a = (int)size.getX();
		int b = (int)size.getY();
		int trackDraw=0;
		int trackBlack=0;
		BufferedImage temp = new BufferedImage(a, b, BufferedImage.TYPE_INT_RGB);
		for(int x=0; x<a; x++){
			for(int y=0; y<b; y++){
				Color color = new Color(getColor(c), getColor(c), getColor(c));
				int clr = color.getRGB();
					trackDraw++;
					if(clr==-16777216){
						trackBlack++;
					}
				//temp.setRGB(x, y, clr);
			}
		}
					//System.out.println("drawIMAGE x: "+a);
					//System.out.println("drawIMAGE y: "+b);
					//System.out.println("draw vals: "+trackDraw);
					//System.out.println("black vals: "+trackBlack);
		return temp;
	}
	public static int getColor(ArrayList<Integer> c){
		int i = 0;
		if(c.size()!=0){
			i++;
			System.out.print(c.remove(0)+" ");
			//i = c.remove(0);
			//System.out.print(i + " ");
		}
		return i;
	}
}