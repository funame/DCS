package net.myapp.common.web.holders;

import javax.servlet.http.HttpSession;

import net.myapp.dao.model.SecureUser;

public class WebSessionHelper {
	
	
	 /* public static <T> void set(Class<T> objectClass, Object object)
	  {
	    HttpSession httpSession = RequestHolder.get().getSession();
	    httpSession.setAttribute(objectClass.toString(), object);
	  }
	  
	  public static <T> T get(Class<T> objectClass)
	  {
	    HttpSession httpSession = RequestHolder.get().getSession();
	    T retVal = httpSession.getAttribute(objectClass.toString());
	    return retVal;
	  }*/
	  
	  public static void set(String key, Object object)
	  {
	    HttpSession httpSession = RequestHolder.get().getSession();
	    if (object == null) {
	      httpSession.removeAttribute(key);
	    } else {
	      httpSession.setAttribute(key, object);
	    }
	  }
	  
	  public static void remove(String key)
	  {
	    RequestHolder.get().getSession().removeAttribute(key);
	  }
	  
	  public static Object get(String key)
	  {
	    HttpSession httpSession = RequestHolder.get().getSession();
	    return httpSession.getAttribute(key);
	  }
	  
	  public static boolean isAvailable(String key)
	  {
		  Object value = get(key);
	    return value != null;
	  }
	  
	  public static void clearSessionData()
	  {
	    //HttpSession httpSession = WebSessionHolder.get();
		//  HttpSession httpSession = RequestHolder.get().getSession();
		    
	  /*  DataRepository viewStateRepository = (DataRepository)httpSession.getAttribute("viewStateRepository");
	    if (viewStateRepository != null)
	    {
	      viewStateRepository.removeAll();
	      httpSession.removeAttribute("viewStateRepository");
	    }*/
		  
		if (WebAuthHelper.isUserAuthenticated()){  
		System.out.println("logout : "+SecureUser.class.getSimpleName()+"/"+WebAuthHelper.getAuthenticatedSecureUser().getLogin());
		}
	    //RequestHolder.get().getSession().setAttribute(SecureUser.class.getSimpleName(),null);
		RequestHolder.get().getSession().invalidate();
	  }
	  
	 /* public static synchronized void storeMappedData(String key, Object value)
	  {
	    Map<String, Object> mappedData = (Map)get("sessionStateMappedData");
	    if (mappedData == null)
	    {
	      mappedData = new HashMap();
	      set("sessionStateMappedData", mappedData);
	    }
	    mappedData.put(key, value);
	  }*/
	  
	/*  public static synchronized Object findMappedData(String key)
	  {
	    Map<String, Object> mappedData = (Map)get("sessionStateMappedData");
	    if (mappedData == null)
	    {
	      mappedData = new HashMap();
	      set("sessionStateMappedData", mappedData);
	    }
	    return mappedData.get(key);
	  }*/
	  
	/*  public static synchronized void clearMappedData(String key)
	  {
	    Map<String, Object> mappedData = (Map)get("sessionStateMappedData");
	    if (mappedData != null) {
	      mappedData.clear();
	    }
	  }*/
	}

