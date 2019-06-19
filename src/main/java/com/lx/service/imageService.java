package com.lx.service;

import java.util.List;

import com.lx.model.image;

public interface imageService {
	/**
	 * ͨ��id��ѯ�û�
	 */
	image selectById(int id);
	/**
	 * ����û���Ϣ
	 */
	void insertImage(image img);
	
	/**
	 * �޸��û���Ϣ
	 */
	void updateImage(image img);
	
	/**
	 * ��ʾ�û���Ϣ
	 */
	List<image> selectAll();
	
	/**
	 * ɾ���û���Ϣ
	 */
	void deleteImage(int id);
}
