import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import com.lx.dao.userDao;
import com.lx.model.user;


public class userServiceTest extends BaseTest{
	@Autowired
	private userDao uDao;
//	@Test
//	public void testAdduser(){
//
//		user u=new user("cc��ѧ","3333333333333","����","123456","3333333333333@qq.com","2");
//		int a=uDao.addUser(u);
//		System.out.println(a);
//	}
//	@Test
//	public void testqueryByid(){
//		
//		user u=uDao.queryByid("123478","����");
//		if(u!=null){
//			System.out.println(u.getEmail());
//			if(u.getPassword().equals("123456"))
//				System.out.println("right");
//			else
//				System.out.println("�������");
//				
//		}
//		
//	}
//	@Test
//	public void queryByUno(){
//		user u=uDao.queryByUno(3);
//		System.out.println(u.getName());
//	}
	@Test 
	public void deleteUser(){
		uDao.deleteUser(14);
	}

	
//	@Test
//	public void testQueryByFlag(){
//		String flag="1";
//		List<user> teachers=uDao.queryByFlag(flag);
//		for(user teacher:teachers){
//			System.out.println(teacher.getName());
//		}
//		
//	}
//	@Test
//	public void updateUser(){
//		user u=new user(6,"bb��ѧ","2222222222222","����","123456","2222222222222@qq.com","2");
//		System.out.println(u.getUno());
//		uDao.updateUser(u);
//	}

}
