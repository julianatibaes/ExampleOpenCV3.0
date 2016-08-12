package example;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class Borda {

	public static void main(String[] args) {
		
		try {

			// carrega a lib do openCV
			System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
			
			// carrega o arquivo fonte da image
			Mat source = Imgcodecs.imread("C:\\Users\\Juliana\\workspace_opencv\\OpenCVExample\\src\\example\\lena.png",
			Imgcodecs.CV_LOAD_IMAGE_COLOR);
			
			// instncia um objeto para destino
			Mat destination = new Mat(source.rows(), source.cols(), source.type());

			// define variáveis para trabalhar com os valores das bordas
			int top, bottom, left, right;
			
			/// inicializa os argumentos com os valores das bordas
			top = (int) (0.05 * source.rows());
			bottom = (int) (0.05 * source.rows());
			left = (int) (0.05 * source.cols());
			right = (int) (0.05 * source.cols());

			//variável da imagem aux recebe o arquivo da imagem
			destination = source;
			
			//insere a borda na imagem de destino, utilizando como parâmetro a imagem de origem
			Core.copyMakeBorder(source, destination, top, bottom, left, right, Core.BORDER_WRAP);
			
			//grava a imagem de destino
			Imgcodecs.imwrite("C:\\Users\\Juliana\\workspace_opencv\\OpenCVExample\\src\\example\\lena_borda.jpg", destination);

		} catch (Exception e) {
			System.out.println("error: " + e.getMessage());
		}

	}

}
