package com.comment;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class ShrioUtil {

	public static Subject login(String configFile,String userName,String password){
		// ��ȡ�����ļ�����ʼ��securityManager����
		Factory<SecurityManager> factory = new IniSecurityManagerFactory(configFile);
		// ��ȡsecurityManagerʵ��
		SecurityManager secutityManager = factory.getInstance();
		// ��securityManagerʵ���󶨵�securityUtils
		SecurityUtils.setSecurityManager(secutityManager);
		// �õ���ǰ�û�
		Subject currentUser = SecurityUtils.getSubject();
		// ����token���� ���û���������
		UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
		try {
			currentUser.login(token);
			System.out.println("��֤�ɹ�");
		} catch (AuthenticationException e) {
			e.printStackTrace();
			System.out.println("��֤ʧ��");
		}
		return currentUser;		
	}
	
}
