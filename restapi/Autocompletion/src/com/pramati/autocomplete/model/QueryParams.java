package com.pramati.autocomplete.model;

import javax.ws.rs.QueryParam;

public class QueryParams {

	@QueryParam("start")
	String start;
	
	@QueryParam("atmost")
	int atmost;

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public int getAtmost() {
		return atmost;
	}

	public void setAtmost(int atmost) {
		this.atmost = atmost;
	}
	
	
}
