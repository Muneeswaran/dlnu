package com.myitbbs.dao;

import java.util.List;

import com.myitbbs.model.Letter;
import com.myitbbs.uitl.Pager;

public interface LetterDao {


	public boolean delete(int id);//ͨ��idɾ��

	public boolean delete(Letter letter);//ͨ��ʵ��ɾ��

	public List<Letter> findAll();//��������

	public boolean save(Letter letter);//ͨ��ʵ�屣��

	public Letter get(int id)throws Exception;//ͨ��id���

	public boolean update(Letter letter);//ͨ��ʵ�����
	
	public List<Letter> senderLetter(Pager p,int id)throws Exception;//�����͵���Ϣ

	public List<Letter> receiveLetter(Pager p,int id)throws Exception;//�����յ���Ϣ

	public int countsenderLetter(int id)throws Exception;//������Ϣ�ĸ���
	
	public int countreceiveLetter(int id) throws Exception;//������Ϣ�ĸ���
	
	public int countNotReadLetter(int id) throws Exception;//δ����Ϣ�ĸ���

}
