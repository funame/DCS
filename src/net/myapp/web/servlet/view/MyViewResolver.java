package net.myapp.web.servlet.view;

import javax.servlet.http.HttpServletRequest;

import java.util.Locale;

import net.myapp.common.logging.impl.Log;
import net.myapp.common.web.holders.RequestHelper;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class MyViewResolver extends InternalResourceViewResolver  {
	  private String defaultViewParent = "view/default/jsp/";
	  private String mobileViewParent = "mobile/jsp/";
	  private String ajaxContentPath = "view/ajax/";
	  private String defaultViewTemplate = "main";
	  private String mobileViewTemplate = "main";
	  
	@Override
	public View resolveViewName(String viewName, Locale locale) throws Exception {
		// TODO Auto-generated method stub
		
		 if ((!viewName.startsWith("redirect:")) && (!viewName.startsWith("forward:")))
		    {
		      String gppViewParent = this.defaultViewParent;
		     /* if (RequestHelper.isMobileRequest()) {
		        gppViewParent = this.mobileViewParent;
		      }*/
		      
		      if (RequestHelper.isAJAXRequest())
		      {
		        viewName = gppViewParent + this.ajaxContentPath + viewName;
		        Log.debug("ajax view name : "+viewName);
		      }
		      else
		      {System.out.println("main"+viewName);
		        RequestHelper.setAttribute("partial", viewName);
		        Log.debug("view partial  name"+viewName);
		        viewName = gppViewParent + this.defaultViewTemplate;
		
		      }
		      //LoggingLayer.debug("MVC.ViewNameAfter " + viewName);
		      
		      //ViewStateHelper.loadCurrentViewStateForRender();
		    }
		 
		  
		    return super.resolveViewName(viewName, locale);
		
	}
	  
/*	  @Override
		 protected AbstractUrlBasedView buildView(String viewName) throws Exception {
		 	        HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		 	        String viewFile =request.getRealPath(this.getPrefix()+viewName+this.getSuffix());
		 	        File reqFile=new File(viewFile);
		 	        System.out.println(reqFile.getAbsolutePath()+":extists:"+reqFile.exists());
		 	        if(!reqFile.exists()){
		 	            viewName="default";
		 	        }
			       
			        String jspMain="view/main";
		        
			        String jsp="view/"+viewName;
			        System.out.println("view name : "+viewName);
			        System.out.println("view path : "+jsp+".jsp");
			        
			        
			        RequestHelper.setAttribute("fff", viewName);
			        
			        
		 	        InternalResourceView view = (InternalResourceView) super.buildView(jspMain);
		 	        view.setAlwaysInclude(false);
		 	        
		 	        
		 	        return view;
		 	    }*/

}
