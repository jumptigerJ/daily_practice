package com.study.list;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server {

	public static void main(String[] args) {
		try {
			while(true){
				
				ServerSocket serverSocket = new ServerSocket(5555);
				Socket socket = serverSocket.accept();
				System.out.println("客户端已经连接");
				
				FileInputStream fis = new FileInputStream("SampleChapter1.pdf");
				byte[] b = new byte[1024];
				while((fis.read(b))!=-1){
					socket.getOutputStream().write(b);
				}
				System.out.println("文件传送完毕");
				
			}
		
		
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
