package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.BlogDAO;
import com.javaex.dao.CategoryDAO;
import com.javaex.dao.PostDAO;
import com.javaex.vo.BlogVO;

@Service
public class BlogService {
	@Autowired
	private BlogDAO blogdao;
	@Autowired
	private CategoryDAO catedao;
	@Autowired
	private PostDAO postdao;
	
	public Map<String, Object>getMainList(String id){
		Map<String, Object> list = new HashMap<>();
		list.put("blog", blogdao.getBlog(id));
		list.put("category", catedao.getCategory(id));
		list.put("category", postdao.getPostList(id));
		return list;
	}
	
	public BlogVO getBlog(String id) {
		return blogdao.getBlog(id);
	}
	
	public int basicUpdate(BlogVO vo, MultipartFile file) {
		String saveDir = "C:/javaStudy/fileupload/";
		
		System.out.println("BlogService.basicUpdate");
		System.out.println(file);
		
		//vo.setBlogTitle(saveDir);
		
		if (!file.isEmpty()) {
		// 오리지널파일
		String orgName = file.getOriginalFilename();
		System.out.println("orgName: " + orgName);
		
		// 확장자
		String exName = orgName.substring(orgName.indexOf("."));
		System.out.println("exName: " + exName);
		
		// 저장파일 이름(관리)
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
		System.out.println("saveName: " + saveName);
		
		// 파일패스
		String filePath = saveDir + saveName;
		System.out.println("filePath: " + filePath);
		
		// 파일사이즈
		long fileSize = file.getSize();
		System.out.println("fileSize: " + fileSize);
		
		// 저장 경로 VO 저장
		vo.setBlogFile(saveName);
		
		// 파일 업로드(HDD save)
			try {
				byte[] fileData = file.getBytes(); // 리턴형 배열
				OutputStream out = new FileOutputStream(filePath);
				BufferedOutputStream bout = new BufferedOutputStream(out);
				bout.write(fileData);
				bout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return blogdao.basicUpdate(vo);
	}
}