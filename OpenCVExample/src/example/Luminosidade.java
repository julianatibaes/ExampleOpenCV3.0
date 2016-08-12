package example;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class Luminosidade {

	static int width;
	static int height;
	static double alpha = 2;
	static double beta = 50;

	public static void main(String[] args) {

		try {
			// carrega a lib do openCV
			System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

			// carrega o arquivo fonte da image
			Mat source = Imgcodecs.imread("C:\\Users\\Juliana\\workspace_opencv\\OpenCVExample\\src\\example\\lena.png",
					Imgcodecs.CV_LOAD_IMAGE_COLOR);

			// instncia um objeto para destino
			Mat destination = new Mat(source.rows(), source.cols(), source.type());
			
			// calcula a luminosidade da imagem de destino utilizando os valores de alpha 2 e betha 50
			source.convertTo(destination, -1, alpha, beta);
			
			//grava a imagem de destino
			Imgcodecs.imwrite(
					"C:\\Users\\Juliana\\workspace_opencv\\OpenCVExample\\src\\example\\lena_luminosidade_alpha2_beta50.jpg",
					destination);

		} catch (Exception e) {
			System.out.println("error: " + e.getMessage());
		}
	}

}
