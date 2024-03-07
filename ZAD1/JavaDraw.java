package pl.heinzelman.javaDraw;

import org.junit.jupiter.api.Test;
import pl.heinzelman.javaDraw.actions.myBar;
import pl.heinzelman.javaDraw.controller.Controller;
import pl.heinzelman.javaDraw.model.Model;
import pl.heinzelman.javaDraw.view.View;
import pl.heinzelman.javaDraw.view.Window;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class JavaDraw{

	public static void main(String[] args) {




	}

	public int NWD_eukl( int a, int b ) {
		int A=a; int B=b;
		for (int i=0;i<999999;i++){
			if (a==b) { System.out.println( i + "               " + A + ":" + B + " :: " +  a );return i;  }
			if ( a>b ) { a=a-b; } else { b=b-a; }
		}
		return 0;
	}

	public int Stein( int a, int b ) {
		int k=0; int A=a; int B=b; int i=0;

		for ( i=0 ; i<999 ; i++ ){
		    if ( (a%2==0) && (b%2==0) ) {  a=a/2; b=b/2; k++; continue; }
			if (a%2==0){ a=a/2; continue;}
			if (b%2==0){ b=b/2; continue;}
			if ( a==b ) { break; }
			if ( a>b ) { a=a-b; continue; } else { b=b-a; continue; }
		}
		//System.out.println( i + "               A:" + A + ", B:" + B + " stein = a:" +  a*Math.pow(2,k) );
		return i;
	}

	public void writeLineToFile( String line ) throws IOException {
		String fileName = "myFile.txt";
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
		writer.append( line );
		writer.append('\n');
		writer.close();
	}

	public void addPointOnPicture(int x, int y, int colorLevel ) throws IOException {
		String imagePath = "image.bmp";
		BufferedImage myPicture = ImageIO.read(new File(imagePath));

		Graphics2D g = (Graphics2D) myPicture.getGraphics();
		g.setStroke(new BasicStroke(0));
		g.setColor( getColorByLevel ( colorLevel ) );
		g.drawRect(x,y,0,0);

		ImageIO.write( myPicture, "bmp", new File(imagePath));
	}

	public Color getColorByLevel( int colorLevel ){
		return ( new Color(  colorLevel/2, colorLevel, 0 ) );
		/*

		// 0-255
		colorLevel+=colorLevel;
		int Y=colorLevel-(colorLevel/255)*(colorLevel%255);
		    Y=Y%256;
		int R=255-(colorLevel/256)*( colorLevel%256 )   ;
		new Color(255,0  ,0);
		new Color(255,128,0);
		new Color(255,255,0);
		new Color(128,255,0);
		new Color(0,  255,0);
		return new Color( Y , R , 0);

		*/
	}


	@Test
	public void writeFileTest() throws IOException {
		writeLineToFile("firstLine");
		writeLineToFile("secondLine");
	}


	@Test
	public void paintPixel() throws IOException {
		addPointOnPicture( 3,2 ,  0 );
		addPointOnPicture( 3,3 , 32 );
		addPointOnPicture( 3,4 , 64 );
		addPointOnPicture( 3,5 , 96 );
		addPointOnPicture( 3,6 ,128 );
		addPointOnPicture( 3,7 ,160 );
		addPointOnPicture( 3,8 ,192 );
		addPointOnPicture( 3,9 ,224 );
		addPointOnPicture( 3,10,255 );
	}




	@Test
	public void euklidesTest2() throws IOException {


	NWD_eukl( 1, 5 );
	NWD_eukl( 12, 3 );
	NWD_eukl( 12, 4 );
	NWD_eukl( 105, 20 );
	NWD_eukl( 999, 998 );
	Stein( 1, 5 );
	Stein( 2, 5 );
	Stein( 3, 5 );
		Stein( 2, 6 );
		Stein( 4, 6 );
		Stein( 1, 6 );
		Stein( 2, 6 );
		Stein( 3, 6 );
	Stein( 12, 3 );
	Stein( 12, 4 );
	Stein( 105, 20 );
	Stein( 999, 998 );
	}

	@Test
	public void euklidesTest() throws IOException {

		String imagePath = "image.bmp";
		BufferedImage myPicture = ImageIO.read(new File(imagePath));

		Graphics2D g = (Graphics2D) myPicture.getGraphics();
		g.setStroke(new BasicStroke(0));

		for ( int i=1;i<1000;i++ ){
			for ( int j=0;j<1000;j++ ) {
				//int cycles=NWD_eukl( i, j );
				int cycles=Stein( i, j );
				g.setColor( getColorByLevel ( cycles%255 ) );
				g.drawRect(i,j,0,0);
			}
		}

		ImageIO.write( myPicture, "bmp", new File(imagePath));
	}


	/*
Euklides bez mnożenia
	26               973:318 :: 1 : 1 = 26
37               973:319 :: 1 : 1 = 37
32               973:320 :: 1 : 1 = 32
44               973:321 :: 1 : 1 = 44
48               973:322 :: 7 : 7 = 48
86               973:323 :: 1 : 1 = 86
326               973:324 :: 1 : 1 = 326
165               973:325 :: 1 : 1 = 165
71               973:326 :: 1 : 1 = 71
49               973:327 :: 1 : 1 = 49
37               973:328 :: 1 : 1 = 37
26               973:329 :: 7 : 7 = 26
27               973:330 :: 1 : 1 = 27


	*/

}