package com.myitbbs.vo;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import com.myitbbs.model.Topic;

public class UserInfoVo {
	
	
	private int select = 1;
	public int getSelect() {
		return select;
	}

	private String message;//提示消息
	private String path;//路径
	public String getPath() {
		
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

	
	public String getMessage() {
	
		return this.message;
	}
	public void setMessage(String message) {

		this.message = message;
	}
	
	private int userId = 0;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		       
		this.userId = userId;
	}
	
	private int topicId = 0;
	private int categoryId = 0;
	private int categoryChildId = 0;
	private int commentId = 0;
	
	private String userName = null;
	
	private String topicTitle;
	

	private String content1;//帖子的内容
	private String content2;//评论的内容
	private String newstitle;
	
	private List<Topic> topicList;//保存个人帖子
	
	private String name;
	private Date birthday;
	private String address;
	private String email;
	private String tel;
	private String file;
	private String nation;
	private String userSex;
	private String major;
	private String trueName;
	private String state;
	
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		try {
			this.trueName = new String(trueName.getBytes("ISO8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getState() {
	
		return state;
	}
	public void setState(String state) {
		try {
			
			this.state = new String(state.getBytes("ISO8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 文件上传
	private File upload;
//	private String fileName;
	private String fileState;
	private int resourcefileId;
	private String filePath; 
	private	String uploadFileName;
	
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		try {
			this.userSex = new String(userSex.getBytes("ISO8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		try {
			this.major = new String(major.getBytes("ISO8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Topic> getTopicList() {
		return topicList;
	}
	public void setTopicList(List<Topic> topicList) {
		this.topicList = topicList;
	}
	public String getNewstitle() {
		return newstitle;
	}
	public void setNewstitle(String newstitle) {
		this.newstitle = newstitle;
	}
	public String getNewscontent() {
		return newscontent;
	}
	public void setNewscontent(String newscontent) {
		this.newscontent = newscontent;
	}
	private String newscontent;
	public String getContent2() {
		return content2;
	}
	public void setContent2(String content2) {
		try {
			this.content2 = new String(content2.getBytes("ISO8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getTopicTitle() {
		System.out.println("在UserVO里面getter之前 Title = "+ topicTitle);
		return topicTitle;
	}
	public void setTopicTitle(String topicTitle) {
		try {
			System.out.println("在UserVO里面setter之前 Title = "+ topicTitle);
			this.topicTitle = new String(topicTitle.getBytes("ISO8859-1"),"utf-8");
			System.out.println("在UserVO里面setter之后 Title = "+ topicTitle);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getContent1() {
		return content1;
	}
	public void setContent1(String content1) {
		
		try {
			this.content1 = new String(content1.getBytes("ISO8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getTopicId() {
		return topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getCategoryChildId() {
		return categoryChildId;
	}
	public void setCategoryChildId(int categoryChildId) {
		this.categoryChildId = categoryChildId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		try {
			this.name = new String(name.getBytes("ISO8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		try {
			this.address = new String(address.getBytes("ISO8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		try {
			this.email = new String(email.getBytes("ISO8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		try {
			this.nation = new String(nation.getBytes("ISO8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
//	public String getFileName() {
//		System.out.println("fileName = "+fileName);
//		return fileName;
//	}
//	public void setFileName(String fileName) {
//		System.out.println("fileName11111 = "+fileName);
//		try {
//			this.fileName = new String(fileName.getBytes("ISO8859-1"),"utf-8");
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	public String getFileState() {
		return fileState;
	}
	public void setFileState(String fileState) {
		this.fileState = fileState;
	}
	public int getResourcefileId() {
		return resourcefileId;
	}
	public void setResourcefileId(int resourcefileId) {
		this.resourcefileId = resourcefileId;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public void setSelect(int select) {
		this.select = select;
	}
	
	
}
