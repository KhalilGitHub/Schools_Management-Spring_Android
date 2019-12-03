package org.hltic.sms_backend_rest.api.utilities.utils;

import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;


public class Base64Util {
	
	public static MultipartFile base64MultipartFile(String base64, String fileName)
	{
	
			byte[] imageBytes = null;
			
			try {
				
				BASE64Decoder decoder = new BASE64Decoder();
				imageBytes = decoder.decodeBuffer(base64);
				
			return new BASE64DecodedMultipartFile(imageBytes, fileName);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
