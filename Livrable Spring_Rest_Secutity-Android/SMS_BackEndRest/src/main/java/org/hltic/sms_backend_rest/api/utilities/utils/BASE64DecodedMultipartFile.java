package org.hltic.sms_backend_rest.api.utilities.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

public class BASE64DecodedMultipartFile implements MultipartFile{
	
	private byte[] bytes;
	String name;
	String originalFilename;
	String contentType;
	boolean isEmpty;
	long size;

	public BASE64DecodedMultipartFile(byte[] bytes, String name, String originalFilename, String contentType,
	        long size) {
	    this.bytes = bytes;
	    this.name = name;
	    this.originalFilename = originalFilename;
	    this.contentType = contentType;
	    this.size = size;
	    this.isEmpty = false;
	}
	
	public BASE64DecodedMultipartFile(byte[] bytes, String name) {
	    this.bytes = bytes;
	    this.name = name;
	}
	/*
	public BASE64DecodedMultipartFile(byte[] bytes) {
	    this.bytes = bytes;
	   
	}
	*/

	@Override
	public String getName() {
	    return System.currentTimeMillis() + Math.random() + "-" + name.split("/")[1]; 
	}

	@Override
	public String getOriginalFilename() {
	    //return System.currentTimeMillis() + (int)Math.random()*10000 + "-" + name.split("/")[1];
		
		return name;
	}

	@Override
	public String getContentType() {
	    return name.split(";")[1];
	}

	@Override
	public boolean isEmpty() {
	    return bytes == null || bytes.length == 0;
	}

	@Override
	public long getSize() {
	    return bytes.length;
	}

	@Override
	public byte[] getBytes() throws IOException {
	    return bytes;
	}

	@Override
	public InputStream getInputStream() throws IOException {
	    return new ByteArrayInputStream(bytes);
	}

	@SuppressWarnings("resource")
	@Override
	public void transferTo(File dest) throws IOException, IllegalStateException {
		new FileOutputStream(dest).write(bytes);

	}
}
