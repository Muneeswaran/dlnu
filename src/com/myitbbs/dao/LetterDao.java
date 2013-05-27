package com.myitbbs.dao;

import java.util.List;

import com.myitbbs.model.Letter;
import com.myitbbs.uitl.Pager;

public interface LetterDao {


	public boolean delete(int id);//通过id删除

	public boolean delete(Letter letter);//通过实体删除

	public List<Letter> findAll();//查找所有

	public boolean save(Letter letter);//通过实体保存

	public Letter get(int id)throws Exception;//通过id获得

	public boolean update(Letter letter);//通过实体更新
	
	public List<Letter> senderLetter(Pager p,int id)throws Exception;//所发送的信息

	public List<Letter> receiveLetter(Pager p,int id)throws Exception;//所接收的信息

	public int countsenderLetter(int id)throws Exception;//发送信息的个数
	
	public int countreceiveLetter(int id) throws Exception;//接收信息的个数
	
	public int countNotReadLetter(int id) throws Exception;//未读信息的个数

}
