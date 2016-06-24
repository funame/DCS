package net.myapp.web.servlet.view;

import java.util.Locale;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import net.myapp.common.logging.impl.Log;
import net.myapp.common.web.holders.RequestHelper;
import net.myapp.common.web.holders.WebAuthHelper;
import net.myapp.dao.model.SecureUserEnum;
import net.myapp.helper.SecureUserUtil;

public class MyViewResolver extends InternalResourceViewResolver {
	private String defaultViewParent = "view/default/";

	private String ajaxContentPath = "view/ajax/";
	private String defaultViewTemplate = "main";
	private String mobileViewTemplate = "main";
	private String mobileViewParent = "mobile/jsp/";
	private String viewName;

	@Override
	public View resolveViewName(String partial, Locale locale) throws Exception {
		// TODO Auto-generated method stub
		viewName = partial;
		if ((!viewName.startsWith("redirect:")) && (!viewName.startsWith("forward:"))) {
			// String gppViewParent = this.defaultViewParent;

			if (RequestHelper.isAJAXRequest()) {
				viewName = this.defaultViewParent + this.ajaxContentPath + partial;
				Log.debug("ajax view name : " + viewName);
			} else {
				if (SecureUserUtil.isAdmin()) {
					viewName = "view/admin/" + this.defaultViewTemplate;
				} else if (SecureUserUtil.isSeller()) {
					viewName = "view/seller/" + this.defaultViewTemplate;
				}
				else {
					viewName = this.defaultViewParent + this.defaultViewTemplate;
				}
				RequestHelper.setAttribute("partial", partial);
				Log.debug("view partial  name : " + partial);

			}
			// LoggingLayer.debug("MVC.ViewNameAfter " + viewName);

			// ViewStateHelper.loadCurrentViewStateForRender();
		}

		return super.resolveViewName(viewName, locale);

	}

	/*
	 * @Override protected AbstractUrlBasedView buildView(String viewName)
	 * throws Exception { HttpServletRequest
	 * request=((ServletRequestAttributes)RequestContextHolder.
	 * currentRequestAttributes()).getRequest(); String viewFile
	 * =request.getRealPath(this.getPrefix()+viewName+this.getSuffix()); File
	 * reqFile=new File(viewFile);
	 * System.out.println(reqFile.getAbsolutePath()+":extists:"+reqFile.exists()
	 * ); if(!reqFile.exists()){ viewName="default"; }
	 * 
	 * String jspMain="view/main";
	 * 
	 * String jsp="view/"+viewName; System.out.println("view name : "+viewName);
	 * System.out.println("view path : "+jsp+".jsp");
	 * 
	 * 
	 * RequestHelper.setAttribute("fff", viewName);
	 * 
	 * 
	 * InternalResourceView view = (InternalResourceView)
	 * super.buildView(jspMain); view.setAlwaysInclude(false);
	 * 
	 * 
	 * return view; }
	 */

}
