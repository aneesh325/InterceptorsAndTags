package com.test.tagHandler;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class AppTagHandler extends TagSupport {

	public int doStartTag(){
		JspWriter out = pageContext.getOut();
		
		try {
			out.print(LocalDateTime.now());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
	
	
}
