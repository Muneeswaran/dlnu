package com.myitbbs.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.myitbbs.constant.Constant;
import com.myitbbs.model.Category;
import com.myitbbs.model.CategoryChild;
import com.myitbbs.model.Comment;
import com.myitbbs.model.Friend;
import com.myitbbs.model.Letter;
import com.myitbbs.model.Reply;
import com.myitbbs.model.Resourcefile;
import com.myitbbs.model.SystemMessage;
import com.myitbbs.model.Topic;
import com.myitbbs.model.User;
import com.myitbbs.service.TopicRemindService;
import com.myitbbs.service.UserService;
import com.myitbbs.service.serviceImpl.PageInfoServiceImpl;
import com.myitbbs.uitl.Md5Util;
import com.myitbbs.vo.UserInfoVo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Component
@Scope("prototype")
public class UserAction extends ActionSupport implements
		ModelDriven<UserInfoVo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -248849361665939561L;
	private Map session;
	private HttpServletResponse response;
	private Map request;
	private List<CategoryChild> categoryChildList;
	private UserService userServiceImpl;
	private List<Category> categoryList;
	private PageInfoServiceImpl pageInfoServiceImpl;
	private TopicRemindService topicRemindServiceImpl;
	public TopicRemindService getTopicRemindServiceImpl() {
		return topicRemindServiceImpl;
	}
	@Resource
	public void setTopicRemindServiceImpl(TopicRemindService topicRemindServiceImpl) {
		this.topicRemindServiceImpl = topicRemindServiceImpl;
	}

	private UserInfoVo userInfoVo = new UserInfoVo();
	private User user;
	private Topic topic;
	private InputStream inputStream;
	private String replyContent;// �ظ�����

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		try {

			this.replyContent = new String(replyContent.getBytes("ISO8859-1"),
					"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String password1;// ԭʼ����
	private String password2;// ������
	private String password3;// ȷ������
	private int friendId;
	private String fileName;
	private String reId;
	private int letterId;
	private String SMCheck = "0";
	private int smid;
	private int replyId;
	private int commentPageNum = 0;

	public int getCommentPageNum() {
		return commentPageNum;
	}

	public void setCommentPageNum(int commentPageNum) {
		this.commentPageNum = commentPageNum;
	}

	public int getReplyId() {
		return replyId;
	}

	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}

	public int getSmid() {
		return smid;
	}

	public void setSmid(int smid) {
		this.smid = smid;
	}

	public int getLetterId() {
		return letterId;
	}

	public void setLetterId(int letterId) {
		this.letterId = letterId;
	}

	public String getReId() {
		return reId;
	}

	public void setReId(String reId) {

		this.reId = reId;
	}

	private User sender;// ������
	private User receiver;// ������
	private String l_message;// ������Ϣ

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public User getReceiver() {
		return receiver;
	}

	public String getL_message() {
		return l_message;
	}

	public void setL_message(String lMessage) {
		try {
			l_message = new String(lMessage.getBytes("ISO8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	public int getFriendId() {
		return friendId;
	}

	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = Md5Util.MD5(password1);
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = Md5Util.MD5(password2);
	}

	public String getPassword3() {
		return password3;
	}

	public void setPassword3(String password3) {
		this.password3 = Md5Util.MD5(password3);
	}

	public String toUploadFilePage() {
		if (checkOn()) {
			return "toUploadFilePage";
		} else {
			userInfoVo.setMessage("亲，您还未登录哦！(^o^)");
			userInfoVo.setPath("LoginActiontoLoginPage");
			return "toForward";
		}
	}

	public String makeFriend() {
		boolean flag = false;
		if (checkOn()) {
			session = ActionContext.getContext().getSession();
			HttpServletResponse response = (HttpServletResponse) ActionContext
					.getContext().get(ServletActionContext.HTTP_RESPONSE);
			int userId = (Integer) session.get("userId");
			if (userId == this.friendId) {
				userInfoVo.setMessage("不能添加自己为好友");
			} else if (this.userServiceImpl.getTheSame(userId, friendId) != null) {
				userInfoVo.setMessage("您已向他/她发送请求，对方还未处理");
			} else {
				User master = userServiceImpl.getUser(userId);
				User fri = userServiceImpl.getUser(this.friendId);

				SystemMessage s = new SystemMessage();
				s.setMaster(master);
				s.setFriend(fri);
				s.setDate(new Date());
				s.setCheck("0");
				this.userServiceImpl.saveSystemMessage(s);
				userInfoVo.setMessage("请求发送成功");
			}
			userInfoVo.setPath("PageInfoActiontoFriendCenter?friendId="+this.friendId);
		} else {
			userInfoVo.setMessage("亲，您还未登录哦！(^o^)");
			userInfoVo.setPath("LoginActiontoLoginPage");
		}
		return "toForward";
	}

	public String deleteFriend() {
		session = ActionContext.getContext().getSession();
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(ServletActionContext.HTTP_RESPONSE);
		int userId = (Integer) session.get("userId");
		System.out.println("u = " + userId + "f = " + friendId);
		userServiceImpl.delectFriend(userId, friendId);
		userInfoVo.setMessage("删除成功");
		userInfoVo.setPath("PageInfoActiontoPersonCenter?userId=" + userId);
		return "toForward";
	}

	public String CheckSystemMessage() {
		boolean flag = false;
		SystemMessage s = this.userServiceImpl.getSystemMessage(smid);
		s.setCheck(SMCheck);
		System.out.println("SMCheck = " + SMCheck);
		if (this.SMCheck.equals("1")) {
			System.out.println("this.friendId" + this.friendId);
			flag = doMakeFriend(this.friendId);

			if (flag == false) {
				userInfoVo.setMessage("添加失败，不能添加自己或者好友已存在。");
			} else {
				userInfoVo.setMessage("添加成功");
			}

		} else {
			userInfoVo.setMessage("您已拒绝" + s.getMaster().getName() + "的请求");
		}

		this.userServiceImpl.CheckSystemMessage(s);
		System.out.println("s.getFriend().getId() = " + s.getFriend().getId());
		userInfoVo.setPath("PageInfoActionshowUserInfo?userId="
				+ s.getFriend().getId());// ע���������������������Ϣ��˵�Ǻ���
		return "toForward";
	}

	public boolean doMakeFriend(int fid) {
		session = ActionContext.getContext().getSession();
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(ServletActionContext.HTTP_RESPONSE);
		int userId = (Integer) session.get("userId");
		Friend friend = new Friend();
		User master = userServiceImpl.getUser(userId);

		User fri = userServiceImpl.getUser(fid);
		friend.set_friend(fri);
		friend.setMaster(master);
		return userServiceImpl.makeFriend(friend);
	}

	// �û��ϴ��ļ�
	public String uploadFile() {
		if (checkOn()) {

			session = ActionContext.getContext().getSession();
			HttpServletResponse response = (HttpServletResponse) ActionContext
					.getContext().get(ServletActionContext.HTTP_RESPONSE);
			try {

				int userId = (Integer) session.get("userId");
				String dir = ServletActionContext.getServletContext()
						.getRealPath("/uploadfiles");
				System.out.println("�ļ�����·��" + dir);
				Category category = new Category();
				category.setId(1);
				Resourcefile resourcefile = new Resourcefile();
				resourcefile.setDate(new Date());
				resourcefile.setFileName(userInfoVo.getUploadFileName());

				resourcefile.setFilePath(dir + File.separator + userId
						+ File.separator + userInfoVo.getUploadFileName());// ÿ���û�ӵ��һ����Դ���ļ���
				resourcefile.setUser(userServiceImpl.getUser(userId));
				resourcefile.setCategory(category);

				resourcefile.setState(userInfoVo.getFileState());

				if (userInfoVo.getUpload() != null) {

					System.out.println("imageFileName = "
							+ userInfoVo.getUploadFileName());
					File savefile = new File(new File(dir + File.separator
							+ userId), userInfoVo.getUploadFileName());
					if (!savefile.getParentFile().exists()) {
						savefile.getParentFile().mkdirs();
					}
					FileUtils.copyFile(userInfoVo.getUpload(), savefile);
					userServiceImpl.uploadFile(resourcefile);
					userInfoVo.setMessage("上传成功");
				} else {
					userInfoVo.setMessage("上传失败");
				}
			} catch (IOException e) {
				userInfoVo.setMessage("上传失败");
				e.printStackTrace();

			}

			userInfoVo.setPath("PageInfoActiontoResourcePage");

		} else {
			userInfoVo.setMessage("亲，您还未登录哦！(^o^)");
			userInfoVo.setPath("LoginActiontoLoginPage");

		}

		return "toForward";
	}

	// �ļ�ɾ��
	public String deleteFile() {
		int id = 0;
		if (checkOn()) {
			try {
				Resourcefile resourcefile = userServiceImpl
						.findResourcefile(userInfoVo.getResourcefileId());

				File file = new File(resourcefile.getFilePath());
				id = resourcefile.getUser().getId();
				if (file.exists()) {
					file.delete();
					userInfoVo.setMessage("删除成功");

				} else {
					userInfoVo.setMessage("无此文件");
				}
				userServiceImpl.deleteResourcefile(resourcefile);
			} catch (Exception e) {
				userInfoVo.setMessage("删除失败");
				e.printStackTrace();
			}

			userInfoVo.setPath("PageInfoActionshowUserInfo?userId=" + id);
		} else {
			userInfoVo.setMessage("亲，您还未登录哦！(^o^)");

			userInfoVo.setPath("LoginActiontoLoginPage");
		}

		return "toForward";
	}

	// �ļ�����
	public String downFile() {

		inputStream = downloadFile();

		return "downFile";
	}

	public InputStream downloadFile() {
		FileInputStream fileInputStream = null;

		try {
			Resourcefile resourcefile = userServiceImpl
					.findResourcefile(userInfoVo.getResourcefileId());

			System.out.println("����·�� = " + resourcefile.getFilePath());
			File file = new File(resourcefile.getFilePath());
			if (file.exists()) {
				System.out.println("�ļ�����");
				fileInputStream = new FileInputStream(file);
				this.fileName = file.getName();
			}else{
				userServiceImpl.deleteResourcefile(resourcefile);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return fileInputStream;
	}

	public boolean checkOn() {
		try {
			session = ActionContext.getContext().getSession();
			if (session.get("userId").equals("")
					|| session.get("userId") == null) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			return false;

		}
	}

	public String reportTopic() {
		Topic t = pageInfoServiceImpl.getTopicById(userInfoVo.getTopicId());
		t.setReport(t.getReport() + 1);
		userServiceImpl.updateTopic(t);
		userInfoVo.setMessage("举报成功");
		userInfoVo.setPath("PageInfoActionreadTopicPage?topicId="
				+ userInfoVo.getTopicId());
		return "toForward";
	}

	public String toWriteTopicPage() {
		if (checkOn()) {

			categoryList = pageInfoServiceImpl.getAllCategory();
			categoryChildList = pageInfoServiceImpl.getAllCategoryChild();
			return "toWriteTopicPage";
		} else {
			userInfoVo.setMessage("亲，您还未登录哦！(^o^)");
			userInfoVo.setPath("LoginActiontoLoginPage");
			return "toForward";
		}
	}

	public String doWriteTopic() {
		if (checkOn()) {
			CategoryChild categoryChild = new CategoryChild();
			System.out.println("1����Action����");
			topic = new Topic();
			try {
				topic.setTitle(userInfoVo.getTopicTitle());
				topic.setContents(userInfoVo.getContent1());
				System.out.println("��UserAction���� Title = "
						+ userInfoVo.getTopicTitle());
				System.out.println("��UserAction���� Contents = "
						+ userInfoVo.getContent1());
				System.out.println("��UserAction���澭��topic Title = "
						+ topic.getTitle());
				topic.setDate(new Date());
				categoryChild.setId(userInfoVo.getCategoryChildId());
				topic.setCategoryChild(categoryChild);
				topic.setReport(0);
				User user = new User();
				user
						.setId((Integer.parseInt(session.get("userId")
								.toString())));
				topic.setUser(user);
				topic.setTop(Constant.TOP);
				topic.setReadOrNot("0");
				topic.setCountBrowse(0);
				topic.setCountComment(0);
				userServiceImpl.writeTopic(topic);
				userInfoVo.setMessage("发表成功");

				userInfoVo.setPath("PageInfoActionreadTopicPage?topicId="
						+ topic.getId());

			} catch (Exception e) {
				userInfoVo.setMessage("发表帖子成功");
				System.out.println(e);
			}
		} else {

			userInfoVo.setMessage("发表帖子失败");
			userInfoVo.setPath("LoginActiontoLoginPage");

		}
		return "toForward";
	}

	public String toWriteCommentPage() {
		categoryList = pageInfoServiceImpl.getAllCategory();
		categoryChildList = pageInfoServiceImpl.getAllCategoryChild();
		if (checkOn()) {
			try {
				doWriteCommentPage();

			} catch (Exception e) {

				e.printStackTrace();
				return "toLoginPage";
			}

		} else {
			userInfoVo.setMessage("亲，您还未登录哦！(^o^)");
			userInfoVo.setPath("LoginActiontoLoginPage");

		}
		return "toForward";
	}

	public void doWriteCommentPage() {
		if (checkOn()) {
			Comment comment = new Comment();

			try {
				Topic t = pageInfoServiceImpl.getTopicById(userInfoVo
						.getTopicId());
				comment.setTopic(t);
				comment.setDate(new Date());
				User user = new User();
				user
						.setId((Integer.parseInt(session.get("userId")
								.toString())));
				comment.setUser(user);
				comment.setContent(userInfoVo.getContent2());
				comment.setRead("0");
				userServiceImpl.writeComment(comment);
				int cc = t.getCountComment();// 
				t.setCountComment(++cc);// 
				userServiceImpl.updateTopic(t);
				this.topicRemindServiceImpl.remindByComment(t);
				userInfoVo.setMessage("评论成功");
				userInfoVo.setPath("PageInfoActionreadTopicPage?topicId="
						+ userInfoVo.getTopicId() + "&&commentPageNum="
						+ commentPageNum);
			} catch (Exception e) {
				userInfoVo.setMessage("评论失败");
				e.printStackTrace();
			}

		} else {
			userInfoVo.setMessage("亲，您还未登录哦！(^o^)");
			userInfoVo.setPath("LoginActiontoLoginPage");

		}

	}

	public String alterUserInfo() {// ����û���Ϣ
		if (checkOn()) {
			try {
				User u = userServiceImpl.getUser(userInfoVo.getUserId());
				u.setTel(userInfoVo.getTel());
				u.setMajor(userInfoVo.getMajor());
				u.setState(userInfoVo.getState());
				u.setSex(userInfoVo.getUserSex());
				u.setNation(userInfoVo.getNation());
				u.setTruename(userInfoVo.getTrueName());
				userInfoVo.setMessage("用户信息更新成功");
				userServiceImpl.changeUser(u);
				userInfoVo.setPath("PageInfoActioninformationChange?userId="
						+ u.getId());
			} catch (Exception e) {
				userInfoVo.setMessage("用户信息更新失败");
				e.printStackTrace();
			}

		} else {
			userInfoVo.setMessage("亲，您还未登录哦！(^o^)");
			userInfoVo.setPath("LoginActiontoLoginPage");

		}
		return "toForward";
	}

	public String delectTopic() {
		if (checkOn()) {
			try {
				Topic t = pageInfoServiceImpl.getTopicById(userInfoVo
						.getTopicId());
				userServiceImpl.deleteTopic(t.getId());
				userInfoVo.setMessage("删帖成功");
				userInfoVo.setPath("PageInfoActionshowUserInfo?userId="
						+ userInfoVo.getUserId());
			} catch (Exception e) {
				userInfoVo.setMessage("删帖失败");
				e.printStackTrace();
			}
		} else {
			userInfoVo.setMessage("亲，您还未登录哦！(^o^)");
			userInfoVo.setPath("LoginActiontoLoginPage");

		}
		return "toForward";
	}

	public String changePassword() {
		boolean b = userServiceImpl.changePassword(userInfoVo.getUserId(),
				password1, password2, password3);

		if (b) {
			userInfoVo.setMessage("修改成功");
			userInfoVo.setPath("PageInfoActionshowUserInfo?userId="
					+ userInfoVo.getUserId());
		} else {
			userInfoVo.setMessage("原始密码有误");
			userInfoVo.setPath("PageInfoActionshowUserInfo?userId="
					+ userInfoVo.getUserId());
		}
		return "toForward";
	}

	public UserService getUserServiceImpl() {
		return userServiceImpl;
	}

	public String delectLetter() {
		try {
			this.userServiceImpl.deleteLetter(this.letterId);
			userInfoVo.setMessage("删除成功");
		} catch (Exception e) {
			userInfoVo.setMessage("删除失败");
			e.printStackTrace();
		}
		userInfoVo.setPath("PageInfoActiontoInbox");
		return "toForward";
	}

	public String writeLetter() {
		session = ActionContext.getContext().getSession();
		int senId = Integer.parseInt(session.get("userId").toString());
		this.sender = userServiceImpl.getUser(senId);
		this.receiver = userServiceImpl.getUser(Integer.parseInt(reId));
		Letter l = new Letter();
		l.setSender(this.sender);
		l.setReceiver(this.receiver);
		l.setContent(this.l_message);
		// l.setDate(new Date());
		l.setReadOrNot(Constant.LETTERNOTREAD);
		try {
			if (userServiceImpl.sendLetter(l)) {
				userInfoVo.setMessage("发送成功");
			} else {
				userInfoVo.setMessage("发送失败");
			}
		} catch (Exception e) {
			userInfoVo.setMessage("发送失败");
			e.printStackTrace();
		}
		userInfoVo.setPath("PageInfoActiontoPersonCenter?userId=" + senId);

		return "toForward";
	}

	public String WriteReply() {
		if (checkOn()) {
			session = ActionContext.getContext().getSession();
			int uId = Integer.parseInt(session.get("userId").toString());
			Comment c = userServiceImpl.getCommentById(userInfoVo.getCommentId());
		
			Reply r = new Reply();
			User u2 = new User();
			u2.setId(uId);
			r.setUser(u2);
			r.setComment(c);
			r.setContent(replyContent);
			userServiceImpl.addReply(r);
			this.topicRemindServiceImpl.remindByReply(c);
			userInfoVo.setMessage("回复成功");
			userInfoVo.setPath("PageInfoActionreadTopicPage?topicId="
					+ userInfoVo.getTopicId() + "&&commentPageNum="
					+ commentPageNum);
		} else {
			userInfoVo.setMessage("亲，您还未登录哦！(^o^)");
			userInfoVo.setPath("LoginActiontoLoginPage");

		}
		return "toForward";
	}

	public String toPostMessage() {
		categoryList = pageInfoServiceImpl.getAllCategory();
		this.receiver = userServiceImpl.getUser(Integer.parseInt(this.reId));
		return "toPostMessage";
	}

	@Resource(name = "userServiceImpl")
	public void setUserServiceImpl(UserService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

	public UserInfoVo getUserInfoVo() {
		return userInfoVo;
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	public PageInfoServiceImpl getPageInfoServiceImpl() {
		return pageInfoServiceImpl;
	}

	@Resource(name = "pageInfoServiceImpl")
	public void setPageInfoServiceImpl(PageInfoServiceImpl pageInfoServiceImpl) {
		this.pageInfoServiceImpl = pageInfoServiceImpl;
	}

	public void setUserInfoVo(UserInfoVo userInfoVo) {
		this.userInfoVo = userInfoVo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public UserInfoVo getModel() {
		return userInfoVo;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public List<CategoryChild> getCategoryChildList() {
		return categoryChildList;
	}

	public void setCategoryChildList(List<CategoryChild> categoryChildList) {
		this.categoryChildList = categoryChildList;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public Map getRequest() {
		return request;
	}

	public void setRequest(Map request) {
		this.request = request;
	}

	public InputStream getInputStream() throws IOException {
		// ServletActionContext.getResponse().setHeader("Content-Disposition","attachment;fileName="+java.net.URLEncoder.encode(fileName,
		// "UTF-8"));
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getFileName() {
		try {
			this.fileName = this.fileName = java.net.URLEncoder.encode(
					this.fileName, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("�����ļ��� = " + this.fileName);
		return this.fileName;
	}

	public void setFileName(String fileName) {
		try {

			this.fileName = new String(fileName.getBytes("ISO8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setSMCheck(String sMCheck) {
		SMCheck = sMCheck;
	}

	public String getSMCheck() {
		return SMCheck;
	}

}
