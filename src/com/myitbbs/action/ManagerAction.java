package com.myitbbs.action;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.swing.text.AbstractDocument.Content;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.myitbbs.constant.Constant;
import com.myitbbs.model.Category;
import com.myitbbs.model.CategoryChild;
import com.myitbbs.model.Comment;
import com.myitbbs.model.News;
import com.myitbbs.model.Resourcefile;
import com.myitbbs.model.Topic;
import com.myitbbs.model.User;
import com.myitbbs.service.serviceImpl.ManagerServiceImpl;
import com.myitbbs.uitl.Pager;
import com.myitbbs.vo.ManagerInfoVo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Component("managerAction")
@Scope("prototype")
public class ManagerAction extends ActionSupport implements
		ModelDriven<ManagerInfoVo> {
	private ManagerInfoVo managerInfoVo = new ManagerInfoVo();
	private List<User> userList;
	private ManagerServiceImpl managerServiceImpl;
	private List<News> newsList;
	private List<Topic> topicList;
	private List<Comment> commentList;
	private static int flag = 0;
    private String newsContent;
    private Pager cp;
    private int topicPageNum = 1;
    private int allVisit;
    public int getAllVisit() {
		return allVisit;
	}

	public void setAllVisit(int allVisit) {
		this.allVisit = allVisit;
	}

	public int getCurdate() {
		return curdate;
	}

	public void setCurdate(int curdate) {
		this.curdate = curdate;
	}

	public int getCurweek() {
		return curweek;
	}

	public void setCurweek(int curweek) {
		this.curweek = curweek;
	}

	public int getCurmonth() {
		return curmonth;
	}

	public void setCurmonth(int curmonth) {
		this.curmonth = curmonth;
	}

	public int getLate7dates() {
		return late7dates;
	}

	public void setLate7dates(int late7dates) {
		this.late7dates = late7dates;
	}

	private int curdate;
    private int curweek;
    private int curmonth;
    private int late7dates;
	public int getTopicPageNum() {
		return topicPageNum;
	}

	public void setTopicPageNum(int topicPageNum) {
		this.topicPageNum = topicPageNum;
	}

	public Pager getCp() {
		return cp;
	}

	public void setCp(Pager cp) {
		this.cp = cp;
	}

	public String getNewsContent() {
		return newsContent;
	}

	public void setNewsContent(String newsContent) {
		try {
			this.newsContent = new String(newsContent.getBytes("ISO8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    public String visit(){
    	this.curdate = managerServiceImpl.findCURDATEVisit();
    	this.allVisit = managerServiceImpl.findALLVisit();
    	this.curweek = managerServiceImpl.findCURWEEKVisit();
    	this.curmonth = managerServiceImpl.findCURMONTHVisit();
    //	this.late7dates = managerServiceImpl.findLATE7DAYSVisit();
    	return "adminMain";
    }
	public List<Topic> getTopicList() {
		return topicList;
	}

	public void setTopicList(List<Topic> topicList) {
		this.topicList = topicList;
	}

	public List<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}

	private User user;
	private List<Category> categoryList;
	private List<CategoryChild> categoryChildList;

	public List<CategoryChild> getCategoryChildList() {
		return categoryChildList;
	}

	public void setCategoryChildList(List<CategoryChild> categoryChildList) {
		this.categoryChildList = categoryChildList;
	}

	private Map session;

	public boolean checkOn() {
		session = ActionContext.getContext().getSession();
		try {
			String userName = (String) session.get("userName");
			int permission = (Integer) session.get("permission");
			if ("".equals(userName) || permission != Constant.ADMIN_PERMISSION) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// ��ת����̨�������
	public String toManagerPage() {
		if (checkOn()) {
			return "toManagerPage";
		} else {
			managerInfoVo.setMessage("亲，您还未登录或不是管理员(^o^)");
			managerInfoVo.setPath("LoginActiontoLoginPage");
			return "toForward";
		}
	}

	/************************* 模块管理 *****************************/
	public String addCategory() {
		if (checkOn()) {
			Category c = new Category();
			try {
				c.setDescribe(managerInfoVo.getCategoryDescribe());
				c.setName(managerInfoVo.getCategoryName());
				managerServiceImpl.addCategory(c);
				managerInfoVo.setMessage("添加模块成功");
				managerInfoVo.setPath("ManagerActiontoAddCategory");
			} catch (Exception e) {
				managerInfoVo.setMessage("添加模块失败");
				e.printStackTrace();
			}
			managerInfoVo.setPath("ManagerActiontoAddCategory");
		} else {
			managerInfoVo.setMessage("亲，您还未登录或不是管理员(^o^)");
			managerInfoVo.setPath("LoginActiontoLoginPage");

		}
		return "toForward";
	}
	public String toAddCategory() {
		if (checkOn()) {
			return "toAddCategory";
		} else {
			managerInfoVo.setMessage("亲，您还未登录或不是管理员(^o^)");
			managerInfoVo.setPath("LoginActiontoLoginPage");

		}
		return "toForward";
	}

	public String toAddCategoryChild() {
		if (checkOn()) {
			try {
				categoryList = managerServiceImpl.findCategory();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "toAddCategoryChild";
		} else {
			managerInfoVo.setMessage("亲，您还未登录或不是管理员(^o^)");
			managerInfoVo.setPath("LoginActiontoLoginPage");

		}
		return "toForward";
	}
	public String addCategoryChild() {
		if (checkOn()) {
			CategoryChild ch = new CategoryChild();
			try {
				Category c = managerServiceImpl.findCategoryById(managerInfoVo
						.getCategoryId());

				ch.setCategory(c);
				ch.setName(managerInfoVo.getCategoryChildName());
				ch.setDescrible(managerInfoVo.getCategoryChildDescribe());
				managerServiceImpl.addCategoryChild(ch);
				managerInfoVo.setMessage("添加子模块成功");

			} catch (Exception e) {
				managerInfoVo.setMessage("添加子模块失败");
				e.printStackTrace();
			}
			managerInfoVo.setPath("ManagerActiontoAddCategoryChild");
		} else {
			managerInfoVo.setMessage("亲，您还未登录或不是管理员(^o^)");
			managerInfoVo.setPath("LoginActiontoLoginPage");

		}
		return "toForward";
	}


	public String toAdminCategoryList() {
		if (checkOn()) {
			try {
				categoryList = managerServiceImpl.findCategory();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "toAdminCategoryList";
		} else {
			managerInfoVo.setMessage("亲，您还未登录或不是管理员(^o^)");
			managerInfoVo.setPath("LoginActiontoLoginPage");

		}
		return "toForward";
	}
	public String updateCategory() {
		if (checkOn()) {
			try {
				Category category = managerServiceImpl
						.findCategoryById(managerInfoVo.getCategoryId());
				category.setName(managerInfoVo.getCategoryName());
				category.setDescribe(managerInfoVo.getCategoryDescribe());
				managerServiceImpl.updateCategory(category);
				managerInfoVo.setMessage("修改模块成功");
				managerInfoVo.setPath("ManagerActiontoAdminCategoryList");
			} catch (Exception e) {
				e.printStackTrace();
			}
			managerInfoVo.setPath("ManagerActiontoAdminCategoryList");
		} else {
			managerInfoVo.setMessage("亲，您还未登录或不是管理员(^o^)");
			managerInfoVo.setPath("LoginActiontoLoginPage");

		}
		return "toForward";
	}


	public String deleteCategory() {
		if (checkOn()) {
			try {

				Category category = managerServiceImpl
						.findCategoryById(managerInfoVo.getCategoryId());
				managerServiceImpl.deleteCategory(category);
				managerInfoVo.setMessage("删除模块成功");

			} catch (Exception e) {
				managerInfoVo.setMessage("删除模块失败");
				e.printStackTrace();
			}

			managerInfoVo.setPath("ManagerActiontoAdminCategoryList");
		} else {
			managerInfoVo.setMessage("亲，您还未登录或不是管理员(^o^)");
			managerInfoVo.setPath("LoginActiontoLoginPage");

		}

		return "toForward";

	}

	public String toAdminCategoryChildList() {
		if (checkOn()) {
			try {
				categoryList = managerServiceImpl.findCategory();
				categoryChildList = managerServiceImpl.findCategoryChild();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "toAdminCategoryChildList";
		} else {
			managerInfoVo.setMessage("亲，您还未登录或不是管理员(^o^)");
			managerInfoVo.setPath("LoginActiontoLoginPage");

		}

		return "toForward";
	}

	public String updateCategoryChild() {
		if (checkOn()) {
			try {
				Category category = managerServiceImpl
						.findCategoryById(managerInfoVo.getCategoryId());
				CategoryChild categoryChild = managerServiceImpl
						.findCategoryChildById(managerInfoVo
								.getCategoryChildId());
				categoryChild.setName(managerInfoVo.getCategoryChildName());
				categoryChild.setDescrible(managerInfoVo
						.getCategoryChildDescribe());
				categoryChild.setCategory(category);
				managerServiceImpl.updateCategoryChild(categoryChild);
				managerInfoVo.setMessage("修改子模块成功");

			} catch (Exception e) {
				managerInfoVo.setMessage("修改子模块失败");
				e.printStackTrace();
			}
			managerInfoVo.setPath("ManagerActiontoAdminCategoryChildList");
		} else {
			managerInfoVo.setMessage("亲，您还未登录或不是管理员(^o^)");
			managerInfoVo.setPath("LoginActiontoLoginPage");

		}
		return "toForward";
	}

	public String deleteCategoryChild() {
		if (checkOn()) {
			try {
				CategoryChild categoryChild = managerServiceImpl
						.findCategoryChildById(managerInfoVo
								.getCategoryChildId());
				managerServiceImpl.deleteCategoryChild(categoryChild);
				managerInfoVo.setMessage("删除子模块成功");

			} catch (Exception e) {
				managerInfoVo.setMessage("删除子模块失败");
				e.printStackTrace();
			}
			managerInfoVo.setPath("ManagerActiontoAdminCategoryChildList");
		} else {
			managerInfoVo.setMessage("亲，您还未登录或不是管理员(^o^)");
			managerInfoVo.setPath("LoginActiontoLoginPage");

		}
		return "toForward";
	}

	/******************************** 用户管理 *********************************************/
	public String toAddUser() {
		if (checkOn()) {
			return "toAddUser";
		} else {
			managerInfoVo.setMessage("亲，您还未登录或不是管理员(^o^)");
			managerInfoVo.setPath("LoginActiontoLoginPage");

		}
		return "toForward";
	}

	public String addUser() {
		if (checkOn()) {
			try {
				User user = new User();
				user.setName(managerInfoVo.getUserName());
				user.setPassWord(managerInfoVo.getUserPassword());
				user.setPermission(managerInfoVo.getPermission());
				user.setSex(Constant.SEX);
				managerServiceImpl.addUser(user);

				managerInfoVo.setMessage("添加用户成功");

			} catch (Exception e) {
				managerInfoVo.setMessage("添加用户失败");
				e.printStackTrace();
			}
			managerInfoVo.setPath("ManagerActiontoAddUser");
		} else {
			managerInfoVo.setMessage("亲，您还未登录或不是管理员(^o^)");
			managerInfoVo.setPath("LoginActiontoLoginPage");

		}
		return "toForward";
	}

	public String toShowUser() {
		if (checkOn()) {
			try {
				Pager up = new Pager(managerInfoVo.getUserPage(),
						managerServiceImpl.userCount(),
						Constant.MANAGER_USER_NUM);
				userList = managerServiceImpl.findUser(up);
				managerInfoVo.setU_p(up);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "toShowUser";
		} else {
			managerInfoVo.setMessage("亲，您还未登录或不是管理员(^o^)");
			managerInfoVo.setPath("LoginActiontoLoginPage");

		}
		return "toForward";
	}

	public String deleteUser() {
		if (checkOn()) {
			try {
			List<Resourcefile> lr =	managerServiceImpl.findResourceByUserId(managerInfoVo.getUserId());
			File file = null;
			for(int i=0; i < lr.size(); i++){
				 file = new File(lr.get(i).getFilePath());
				 if (file.exists())
						file.delete();
				 managerServiceImpl.deleteResource(lr.get(i).getId());
			}
				managerServiceImpl.deleteUserById(managerInfoVo.getUserId());
				managerInfoVo.setMessage("删除用户成功");

			} catch (Exception e) {
				managerInfoVo.setMessage("删除用户失败");
				e.printStackTrace();
			}
			managerInfoVo.setPath("ManagerActiontoShowUser");
		} else {
			managerInfoVo.setMessage("亲，您还未登录或不是管理员(^o^)");
			managerInfoVo.setPath("LoginActiontoLoginPage");

		}
		return "toForward";
	}

	public String updateUser() {
		if (checkOn()) {
			try {
				User u = managerServiceImpl.findUserById(managerInfoVo
						.getUserId());
				u.setBirthday(managerInfoVo.getUserBirthday());
				u.setEmail(managerInfoVo.getUserEmail());
				u.setEntranceYear(managerInfoVo.getUserEntranceYear());
				u.setMajor(managerInfoVo.getUserMajor());
				u.setNation(managerInfoVo.getNewsName());
				u.setPassWord(managerInfoVo.getUserPassword());
				u.setPermission(managerInfoVo.getUserPermission1());
				u.setQq(managerInfoVo.getUserQq());
				u.setSex(managerInfoVo.getUserSex());
				u.setState(managerInfoVo.getUserState());
				u.setTel(managerInfoVo.getUserTel());
				u.setTruename(managerInfoVo.getUserTruename());
				managerServiceImpl.changeUser(u);

				managerInfoVo.setMessage("更新用户成功");
			} catch (Exception e) {
				managerInfoVo.setMessage("更新用户失败");
				e.printStackTrace();
			}
			managerInfoVo.setPath("ManagerActiontoShowUser");
		} else {
			managerInfoVo.setMessage("亲，您还未登录或不是管理员(^o^)");
			managerInfoVo.setPath("LoginActiontoLoginPage");

		}
		return "toForward";
	}

	/********************* 新闻管理 ******************************/
	public String toWriteNews() {
		if (checkOn()) {
			try {
				categoryList = managerServiceImpl.findCategory();
				return "toWriteNews";
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			managerInfoVo.setMessage("亲，您还未登录或不是管理员(^o^)");
			managerInfoVo.setPath("LoginActiontoLoginPage");

		}
		return "toForward";
	}

	public String writeNews() {
		if (checkOn()) {
			try {

				News news = new News();
				Category c = managerServiceImpl.findCategoryById(managerInfoVo
						.getCategoryId());
				news.setContent(this.newsContent);
				news.setName(managerInfoVo.getNewsName());
				news.setDate(new Date());
				news.setCategory(c);
				managerServiceImpl.addNews(news);
				managerInfoVo.setMessage("新闻发表成功");
			} catch (Exception e) {
				managerInfoVo.setMessage("新闻发表失败");
				e.printStackTrace();
			}
			managerInfoVo.setPath("ManagerActiontoNewsList");
		} else {
			managerInfoVo.setMessage("亲，您还未登录或不是管理员(^o^)");
			managerInfoVo.setPath("LoginActiontoLoginPage");

		}
		return "toForward";

	}

	public String toNewsList() {
		if (checkOn()) {
			try {
				Pager np = new Pager(managerInfoVo.getNewsPage(),
						managerServiceImpl.newsCount(), managerInfoVo
								.getNewsPageNum());
				managerInfoVo.setNp(np);
				newsList = managerServiceImpl.findAllNews(np);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "toNewsList";
		} else {
			managerInfoVo.setMessage("亲，您还未登录或不是管理员(^o^)");
			managerInfoVo.setPath("LoginActiontoLoginPage");

		}
		return "toForward";
	}

	public String deleteNews() {
		if (checkOn()) {
			try {
				managerServiceImpl.deleteNewsById(managerInfoVo.getNewsId());
				managerInfoVo.setMessage("新闻删除成功");
			} catch (Exception e) {
				managerInfoVo.setMessage("新闻删除失败");
				e.printStackTrace();
			}
			managerInfoVo.setPath("ManagerActiontoNewsList");
		} else {
			managerInfoVo.setMessage("亲，您还未登录或不是管理员(^o^)");
			managerInfoVo.setPath("LoginActiontoLoginPage");

		}
		return "toForward";

	}

	/******************** 帖子管理 ************************/
	public String toShowTopicList() {
		if (checkOn()) {
			try {
				Pager p = new Pager(managerInfoVo.getTopicPage(),
						managerServiceImpl.topicCount(), managerInfoVo
								.getTopicPageNum());
				managerInfoVo.setTp(p);
				topicList = managerServiceImpl.findTopic(p);
				topicList.addAll(0, managerServiceImpl.getTopTopic());
			} catch (Exception e) {
				e.printStackTrace();
			}

			return "toShowTopicList";
		} else {
			managerInfoVo.setMessage("亲，您还未登录或不是管理员(^o^)");
			managerInfoVo.setPath("LoginActiontoLoginPage");

		}
		return "toForward";
	}

	public String deleteTopic() {
		if (checkOn()) {
			try {
				managerServiceImpl.delectTopicById(managerInfoVo.getTopicid());
				managerInfoVo.setMessage("删除帖子成功");
			} catch (Exception e) {
				managerInfoVo.setMessage("删除帖子失败");
				e.printStackTrace();
			}
			managerInfoVo.setPath("ManagerActiontoShowTopicList");
		} else {
			managerInfoVo.setMessage("亲，您还未登录或不是管理员(^o^)");
			managerInfoVo.setPath("LoginActiontoLoginPage");

		}
		return "toForward";
	}

	public String updateTopic() {
		if (checkOn()) {
			String s = "置顶";
			String f = "取消置顶";
			String m = null;
			try {

				Topic t = managerServiceImpl.findTopicById(managerInfoVo
						.getTopicid());

				t.setTop(managerInfoVo.getTopicTop());
				if (managerInfoVo.getTopicTop().equals("1")) {
					m = s + "成功";
				} else {
					m = f + "成功";
				}
				managerServiceImpl.updateTopic(t);

			} catch (Exception e) {
				if (managerInfoVo.getTopicTop().equals("1")) {
					m = s + "失败";
				} else {
					m = f + "失败";
				}
				e.printStackTrace();
			}
			managerInfoVo.setMessage(m);
			managerInfoVo.setPath("ManagerActiontoShowTopicList");
		} else {
			managerInfoVo.setMessage("亲，您还未登录或不是管理员(^o^)");
			managerInfoVo.setPath("LoginActiontoLoginPage");

		}
		return "toForward";
	}

	public String toShowCommentList() {
		if (checkOn()) {
			try {
				Pager cp = new Pager(managerInfoVo.getCommentPage(),
						managerServiceImpl.commentCount(), managerInfoVo
								.getCommentPageNum());
				managerInfoVo.setCp(cp);
				setCommentList(managerServiceImpl.findComment(cp));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "toShowCommentList";
		} else {
			managerInfoVo.setMessage("亲，您还未登录或不是管理员(^o^)");
			managerInfoVo.setPath("LoginActiontoLoginPage");

		}
		return "toForward";
	}

	public String deleteComment() {
		if (checkOn()) {
			try {

				managerServiceImpl.deleteComment(managerInfoVo.getCommentId());
				managerInfoVo.setMessage("删除回复成功");
			} catch (Exception e) {
				managerInfoVo.setMessage("删除回复失败");
				e.printStackTrace();
			}
			managerInfoVo.setPath("ManagerActiontoShowCommentList");
		} else {
			managerInfoVo.setMessage("亲，您还未登录或不是管理员(^o^)");
			managerInfoVo.setPath("LoginActiontoLoginPage");

		}
		return "toForward";
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	public ManagerInfoVo getManagerInfoVo() {
		return managerInfoVo;
	}

	public void setManagerInfoVo(ManagerInfoVo managerInfoVo) {
		this.managerInfoVo = managerInfoVo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ManagerServiceImpl getManagerServiceImpl() {
		return managerServiceImpl;
	}

	@Resource(name = "managerServiceImpl")
	public void setManagerServiceImpl(ManagerServiceImpl managerServiceImpl) {
		this.managerServiceImpl = managerServiceImpl;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public ManagerInfoVo getModel() {
		return managerInfoVo;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public String toReportTopic(){
		
		this.topicList = managerServiceImpl.getReportTopic();
	
		return "toReportTopic";
	}

}
