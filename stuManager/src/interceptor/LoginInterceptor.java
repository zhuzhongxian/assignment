package interceptor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import po.Student;

public class LoginInterceptor implements HandlerInterceptor{
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws ServletException, IOException {
		String url=request.getRequestURI();
		if(url.indexOf("/toEditStuScore")>=0) {
			return true;
		}
		HttpSession session =request.getSession();
		Student student=(Student)session.getAttribute("STUDENT_SESSION");
		if(student!=null) {
			return true;
		}
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		return false;
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
}
