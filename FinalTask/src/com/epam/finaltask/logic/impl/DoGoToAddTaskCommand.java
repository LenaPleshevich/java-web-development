package com.epam.finaltask.logic.impl;

import com.epam.finaltask.controller.JspPageName;
import com.epam.finaltask.controller.RequestParameterName;
import com.epam.finaltask.logic.ICommand;
import com.epam.finaltask.logic.exception.CommandException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 	This class executes a go to page to add task
 */
public final class DoGoToAddTaskCommand implements ICommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		String page = JspPageName.ADD_TASK_PAGE;
		HttpSession session = request.getSession(true);	
		String url = generateURL(request);
		session.setAttribute(RequestParameterName.URL, url);
		request.setAttribute(RequestParameterName.PAGE_NUMBER,request.getParameter(RequestParameterName.PAGE_NUMBER));
		session.setAttribute(RequestParameterName.ID_COURSE,request.getParameter(RequestParameterName.ID_COURSE));
		return page;
	}
	
	private String generateURL(HttpServletRequest request){
		StringBuffer url = request.getRequestURL().append("?");
		url.append(RequestParameterName.COMMAND).append("=").append(request.getParameter(RequestParameterName.COMMAND));
		return url.toString();
	}
}
