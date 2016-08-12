package example;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class ErosaoDilatacao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			
			 // carrega a lib do openCV
	         System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
	         
	         // carrega o arquivo fonte da imagem (erosão)
	         Mat source = Imgcodecs.imread("C:\\Users\\Juliana\\workspace_opencv\\"
	         		+ "OpenCVExample\\src\\example\\lena.png",  Imgcodecs.CV_LOAD_IMAGE_COLOR);
	         
	         // instncia um objeto para destino
	         Mat destination = new Mat(source.rows(),source.cols(),source.type());
	         
	         destination = source;

	         // define o tamanho da dilatação/ erosão
	         int erosion_size = 5;
	         int dilation_size = 5;
	         
	         // define o elemento estruturante para erosão
	         Mat element = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new  Size(2*erosion_size + 1, 2*erosion_size+1));
	         
	         // realiza a erosão
	         Imgproc.erode(source, destination, element);
	         
	         // salva a imagem com erosão
	         Imgcodecs.imwrite("C:\\Users\\Juliana\\workspace_opencv\\"
		         		+ "OpenCVExample\\src\\example\\erosion.jpg", destination);

	         // carrega imagem fonte para dilatação
	         source = Imgcodecs.imread("C:\\Users\\Juliana\\workspace_opencv\\"
		         		+ "OpenCVExample\\src\\example\\lena.png",  Imgcodecs.CV_LOAD_IMAGE_COLOR);
	         
	         destination = source;
	         
	         // define o elemento estruturante para dilatação
	         Mat element1 = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new  Size(2*dilation_size + 1, 2*dilation_size+1));
	         
	         //realiza a dilatação
	         Imgproc.dilate(source, destination, element1);
	         
	         // salva a imagem dilatada
	         Imgcodecs.imwrite("C:\\Users\\Juliana\\workspace_opencv\\"
		         		+ "OpenCVExample\\src\\example\\dilation.jpg", destination);
	         
	      }catch (Exception e) {
	         System.out.println("error: " + e.getMessage());
	      } 
	}

}
