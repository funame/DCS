package net.myapp.test.spring.controller;

import org.springframework.ui.ModelMap;

public class Common {
	
	public static  ModelMap modelMap=new ModelMap();
	public static void setAttr(String key,Object obj){
		modelMap.addAttribute(key, obj);
		
	}

}
