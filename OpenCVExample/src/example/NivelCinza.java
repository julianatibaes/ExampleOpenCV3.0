/**
 * 
 */
package example;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

/**
 * @author Juliana
 *
 */
public class NivelCinza {

	BufferedImage image;
	int width;
	int height;

	public NivelCinza() {

		try {
			// carrega o arquivo fonte da image
			File input = new File("C:\\Users\\Juliana\\workspace_opencv\\OpenCVExample\\src\\example\\lena.png");
			image = ImageIO.read(input);
			width = image.getWidth();
			height = image.getHeight();

			for (int i = 0; i < height; i++) {

				for (int j = 0; j < width; j++) {

					// obtém o valor RGB da imagem
					Color c = new Color(image.getRGB(j, i));

					// calcula a proporção de cor que enxergamos para cada cor
					// do RGB
					int red = (int) (c.getRed() * 0.299);
					int green = (int) (c.getGreen() * 0.587);
					int blue = (int) (c.getBlue() * 0.114);

					// recebe a nova cor com os parâmetros calculados
					Color newColor = new Color(red + green + blue, red + green + blue, red + green + blue);

					// altera o padrão de cor do pixel da imagem colorida para
					// nível de cinza
					image.setRGB(j, i, newColor.getRGB());
				}
			}

			// grava a imagem de destino
			File ouptut = new File(
					"C:\\Users\\Juliana\\workspace_opencv\\OpenCVExample\\src\\example\\lena_nivel_cinza.jpg");
			ImageIO.write(image, "jpg", ouptut);

		} catch (Exception e) {
		}
	}

	public static void main(String[] args) {

		new NivelCinza();
	}

}
