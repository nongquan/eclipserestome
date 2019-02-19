package cn.itcast.web.Interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		
		Object object = ActionContext.getContext().getSession().get("user");
		if(object==null){
			return "toLogin";
		}else{return invocation.invoke();}
		
	
	}

}
