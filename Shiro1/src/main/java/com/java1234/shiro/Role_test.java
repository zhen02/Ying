package com.java1234.shiro;

import org.apache.shiro.subject.Subject;
import org.junit.Test;

import com.comment.ShrioUtil;

public class Role_test {

	@Test
	public void test1(){
		Subject currentUser=ShrioUtil.login("classpath:shiro_role.ini", "jack", "123");
		if(currentUser.hasRole("role2")){
			System.out.println("��role2Ȩ��");
			if(currentUser.isPermitted("user:update")){
				System.out.println("����ɾ��");
			}else{
				System.out.println("�޷�ɾ��");
			}
		}else {
			System.out.println("û��role2Ȩ��");
		}
	}
	
}
