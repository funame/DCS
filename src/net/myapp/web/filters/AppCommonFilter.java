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

public class AppCommonFilter implements Filter  {
		   public void  init(FilterConfig config) 
		                         throws ServletException{
				   }

		   private void doBeforeProcessing(HttpServletRequest request, HttpServletResponse response)
		   {
		   

		     RequestHolder.set(request);
		     ResponseHolder.set(response);
		    }
		   
		   
		   public void  doFilter(ServletRequest request, 
		                 ServletResponse response,
		                 FilterChain chain) 
		                 throws java.io.IOException, ServletException {
			   try {
		            /*
		            * This code puts the value "userName" to the Mapped Diagnostic
		            * context. Since MDc is a static class, we can directly access it
		            * with out creating a new object from it. Here, instead of hard
		            * coding the user name, the value can be retrieved from a HTTP
		            * Request object.
		            */
				    HttpServletRequest rq=(HttpServletRequest) request;
				    HttpSession session=rq.getSession();
				   
		            MDC.put("sessionInfo", session.getId()+"!"+session.getCreationTime());

		            doBeforeProcessing((HttpServletRequest)request, (HttpServletResponse)response);
				      // Pass request back down the filter chain
				      chain.doFilter(request,response);
				      doAfterProcessing((HttpServletRequest)request, (HttpServletResponse)response);

		        } finally {
		            MDC.remove("sessionInfo");
		        }
			
		   }
		   
		   private void doAfterProcessing(HttpServletRequest request, HttpServletResponse response)
		   {
		    /* DataSessionHolder.closeCurrentThreadConnections();*/
		     
		    /* ViewErrorHolder.remove();
		     ViewMessagesHolder.remove();
		    */ 
			 RequestHolder.remove();
		     ResponseHolder.remove();
		     //WebSessionHolder.remove();
		   }
		   public void destroy( ){ }
}
