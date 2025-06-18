package com.wldst.ruder.util;

import com.wldst.ruder.api.Result;

public class WrappedResult extends Result<Object>{
	private PageObject page;
	private Object data;
	public static WrappedResult wrap(boolean successful, Object bean, PageObject page, String string) {
		WrappedResult  retdata = new  WrappedResult();
		retdata.setData(bean);
		retdata.setPage(page);
		retdata.setMsg(string);
		retdata.setStatus(successful);
		return retdata;
	}
	public static WrappedResult wrap(boolean successful, Object bean,String string) {
		WrappedResult  retdata = new  WrappedResult();
		retdata.setData(bean);
		retdata.setMsg(string);
		retdata.setStatus(successful);
		return retdata;
	}

	public PageObject getPage() {
		return page;
	}
	public void setPage(PageObject page) {
		this.page = page;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}

	
}
