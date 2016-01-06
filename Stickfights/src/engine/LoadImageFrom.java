package engine;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

public class LoadImageFrom {
	public static BufferedImage loadImageFrom(Class <?> classfile, String sciezka) {
		URL url = classfile.getResource(sciezka);
		BufferedImage img = null;
		
		try {
			img = ImageIO.read(url);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return img;
	}

}
