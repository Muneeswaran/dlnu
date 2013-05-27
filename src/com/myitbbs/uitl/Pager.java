package com.myitbbs.uitl;

public class Pager {
	private int pageNumber = 1;// ��ǰ��ҳ��
	private int allPage = 0;// �ܹ���ҳ��
	private int allObject = 0;// ���еĶ���
	private int firstResult = 1;// ��ʼλ��
	private int pageSize = 5;// ÿҳ����
	private int Next;//�Ƿ�����ҳ
	private int Pre;//�Ƿ�����ҳ


	public Pager(int pageNumber, int allObject, int pageSize) {
		this.pageNumber = pageNumber;
		this.allObject = allObject;
		this.pageSize = pageSize;
		this.clu();
	}

	
	public int getNext() {

		return Next;
	}



	public int getPre() {
		return Pre;
	}


	public int getPageNumber() {
		return pageNumber;
	}

	public int getAllPage() {
		return allPage;
	}

	public int getAllObject() {
		return allObject;
	}

	public int getFirstResult() {
		return firstResult;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void clu(){
	this.allPage = this.allObject%this.pageSize == 0 ? (allObject/pageSize):(allObject/pageSize)+1;
	firstResult = (pageNumber - 1) * pageSize;
	if(pageNumber == 1){
		this.Pre = 0;
	}else{
		this.Pre = 1;
	}
	if(pageNumber == allPage){
		this.Next = 0;
	}else{
		if(allPage != 0){
		this.Next = 1;
		}else{
			this.Next = 0;
		}
	}
}}
