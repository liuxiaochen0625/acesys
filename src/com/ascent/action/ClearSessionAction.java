package com.ascent.action;
import com.opensymphony.xwork2.ActionContext;
@SuppressWarnings("serial")
public class ClearSessionAction extends BaseAction {
	public String execute()throws Exception{
		ActionContext.getContext().getSession().clear();
		return SUCCESS;
	}
}
