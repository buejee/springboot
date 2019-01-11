package com.xxx.springboot.config.upload;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class CustomerMultipartResolver extends CommonsMultipartResolver {
	@Autowired
	private UploadProgressListener listener;
	public void setListener(UploadProgressListener listener) {
		this.listener = listener;
	}
	
	@Override
	protected MultipartParsingResult parseRequest(HttpServletRequest request) throws MultipartException {
		String encoding=determineEncoding(request);
		FileUpload upload = prepareFileUpload(encoding);
		upload.setFileSizeMax(1024000);
		upload.setSizeMax(1024000);
		listener.setSession(request.getSession());
		upload.setProgressListener(listener);
		try {
			List<FileItem> list = ((ServletFileUpload)upload).parseRequest(request);
			return parseFileItems(list, encoding);
		}catch(FileUploadException e) {
			e.printStackTrace();
		}
		return null;
	}
}
