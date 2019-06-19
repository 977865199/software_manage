package com.lx.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.lx.model.image;
import com.lx.service.imageServiceImpl;

@Controller
public class imageController {
	@Autowired
	private imageServiceImpl ss;
	@RequestMapping("/m_addImage")
	public String index(ModelMap map) {
		List<image> img = ss.selectAll();
		map.addAttribute("userList",img);
		return "m_addImage";
	}
	
	@RequestMapping("/addUser")
	public String addUser(image img,MultipartFile file,HttpServletRequest request) throws IOException {
		System.out.println("�ύ���û���"+img);
		String filePath = request.getSession().getServletContext().getRealPath("/upload");; //����ͼƬ�ϴ����·��
		String newFileName = fileOperate(file,filePath);
		
		
		String name=request.getParameter("name");
		img =new image(name,newFileName);
		System.out.println("����user:"+img);
		ss.insertImage(img);
		System.out.println("�����ɹ���");
		return "redirect:/m_addImage";
	}
	
	
	/**
	 * ��ת���޸��û���Ϣҳ��
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping("/toUpdateUser")
	public String toUpdateUserPage(Integer id,ModelMap map) {
		System.out.println("id:"+id);
		image img = ss.selectById(id);
		System.out.println("�޸ĺ��ȡ��user��"+img);
		map.addAttribute("user",img);
		return "updateUser";
	}
	
	@RequestMapping("/updateUser")
	public String updateUser(image img,MultipartFile file,HttpServletRequest request) throws Exception{
		System.out.println("�޸��ύ���û���"+img);
		String filePath = request.getSession().getServletContext().getRealPath("/upload");; //����ͼƬ�ϴ����·��
		String newFileName = fileOperate(file,filePath);
		img.setImg(newFileName);
		System.out.println("�޸�����user:"+img);
		ss.updateImage(img);
		return "redirect:/m_addImage";
	}
	
	@RequestMapping("/deleteUser")
	public String deleteUser(Integer id) {
		ss.deleteImage(id);
		return "redirect:/m_addImage";
	}
	
	/**
	 * ��װ�����ļ������� ����û� ���޸��û������õ�
	 * @param file
	 * @param filePath
	 * @return
	 */
	private String fileOperate(MultipartFile file,String filePath) {
		String originalFileName = file.getOriginalFilename();//��ȡԭʼͼƬ����չ��
		System.out.println("ͼƬԭʼ���ƣ�"+originalFileName);
		String newFileName = UUID.randomUUID()+originalFileName;  //�µ��ļ�����
		System.out.println("�µ��ļ����ƣ�"+newFileName);
		File targetFile = new File(filePath,newFileName); //�������ļ�
		try {
			file.transferTo(targetFile); //�ѱ����ļ��ϴ����ļ�λ�� , transferTo()��springmvc��װ�ķ���������ͼƬ�ϴ�ʱ�����ڴ���ͼƬд�����
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}   
		return newFileName;
	}
}
