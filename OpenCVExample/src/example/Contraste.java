/**
 * 
 */
package example;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

/**
 * @author Juliana
 *
 */

/*
 * API - http://docs.opencv.org/java/3.0.0/org/opencv/imgcodecs/Imgcodecs.html
 * Neste capítulo aprender a melhorar o contraste de uma imagem utilizando um
 * histograma de equalização.
 */
public class Contraste {

	static int width;
	static int height;
	static double alpha = 2;
	static double beta = 50;

	public static void main(String[] args) {

		try {
			// carrega a lib do openCV
			System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
			
			// carrega o arquivo fonte da image
			Mat source = Imgcodecs.imread(
					"C:\\Users\\Juliana\\workspace_opencv\\OpenCVExample\\src\\example\\lena.png",
					Imgcodecs.CV_LOAD_IMAGE_GRAYSCALE);

			// instncia um objeto para destino
			Mat destination = new Mat(source.rows(), source.cols(), source.type());

			// realiza o contraste por histograma da imagem
			Imgproc.equalizeHist(source, destination);
			
			//grava a imagem de destino
			Imgcodecs.imwrite(
					"C:\\Users\\Juliana\\workspace_opencv\\OpenCVExample\\src\\example\\" + "lena_contraste.jpg",
					destination);

		} catch (Exception e) {
			System.out.println("error: " + e.getMessage());
		}

	}

}
