package com.study.list;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class serverSocket {

	public static void main(String[] args) {
	
			ServerSocket serverSocket = null;
			Socket socket = null;
			
			OutputStream os = null;
			InputStream is = null;
			
			int port = 5000;
			
			try {
				//建立连接
				serverSocket = new ServerSocket(port);
				//获得连接
				socket = serverSocket.accept();
				//接收客户端发送的内容
				is = socket.getInputStream();
				byte[] b = new byte[1024];
				int n = is.read();
				//输出
				System.out.println("客户端发送内容为："+ new String(b,0,n));
		
				
				os = socket.getOutputStream();
				os.write(b, 0, n);
				
				//关闭流和连接
				
				os.close();
				is.close();
				
				
				
				
				
				
				
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
			
			
			
			
			
			
			
		
		

	}

}
