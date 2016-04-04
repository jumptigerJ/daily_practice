package com.study.list;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class client {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1",5555);
		
			
			DataInputStream dis = new DataInputStream(new BufferedInputStream(  
                    socket.getInputStream()));
			FileOutputStream fos = new FileOutputStream("new.pdf");
			
			byte[] b = new byte[1024];
			System.out.println("已连接到服务器");
			
			for (int readSize; (readSize = dis.read(b)) > 0;) {
				fos.write(b, 0, readSize);
			}
			
			System.out.println("下载完毕");
			
			fos.close();
			dis.close();
			socket.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
