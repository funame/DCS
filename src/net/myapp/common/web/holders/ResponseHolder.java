package net.myapp.common.web.holders;



import javax.servlet.http.HttpServletResponse;

public class ResponseHolder
{
  private static final ThreadLocal<HttpServletResponse> responseHolder = new ThreadLocal();
  
  public static HttpServletResponse get()
  {
    return (HttpServletResponse)responseHolder.get();
  }
  
  public static void set(HttpServletResponse response)
  {
    responseHolder.set(response);
  }
  
  public static void remove()
  {
    responseHolder.remove();
  }
}

