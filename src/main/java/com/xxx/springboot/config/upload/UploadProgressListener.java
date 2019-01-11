package com.xxx.springboot.config.upload;

import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.ProgressListener;
import org.springframework.stereotype.Component;
@Component
public class UploadProgressListener implements ProgressListener{
	private HttpSession session;
	public void setSession(HttpSession session) {
		this.session = session;
		Progress progress = new Progress();
		session.setAttribute("progress", progress);
	}
	@Override
	public void update(long read, long size, int items) {
		Progress progress = (Progress)session.getAttribute("progress");
		progress.setRead(read);
		progress.setSize(size);
		progress.setItems(items);
	}

}
