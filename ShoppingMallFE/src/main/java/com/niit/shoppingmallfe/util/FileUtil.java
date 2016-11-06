package com.niit.shoppingmallfe.util;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;


import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUtil {
	public String imagepath;
	public String upload(MultipartFile filea){
		if(!filea.isEmpty()){
			InputStream inputStream = null;
			OutputStream outputStream = null;
			if(filea.getSize() > 0){
				try {
						inputStream = filea.getInputStream();
						outputStream = new FileOutputStream("E:/Images/"+filea.getOriginalFilename());
						System.out.println(filea.getOriginalFilename());
						imagepath="E:/Images/"+filea.getOriginalFilename()+".jpg";
						int readBytes=0;
						byte[] buffer = new byte[8192];
						while((readBytes = inputStream.read(buffer, 0, 8192))!= -1){
							outputStream.write(buffer, 0, readBytes);
						}
						outputStream.close();
						inputStream.close();
						/*session.setAttribute("success", "File Uploaded Successfully!");
						session.setAttribute("productMall", "E:/Images/" + filea.getOriginalFilename());*/
					}catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} 
		}return imagepath;
	}	
}				
			/*try {
					inputStream = filea.getInputStream();
					outputStream = new FileOutputStream(path+fileName);
					imagepath=path+fileName;
					int readBytes = 0;
					byte[] buffer = new byte[1024];
					while((readBytes = inputStream.read(buffer, 0, 1024))!=1){
						outputStream.write(buffer, 0, readBytes);
					}
					outputStream.close();
					inputStream.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				
			
		
		
	


