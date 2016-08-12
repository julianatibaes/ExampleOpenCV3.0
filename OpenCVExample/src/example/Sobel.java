package example;

/*
 * O operador de Sobel é usado para detectar dois tipos de bordas
 *  em uma imagem: bordas direção vertical e bordas direção horizontal.
 *  
 *  Direção vertical
 *
 *  -1	0	1
 *	-2	0	2
 *	-1	0	1
 *
 *	Direção orizontal
 *
 *	-1	-2	-1
 *	 0	 0	 0
 *	 1	 2	 1
 */
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Sobel {

	public static void main(String[] args) {
		try {
			// define o tamanho do kernel para 9
			int kernelSize = 9;

			// carrega a lib do openCV
			System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

			// carrega o arquivo fonte da imagem em escala de cinza
			Mat source = Imgcodecs.imread("C:\\Users\\Juliana\\workspace_opencv\\OpenCVExample\\src\\example\\lena.png",
					Imgcodecs.CV_LOAD_IMAGE_GRAYSCALE);

			// instncia um objeto para destino
			Mat destination = new Mat(source.rows(), source.cols(), source.type());

			// define a matriz do kernel, contendo os seus pesos
			Mat kernel = new Mat(kernelSize, kernelSize, CvType.CV_32F) {
				{
					put(0, 0, -1);
					put(0, 1, 0);
					put(0, 2, 1);

					put(1, 0 - 2);
					put(1, 1, 0);
					put(1, 2, 2);

					put(2, 0, -1);
					put(2, 1, 0);
					put(2, 2, 1);
				}
			};

			// função que aplica o operador de sobel à imagem de origem e salva
			// na imagem de origem
			Imgproc.filter2D(source, destination, -1, kernel);

			// grava a imagem de destino
			Imgcodecs.imwrite("C:\\Users\\Juliana\\workspace_opencv\\OpenCVExample\\src\\example\\lena_sobel.jpg",
					destination);

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
