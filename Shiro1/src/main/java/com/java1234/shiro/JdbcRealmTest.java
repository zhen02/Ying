package com.java1234.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class JdbcRealmTest {

	public static void main(String[] args) {
		// ��ȡ�����ļ�����ʼ��securityManager����
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:jdbc_realm.ini");
		// ��ȡsecurityManagerʵ��
		SecurityManager secutityManager = factory.getInstance();
		// ��securityManagerʵ���󶨵�securityUtils
		SecurityUtils.setSecurityManager(secutityManager);
		// �õ���ǰ�û�
		Subject currentUser = SecurityUtils.getSubject();
		// ����token���� ���û���������
		UsernamePasswordToken token = new UsernamePasswordToken("java1234", "123456");
		try {
			currentUser.login(token);
			System.out.println("��֤�ɹ�");
		} catch (AuthenticationException e) {
			e.printStackTrace();
			System.out.println("��֤ʧ��");
		}
	}

}
