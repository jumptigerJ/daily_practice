package com.study.list;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class fileDownload {
	
	private static final String REMOTE_FILE_URL = "http://211.103.156.163/u/cms/www/201511/25051940i6ou.pdf";
	private static final String LOCAL_FILE_PATH = "SampleChapter1.pdf";

	public static void main(String[] args) {
		new fileDownload(REMOTE_FILE_URL,LOCAL_FILE_PATH).download();
	}
	
	private String remoteFileUrl;
	private String localFilePath;
	public fileDownload(String remoteFileUrl,String localFilePath) {
		this.remoteFileUrl = remoteFileUrl;
		this.localFilePath = localFilePath;
	}
	
	public void download(){
		try {
			URL url = new URL(remoteFileUrl);
			
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			
			httpURLConnection.setConnectTimeout(5000);//5000毫秒没有连接上则放弃连接
			
			httpURLConnection.connect(); //连接
			
			System.out.println("连接url成功");
			
			int fileLength = httpURLConnection.getContentLength();
			System.out.println("文件大小"+(fileLength/1024.0)+"KB");
			
			System.out.println("开始下载");
			
			DataInputStream dis = new DataInputStream(httpURLConnection.getInputStream());
			FileOutputStream fos = new FileOutputStream(localFilePath);
			
			byte[] b = new byte[10240];
			
			for (int readSize; (readSize = dis.read(b)) > 0;) {
				fos.write(b, 0, readSize);
			}
			
			System.out.println("下载完毕");
			
			fos.close();
			dis.close();
			
			httpURLConnection.disconnect();
			
		
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
