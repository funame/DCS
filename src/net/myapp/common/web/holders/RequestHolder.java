package net.myapp.common.web.holders;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
/*import net.sinam.common.utils.StringUtils;
import net.sinam.common.web.helpers.RequestHelper;*/

public class RequestHolder
{
  private static final ThreadLocal<HttpServletRequest> requestHolder = new ThreadLocal();
  private static final ThreadLocal<Map<String, Cookie>> cookieMapHolder = new ThreadLocal();
  
  public static HttpServletRequest get()
  {
    return (HttpServletRequest)requestHolder.get();
  }
  
  public static Cookie findCookie(String name)
  {
    Map<String, Cookie> cookieMap = (Map)cookieMapHolder.get();
    if ((cookieMap == null) || (cookieMap.isEmpty())) {
      return null;
    }
    return (Cookie)cookieMap.get(name);
  }
  
  public static boolean getUnlimitedSessionCookieValue()
  {
    Cookie unlimitedSessionCookie = findCookie("unlimitedSession");
    if (unlimitedSessionCookie == null) {
      return false;
    }
    return Boolean.parseBoolean(unlimitedSessionCookie.getValue());
  }
  
  public static String getPreSessionHashKeyCookieValue()
  {
    Cookie preSessionHashKeyCookie = findCookie("preSessionHashKey");
    if (preSessionHashKeyCookie == null) {
      return null;
    }
    return preSessionHashKeyCookie.getValue();
  }
  
  public static void set(HttpServletRequest request)
  {
    if (request == null)
    {
      requestHolder.remove();
      cookieMapHolder.remove();
    }
    else
    {
      String threadID = Long.toString(Thread.currentThread().getId());
      request.setAttribute("requestID", System.currentTimeMillis() + "_" + threadID);
      request.setAttribute("userRequestedScheme", request.getScheme());
      request.setAttribute("userRequestedURI", request.getRequestURI());
      request.setAttribute("userRequestedURL", request.getRequestURL());
      
      String queryString = request.getQueryString();
      if ((queryString!=null) && (!queryString.equals(""))) {
        queryString = null;
      }
      request.setAttribute("userRequestedURIWithQueryString", request.getRequestURI() + (queryString == null ? "" : new StringBuilder().append("?").append(queryString).toString()));
      request.setAttribute("userRequestedURLWithQueryString", request.getRequestURL() + (queryString == null ? "" : new StringBuilder().append("?").append(queryString).toString()));
      requestHolder.set(request);
      
      request.setAttribute("contextURL", RequestHelper.getContextURL());
      request.setAttribute("dispatcherURL", RequestHelper.getDispatcherURL());
      
      Cookie[] receivedCookies = request.getCookies();
      if (receivedCookies != null)
      {
        Map<String, Cookie> cookieMap = new HashMap();
        for (Cookie cookie : receivedCookies) {
          cookieMap.put(cookie.getName(), cookie);
        }
        if (!cookieMap.isEmpty()) {
          cookieMapHolder.set(cookieMap);
        }
      }
    }
  }
  
  public static void remove()
  {
    requestHolder.remove();
    cookieMapHolder.remove();
  }
}
