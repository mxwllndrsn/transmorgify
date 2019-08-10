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

			System.out.println(docSIZE);
	}

	public static int getSize(Scanner s){
		int i = 0;
		while(s.hasNext()){
			s.next().charAt(0);
			i++;
		}
		return i;
	}
}