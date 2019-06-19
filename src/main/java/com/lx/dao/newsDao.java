package com.lx.dao;

import java.util.ArrayList;

import com.lx.model.news;

public interface newsDao {
	ArrayList<news> getAllNews();   //��ȡ��������
	void addNews(news ni);       //�����ݿ����һ����¼
	void deleteNews(int id);         //����idɾ�����ݿ���һ����¼
	void updateNews(news ni);    //����id�������ݿ���ĳ����¼
	news getContent(int id);     //����id��ø������ŵ�����
	ArrayList<news> getByType(String type);
	
}
