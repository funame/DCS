package net.myapp.common.logging.impl;


import org.apache.log4j.Logger;

public class Log{
	private static final Logger logger = Logger.getLogger("");
	

public  static boolean isDebugEnabled() {
	// TODO Auto-generated method stub
	return false;
}

public static void info(String paramString) {
	// TODO Auto-generated method stub
	logger.info(paramString);
}
public static void debug(String paramString) {
	// TODO Auto-generated method stub
	logger.debug(paramString);
}

public static void warn(String paramString) {
	// TODO Auto-generated method stub
	logger.warn(paramString);
}

public static void error(String paramString) {
	// TODO Auto-generated method stub
	logger.error(paramString);
}

public static void error(String paramString, Throwable paramThrowable) {
	// TODO Auto-generated method stub
	logger.error(paramString,paramThrowable);
} 
	


}
