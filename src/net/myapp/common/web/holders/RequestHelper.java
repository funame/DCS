package net.myapp.common.web.holders;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.cert.X509Certificate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*import net.sinam.common.app.AppModuleResolver;
import net.sinam.common.utils.StringUtils;
import net.sinam.common.web.holders.RequestHolder;
import net.sinam.common.web.holders.ResponseHolder;
import net.sinam.common.web.holders.ServletContextHolder;
import net.sinam.common.web.holders.WURFLManagerHolder;
import net.sourceforge.wurfl.core.Device;
import net.sourceforge.wurfl.core.WURFLManager;*/

public class RequestHelper
{
  public static String getParam(String key)
  {
    HttpServletRequest request = RequestHolder.get();
    return request.getParameter(key);
  }
  
  public static Object getAttribute(String key)
  {
    HttpServletRequest request = RequestHolder.get();
    if (request == null) {
      return null;
    }
    return request.getAttribute(key);
  }
  
  public static void setAttribute(String key, Object value)
  {
    HttpServletRequest request = RequestHolder.get();
    request.setAttribute(key, value);
  }
  
  public static String getServerURL()
  {
    HttpServletRequest request = RequestHolder.get();
    String requestURL = request.getRequestURL().toString();
    return requestURL.substring(0, requestURL.indexOf(request.getContextPath()));
  }
  
  public static String getContextURL()
  {
    HttpServletRequest request = RequestHolder.get();
    String requestURL = request.getRequestURL().toString();
    return requestURL.substring(0, requestURL.indexOf(request.getServletPath()));
  }
  
  public static String getDispatcherURL()
  {
    HttpServletRequest request = RequestHolder.get();
    String servletPath = request.getServletPath();
    String requestURL = request.getRequestURL().toString();
    return requestURL.substring(0, requestURL.indexOf(servletPath) + servletPath.length());
  }
  
  public static String generatePreSessionURL(String preSessionHashKey)
  {
    return getContextURL() + "/Dispatcher?preSessionHashKey=" + preSessionHashKey;
  }
  
  public static <T> void setAttribute(Class<T> key, T value)
  {
    HttpServletRequest request = RequestHolder.get();
    request.setAttribute(key.toString(), value);
  }
  /*
  public static <T> T getAttribute(Class<T> key)
  {
    HttpServletRequest request = RequestHolder.get();
    if (request == null) {
      return null;
    }
    return request.getAttribute(key.toString());
  }
  
  public static String getRequestID()
  {
    String requestID = (String)getAttribute("requestID");
    if (StringUtils.isNullOrEmpty(requestID)) {
      return "";
    }
    return requestID;
  }
  
  public static String getRequestedModuleName()
  {
    HttpServletRequest request = RequestHolder.get();
    
    String requestedModuleName = AppModuleResolver.resolveCurrentModule(request.getServletPath(), request.getParameter("commandName"));
    if (StringUtils.isNullOrEmpty(requestedModuleName)) {
      requestedModuleName = ServletContextHolder.getServletContextParam("CFiApplicationCode");
    }
    if (StringUtils.isNullOrEmpty(requestedModuleName)) {
      requestedModuleName = ServletContextHolder.getServletContextParam("ApplicationCode");
    }
    return requestedModuleName;
  }
  
  public static boolean isMobileRequest()
  {
    Boolean mobileRequest = (Boolean)getAttribute("mobileRequest");
    if (mobileRequest == null)
    {
      try
      {
        WURFLManager wurflManager = WURFLManagerHolder.get();
        if (wurflManager == null) {
          mobileRequest = Boolean.valueOf(false);
        }
        Device device = wurflManager.getDeviceForRequest(RequestHolder.get());
        mobileRequest = Boolean.valueOf(device.getCapabilityAsBool("is_wireless_device"));
      }
      catch (Throwable e)
      {
        mobileRequest = Boolean.valueOf(false);
      }
      setAttribute("mobileRequest", mobileRequest);
    }
    return mobileRequest.booleanValue();
  }
  */
  public static boolean isAJAXRequest()
  {
    String xRequestedWith = RequestHolder.get().getHeader("X-Requested-With");
    return "XMLHttpRequest".equals(xRequestedWith);
  }
  
  public static void setWSRequest(boolean wsRequest)
  {
    setAttribute("wsRequest", Boolean.valueOf(wsRequest));
  }
  
  public static boolean isWSRequest()
  {
    Boolean wsRequest = (Boolean)getAttribute("wsRequest");
    if (wsRequest == null) {
      return false;
    }
    return wsRequest.booleanValue();
  }
  
  public static boolean isPostRequest()
  {
    HttpServletRequest request = RequestHolder.get();
    if (request == null) {
      return false;
    }
    return request.getMethod().toLowerCase().equals("post");
  }
  
  public static boolean isGetRequest()
  {
    HttpServletRequest request = RequestHolder.get();
    if (request == null) {
      return false;
    }
    return request.getMethod().toLowerCase().equals("get");
  }
  
  public static String getApplicationPath()
  {
    return RequestHolder.get().getContextPath();
  }
  
/*  public static void forwardTo(String internalPath)
    throws ServletException, IOException
  {
    HttpServletRequest request = RequestHolder.get();
    request.getRequestDispatcher(internalPath).forward(request, ResponseHolder.get());
  }
  
  public static void redirectTo(String redirectURL)
    throws ServletException, IOException
  {
    ResponseHolder.get().sendRedirect(redirectURL);
  }
  
  public static void ajaxRedirectTo(String redirectURL)
    throws ServletException, IOException
  {
    ResponseHolder.get().getWriter().append("<script type=\"text/javascript\">window.location.href=\"" + redirectURL + "\"</script>");
  }*/
  
  public static X509Certificate getSSLClientCertificate()
  {
    X509Certificate[] clientCertificateArray = (X509Certificate[])getAttribute("javax.servlet.request.X509Certificate");
    if ((clientCertificateArray == null) || (clientCertificateArray.length == 0)) {
      return null;
    }
    return clientCertificateArray[0];
  }
}
