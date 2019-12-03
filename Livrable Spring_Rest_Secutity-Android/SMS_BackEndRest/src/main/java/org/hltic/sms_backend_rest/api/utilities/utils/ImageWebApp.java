package org.hltic.sms_backend_rest.api.utilities.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Base64;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import sun.misc.BASE64Decoder;

public class ImageWebApp {
	
	@Autowired
	static ServletContext context;
	
	public static BufferedImage stringConvertToImage(String strImage) {
		
		BufferedImage bufferedImage = null;
		
		byte[] imageBytes;
		
		try {
			
			BASE64Decoder decoder = new BASE64Decoder();
			imageBytes = decoder.decodeBuffer(strImage);
			ByteArrayInputStream bis = new ByteArrayInputStream(imageBytes);
			
			bufferedImage = ImageIO.read(bis);
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		return bufferedImage;
	}
	
	
		public static String getImageWebApp(String image){
		
		String filePath = context.getRealPath("/inscriptions_imgs/");
		String searchFile = null;
		File fileFolder = new File(filePath);
		
		if(fileFolder != null) {
			for(final File file: fileFolder.listFiles()) {
				if(image.equals(file.getName())) {
					String encodeBase64 = null;
					try {
						String extension = FilenameUtils.getExtension(file.getName());
						FileInputStream fileInputStream = new FileInputStream(file);
						byte[] bytes = new byte[(int)file.length()];
						fileInputStream.read(bytes);
						encodeBase64 = Base64.getEncoder().encodeToString(bytes);
						searchFile = "data:image/" + extension + ";base64," + encodeBase64;
						
						fileInputStream.close();
						//System.out.println(searchFile);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		//System.out.println(searchFile);
		return searchFile;
	}
	
}
