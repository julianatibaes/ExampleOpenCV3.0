package example;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Gaussiana {

	public static void main(String[] args) {
		try {
			// carrega a lib do openCV
			System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

			// carrega o arquivo fonte da image
			Mat source = Imgcodecs.imread("C:\\Users\\Juliana\\workspace_opencv\\OpenCVExample\\src\\example\\lena.png",
					Imgcodecs.CV_LOAD_IMAGE_COLOR);

			// instncia um objeto para destino
			Mat destination = new Mat(source.rows(), source.cols(), source.type());
			
			// calcula a gaussiana da imagem com tamanho 45,
			Imgproc.GaussianBlur(source, destination, new Size(45, 45), 0);
			
			//grava a imagem de destino
			Imgcodecs.imwrite("C:\\Users\\Juliana\\workspace_opencv\\OpenCVExample\\src\\example\\lena_gausseana45.jpg",
					destination);

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

}
