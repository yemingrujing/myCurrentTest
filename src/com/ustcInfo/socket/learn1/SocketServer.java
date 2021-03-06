package com.ustcInfo.socket.learn1;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 简单学习Socket
 * @author guang.wei
 * @datetime 2018年4月17日 上午11:07:07
 */
public class SocketServer {

	public static void main(String[] args) throws Exception {
		//监听指定的端口
		int port = 55533;
		ServerSocket server = new ServerSocket(port);
		
		System.out.println("server将一直等待连接的到来");
		Socket socket = server.accept();
		//建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
		InputStream inputStream = socket.getInputStream();
		byte[] bytes = new byte[1024];
		int len;
		StringBuilder sb = new StringBuilder();
		//只有当客户端关闭它的输出流的时候，服务端才能取得结尾的-1
		while((len = inputStream.read(bytes)) != -1) {
			sb.append(new String(bytes, 0, len, "UTF-8"));
		}
		System.out.println("get message from client：" + sb);
		
		OutputStream outputStream = socket.getOutputStream();
		outputStream.write("Hello Client,I get the message.".getBytes("UTF-8"));
		
		inputStream.close();
		outputStream.close();
		socket.close();
		server.close();
	}
}
