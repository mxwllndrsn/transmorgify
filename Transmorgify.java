import java.io.*;
import java.awt.*;
import javax.imageio.*;
import java.util.Scanner;

public class Transmorgify {
	public static void main(String[] args)
		throws FileNotFoundException{
			File in = new File(args[0]);
			Scanner s = new Scanner(in);
			s.useDelimiter("");

			int docSIZE = getSize(s);
			Point imgSIZE = imgDims(docSIZE);

			System.out.println(docSIZE);
			System.out.println(imgSIZE);
	}

	public static int getSize(Scanner s){
		int i = 0;
		while(s.hasNext()){
			s.next().charAt(0);
			i++;
		}
		return i;
	}
	public static Point imgDims(int SIZE){
		int x = SIZE;
		int y = 0;
		if(SIZE%2==0){
			 y = SIZE;
		} else {
			y = SIZE+1;
		}
		return new Point(x,y);
	}
}