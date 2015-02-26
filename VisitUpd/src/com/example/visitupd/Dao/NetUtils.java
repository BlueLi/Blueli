package com.example.visitupd.Dao;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
public class NetUtils {
	public static String getStr(){
		 String ring = "";
		 final String url="http://192.168.1.248:8080/zuibian/food.json";
		
		try {
			
			URL url2 = new URL(url);
			HttpURLConnection urlconn = (HttpURLConnection) url2.openConnection();
			urlconn.setRequestMethod("GET"); 
//			urlconn.setDoInput(true);
//			urlconn.setDoOutput(true);
			urlconn.setConnectTimeout(5000);
			urlconn.setReadTimeout(5000);
			if(urlconn.getResponseCode() == 200){
				InputStream inStream = urlconn.getInputStream();
				byte[] by = new byte[1024];
				int length = 0;
				StringBuffer sb = new StringBuffer();
				while((length = inStream.read(by))!=-1){
					sb.append(new String(by, 0, length));
				}
				ring = sb.toString();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ring;
	}//Õ¯…œ 
	
	public static InputStream getInputStream(String path){
		InputStream  inputStream = null;
		try {
			URL url = new URL(path);
			HttpURLConnection urlconn = (HttpURLConnection) url.openConnection();
			urlconn.setRequestMethod("GET"); 
			urlconn.setConnectTimeout(5000);
			urlconn.setReadTimeout(5000);
			if(urlconn.getResponseCode() == 200){
				inputStream = urlconn.getInputStream(); 
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return inputStream;
	}
}
