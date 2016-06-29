package net.myapp.web.filters;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.MDC;
import org.springframework.http.HttpRequest;

import net.myapp.common.web.holders.RequestHolder;
import net.myapp.common.web.holders.ResponseHolder;
import net.myapp.common.web.holders.WebAuthHelper;

public class AuthFilter implements Filter {
	public void init(FilterConfig config) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws java.io.IOException, ServletException {
		
		if (!WebAuthHelper.isUserAuthenticated()) {
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			httpResponse.sendRedirect("/DSC/panel/login");
			return;
		}
		chain.doFilter(request,response);
	
	}

	public void destroy() {
	}
}
