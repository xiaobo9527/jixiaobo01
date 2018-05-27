package org.lanqiao.service2;

import java.util.List;

import org.lanqiao.dao.impl2.StudentDaoImpl;
import org.lanqiao.enity2.Student;

//ҵ���߼���--->ʵ�ִ��߼��ġ���ɾ�Ĳ顱�����������Ƕ����ݷ��ʲ�Ķ�����������ˡ���װ��
public class StudentService {
	// ҵ���߼������������ݷ��ʲ�
	StudentDaoImpl stuDao = new StudentDaoImpl();

	// ����ѧ��
	public boolean addStudent(Student stu) {
		//����֮ǰ��Ҫ�Ƚ����жϸ�ѧ���Ƿ��Ѿ�����
		if (stuDao.isExistByNo(stu.getStudentNo())) {
			System.out.println("�����Ѵ��ڣ������ظ�����");
			return false;
		}
		// ���÷��ʲ�ķ�����ʵ��ѧ��������
		return stuDao.addStudent(stu);
	}

	// ����ѧ�ţ�ɾ��ѧ��
	public boolean deleteStudentByNo(int stuNo) {
		// ɾ��֮ǰ�����жϸ�ѧ���Ƿ���ڣ������������޷�ɾ��
		if (stuDao.isExistByNo(stuNo) == false) {
			// isExitsByNo����ֵΪfalse��ʾ��ѧ��������
			System.out.println("��ʾ---StudentService:��ѧ�������ڣ�ɾ��ʧ��");
			return false;
		} else {

			// �������ݷ��ʲ㣬ʵ��ɾ������
			return stuDao.deleteStudentByNo(stuNo);
		}
	}
	
	// �޸�ѧ����Ϣ:��ԭ��ѧ��ΪstuNo��ѧ����Ϣ���޸�Ϊʵ����stu�еİ�����Ϣ
	public boolean updateStudent(Student stu,int stuNo) {
		//�޸�֮ǰ���жϣ��жϸ�ѧ���Ƿ���ڣ��������ڣ��޸�ʧ��
		if(stuDao.isExistByNo(stuNo) == false) {
			System.out.println("��ѧ�������ڣ��޸�ʧ��");
			return false;
		}else {
			return stuDao.updateStudent(stu, stuNo);
			
		}
		
	}
	//��ѯȫ��ѧ��
		public List<Student> queryAllStudent(){
			
			//��ѯ����һ�㲻���жϣ�ֱ�ӵ������ݷ��ʲ�ķ�������
			return stuDao.queryAllStudents();
		}
		
		//����ѧ�ţ��ж�ĳһѧ���Ƿ����
		public boolean isExistByNo(int stuNo) {
			
			//ֱ�ӵ������ݷ��ʲ�ķ��������ж�
			return stuDao.isExistByNo(stuNo);
			
		}
		
		//����ѧ�ţ���ѯĳһ��ѧ��
		public Student queryStudengByNo(int stuNo) {
			//��ѯ����һ�㲻���жϣ�ֱ�ӵ������ݷ��ʲ�ķ�������
			return stuDao.queryStudentByNo(stuNo);
		}
}
