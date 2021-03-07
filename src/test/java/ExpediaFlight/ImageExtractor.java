package ExpediaFlight;

import java.io.File;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class ImageExtractor {


	public static void main(String[] args) {
		File imageFile = new File("C:\\Users\\Pandiyan\\eclipse-workspace\\Expedia\\Folder2\\test.png");
		ITesseract instance = new Tesseract();
		instance.setDatapath("tessdata"); 
		instance.setTessVariable("user_defined_dpi", "300");
		try 
		{
			String result = instance.doOCR(imageFile);
			System.out.println(result);

		} catch (TesseractException e) 
		{
			System.err.println(e.getMessage());
		}
	}
}




