package com.myitbbs.uitl;

public class Pager {
	private int pageNumber = 1;// 当前的页面
	private int allPage = 0;// 总共的页数
	private int allObject = 0;// 所有的对象
	private int firstResult = 1;// 起始位置
	private int pageSize = 5;// 每页个数
	private int Next;//是否有上页
	private int Pre;//是否有下页


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
