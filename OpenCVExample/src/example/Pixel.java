package example;

import java.awt.*;
import java.awt.image.BufferedImage;

import java.io.*;

import javax.imageio.ImageIO;

public class Pixel {

	 BufferedImage image;
	 int width;
	 int height;
	   
	 public Pixel() {
	      try {
	         File input = new File("C:\\Users\\Juliana\\workspace_opencv\\"
	         		+ "OpenCVExample\\src\\example\\lena.png");
	         image = ImageIO.read(input);
	         width = image.getWidth();
	         height = image.getHeight();
	         
	         int count = 0;
	         
	         for(int i=0; i<height; i++){
	         
	            for(int j=0; j<width; j++){
	            
	               count++;
	               Color c = new Color(image.getRGB(j, i));
	               System.out.println("S.No: " + count + " Red: " + c.getRed() +"  Green: " + c.getGreen() + " Blue: " + c.getBlue());
	            }
	         }
	         
	      } catch (Exception e) {}
	   }
	public static void main(String[] args) {

		new Pixel();

	}

}
