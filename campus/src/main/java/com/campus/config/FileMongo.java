package com.campus.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSFile;

@Component
public class FileMongo {
	@Autowired
	GridFsTemplate gridFsTemplate;
	@Autowired
	GridFSBucket gridFSBucket;
	@Autowired
	GridFsOperations gridFsOperations;
	
	/**
	 * 上传文件
	 * @param multipartFile 文件
	 */
	public void upFiles(MultipartFile multipartFile,String filename) {
		try {
			gridFsTemplate.store(multipartFile.getInputStream(),multipartFile.getOriginalFilename());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 下载文件
	 * @param filename文件名
	 * @param pathname存放路径
	 */
	public void getFiles(String filename,String pathname) {
	
		
		GridFSFile gridfsfile=gridFsOperations.getResource(filename).getGridFSFile();
		if(gridfsfile!=null) {
			GridFSDownloadStream downloadStream=gridFSBucket.openDownloadStream(gridfsfile.getId());
			GridFsResource gridFsResource=new GridFsResource(gridfsfile, downloadStream);
			String hzm=gridFsResource.getFilename().substring(gridFsResource.getFilename().lastIndexOf("."),gridFsResource.getFilename().length());			
			File file=new File(pathname+"/"+filename+hzm);
			if(!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			FileOutputStream fos;
			StringBuffer datas=new StringBuffer("");
			try {
				fos = new FileOutputStream(file);
				InputStreamReader isr=new InputStreamReader(gridFsResource.getInputStream(),"gbk");
				BufferedReader br=new BufferedReader(isr);
				String str="";
				while((str=br.readLine())!=null) {
					datas.append(str);
					datas.append("\r\n");
				}
				fos.write(datas.toString().getBytes());
				fos.close();			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	
	
	
}
