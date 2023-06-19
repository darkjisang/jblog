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
	
	private Map<String, Object>list = new HashMap<>();
	
	//전체 리스트(블로그 메인)
	public Map<String, Object>getMainList(String id){
		list.put("blog", blogdao.getBlog(id));
		list.put("category", catedao.getCategoryList(id));
		list.put("post", postdao.getPostList(id));
		return list;
	}
	
	public BlogVO getBlog(String id) {
		return blogdao.getBlog(id);
	}
	
	public Map<String, Object> getCateAdmin(String id) {
		list.put("blog", blogdao.getBlog(id));
		list.put("category", catedao.getCategoryList(id));
		return list;
	}
	
	public int basicUpdate(BlogVO vo, MultipartFile file) {
		String saveDir = "C:/javaStudy/fileupload/";
		
		//vo.setBlogTitle(saveDir);
		
		if (!file.isEmpty()) {
		// 오리지널파일
		String orgName = file.getOriginalFilename();
		
		// 확장자
		String exName = orgName.substring(orgName.indexOf("."));
		
		// 저장파일 이름(관리)
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
		
		// 파일패스
		String filePath = saveDir + saveName;
		
		// 파일사이즈
		//long fileSize = file.getSize();
		
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