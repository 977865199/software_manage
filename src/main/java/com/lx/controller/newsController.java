package com.lx.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.lx.model.image;
import com.lx.model.news;
import com.lx.service.imageServiceImpl;
import com.lx.service.newsServiceImpl;
import com.lx.util.newsUtil;

@Controller
public class newsController {
	
	@Autowired
	private newsServiceImpl ss;
	private newsUtil nu;
	
	//����������վ��ҳ
//		@RequestMapping("/index")
//		public ModelAndView getModelAndView() {
//			ModelAndView mv = null;
//
//			try {
//				mv = new ModelAndView("index");
//				ArrayList<news> news = ss.getAllNews();
//				
//				mv.addObject("data1",news);
//				
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			return mv;
//			
//		}
		@RequestMapping("/index")
		public ModelAndView showNews() {
			ModelAndView mv = null;
			
			try {
				mv = new ModelAndView("index");
				ArrayList<news> data1 = ss.getByType("�γ̽���");
				ArrayList<news> data2 = ss.getByType("�γ�����");
				ArrayList<news> data3 = ss.getByType("�γ�ʵ��");
				ArrayList<news> data4 = ss.getByType("��ѧ�Ŷ�");
			
				
				
				mv.addObject("data1",data1);
				mv.addObject("data2",data2);
				mv.addObject("data3",data3);
				mv.addObject("data4",data4);
				
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return mv;
			
		}
		
		
		
		
		@RequestMapping("/news1")
		public ModelAndView showNews1() {
			ModelAndView mv = null;
			
			try {
				mv = new ModelAndView("showNews");
				ArrayList<news> data = ss.getByType("�γ̽���");

				mv.addObject("data",data);	
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return mv;
			
		}
		
		
		
		@RequestMapping("/news2")
		public ModelAndView showNews2() {
			ModelAndView mv = null;
			
			try {
				mv = new ModelAndView("showNews");
				
				ArrayList<news> data = ss.getByType("�γ�����");

				mv.addObject("data",data);
	
			} catch (Exception e) {
				e.printStackTrace();
			}
			return mv;
			
		}
		
		
		
		
		@RequestMapping("/news3")
		public ModelAndView showNews3() {
			ModelAndView mv = null;
			
			try {
				mv = new ModelAndView("showNews");
				
				ArrayList<news> data = ss.getByType("�γ�ʵ��");

				mv.addObject("data",data);
	
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return mv;
			
		}
		
		
		
		@RequestMapping("/news4")
		public ModelAndView showNews4() {
			ModelAndView mv = null;
			
			try {
				mv = new ModelAndView("showNews");
				
				ArrayList<news> data = ss.getByType("��ѧ�Ŷ�");
		
				mv.addObject("data",data);
	
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return mv;
			
		}
		
//		//�������Ա��¼����
//		@RequestMapping("/login")
//		public String addNews(String news_user,String news_password) {
//			if("sqroot".equals(news_user)&&"dyr2015".equals(news_password)) {
//				isLogined = true;
//				return "addNews";
//			}
//			else {
//				return "login";
//			}
//		}
//		
//		//���뷢�����Ž���
//		@RequestMapping(value="/add")
//		public String returAaddNews() {
//			if(isLogined) {
//				return "addNews";
//			}
//			else {
//				return "login";
//			}
//		}
//		
//		//����������Ž���
//		@RequestMapping("/update")
//		public String updateNews() {
//			if(isLogined) {
//				return "updateNews";
//			}
//			else {
//				return "login";
//			}
//		}
//		
//		//����ɾ�����Ž���
//		@RequestMapping("/delete")
//		public String deleteNews() {
//			if(isLogined) {
//				return "deleteNews";
//			}
//			else {
//				return "login";
//			}
//		}
//		
//		//����˳���¼��ť�󣬽���¼״̬��Ϊ��
//		@RequestMapping("/exit")
//		public String exitLogin() {
//			isLogined = false;
//			return "login";
//		}
//		
		//�����ݿ���Ӽ�¼
		@RequestMapping("/addNews")
		public String addData(news ni,MultipartFile file,HttpServletRequest request) {
			String filePath = request.getSession().getServletContext().getRealPath("/upload");; //����ͼƬ�ϴ����·��
			String newFileName = fileOperate(file,filePath);
			String head=request.getParameter("head");
			String summary=request.getParameter("summary");
			String body=request.getParameter("body");
			newsUtil nu=new newsUtil();
			Date date=nu.strToDate(request.getParameter("date"));
			String type=request.getParameter("type");
			ni=new news(head,summary,body,date,newFileName,type);
			ni.setImg(newFileName);
			ss.addNews(ni);
			System.out.println("�����ɹ�");
			return "redirect:/addNews.jsp";
			
		}
//		
		//��������idɾ�����ݿ��е�ĳ����¼
		@RequestMapping("/deleteNews")
		public String deleteData(int id) {
			ss.deleteNews(id);
			System.out.println("�����ɹ�");
			return "redirect:/deleteNews.jsp";
			
		}
//		
		//��������id�������ݿ��еļ�¼
		@RequestMapping("/updateNews")
		public String updateData(news ni,MultipartFile file,HttpServletRequest request) {
			String filePath = request.getSession().getServletContext().getRealPath("/upload");; //����ͼƬ�ϴ����·��
			String newFileName = fileOperate(file,filePath);
			ni.setImg(newFileName);
			int id=Integer.valueOf(request.getParameter("id"));
			ni.setId(id);
			ss.updateNews(ni);
			System.out.println(filePath);
			System.out.println("�����ɹ�");
			return "redirect:/updateNews.jsp";
			
		}
//		
		//���ĳ�����ŵ����Ӻ����id��ø������ŵ����ݵ�
		@RequestMapping("/read")
		public ModelAndView getContent(int id) {
			ModelAndView mv = null;

			try {
				mv = new ModelAndView("concent");
				news news = ss.getContent(id);
				
				mv.addObject("data",news);
				System.out.println(news.getImg());
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return mv;
		}
		
		
		
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
