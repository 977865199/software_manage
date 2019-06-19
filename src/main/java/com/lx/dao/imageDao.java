package com.lx.dao;

import java.util.List;

import com.lx.model.image;

public interface imageDao {
	image selectById(int id);
	/**
	 * ����û���Ϣ
	 * @return 
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
