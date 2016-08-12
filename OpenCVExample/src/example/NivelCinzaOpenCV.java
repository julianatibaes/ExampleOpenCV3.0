package example;

/*
 *  Color Conversion Type
 *  COLOR_RGB2BGR
 *  COLOR_RGB2BGRA
 *  COLOR_RGB2GRAY
 *  COLOR_RGB2HLS
 *  COLOR_RGB2HSV
 *  COLOR_RGB2Luv
 *  COLOR_RGB2YUV
 *  COLOR_RGB2Lab
 *  
 *  A partir de qualquer tipo de conversão de cores, 
 *  basta passar o mais adequado para cvtColor () método na classe Imgproc
 *  
 *  Imgproc.cvtColor(source mat, destination mat1, Color_Conversion_Code);
 *  
 *  
 */
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

public class NivelCinzaOpenCV {

	public static void main(String[] args) {
		
		try {

			// carrega a lib do openCV
	        System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
	         
	        // carrega o arquivo da imagem
	        File input = new File("C:\\Users\\Juliana\\workspace_opencv\\OpenCVExample\\src\\example"
	         		+ "\\lena.png");
	        
	        BufferedImage image = ImageIO.read(input);	

	        /* cria um vetor com as informações em cache da imagem 
	         * para a implementação acompanhar todas as modificações 
	         * para esses dados
	         */
	         byte[] data = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
	         
	         // cria uma matriz com as mesmas dimensões que a imagem
	         Mat mat = new Mat(image.getHeight(), image.getWidth(), CvType.CV_8UC3);
	         
	         // insere a imagem a partir do pixel de posição 0,0
	         mat.put(0, 0, data);

	         Mat mat1 = new Mat(image.getHeight(),image.getWidth(),CvType.CV_8UC1);
	         
	         // converte a imagem a partir de um espaço de cor para nível de cinza
	         Imgproc.cvtColor(mat, mat1, Imgproc.COLOR_RGB2GRAY);

	         byte[] data1 = new byte[mat1.rows() * mat1.cols() * (int)(mat1.elemSize())];
	         mat1.get(0, 0, data1);
	         
	         // cria uma imagem contendo as informações da matriz com a imagem na escala de cinza
	         BufferedImage image1 = new BufferedImage(mat1.cols(),mat1.rows(), BufferedImage.TYPE_BYTE_GRAY);
	         
	         // define os elementos da imagem
	         image1.getRaster().setDataElements(0, 0, mat1.cols(), mat1.rows(), data1);

	         // define onde será armazenada a imagem
	         File ouptut = new File("C:\\Users\\Juliana\\workspace_opencv\\OpenCVExample\\src\\example\\"
	         		+ "lena_nivel_cinza_opencv.jpg");
	         
	         // grava a imagem no caminho output
	         ImageIO.write(image1, "jpg", ouptut);
	         
	      } catch (IOException e) {
	         System.out.println("Error: " + e.getMessage());
	      }
	}

}
