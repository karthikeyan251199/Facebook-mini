package com.chainsys.socialmedia.commonutil;

public class ExceptionManager {
	public static String handleExeption(Exception e, String source, String message) {
		LogManager.logException(e,source,message);
		message += "Message: " + e.getMessage();
		String errorPage=HTMLHelper.getHTMLTemplate("ERROR", message);
		return errorPage;
	}
}
