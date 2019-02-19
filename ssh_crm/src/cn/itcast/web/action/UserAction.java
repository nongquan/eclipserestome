 package cn.itcast.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User>{
		private UserService userService;
		private User u = new User();
		
		//×¢²á
		
		public String register() throws Exception {
			
			try {
				userService.register(u);
			} catch (Exception e) {
				e.printStackTrace();
				ActionContext.getContext().put("error", e.getMessage());
				return "register";
			} 
			
			return "toLogin";
		}

		//µÇÂ¼
		public String login() throws Exception{
			/*System.out.println(u.getUsername()+":"+u.getPassword());*/
			User user = userService.getUserByCodepassword(u);
			ActionContext.getContext().getSession().put("user", user);
			
			return "toHome";}

		@Override
		public User getModel() {
			// TODO Auto-generated method stub
			return u;
		}

		public void setUserService(UserService userService) {
			this.userService = userService;
		}
		
}
