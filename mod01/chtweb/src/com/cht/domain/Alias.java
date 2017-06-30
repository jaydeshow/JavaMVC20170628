package com.cht.domain;

public class Alias {
	private int aliasid;
	private String alias;
	public int getAliasid() {
		return aliasid;
	}
	public void setAliasid(int aliasid) {
		this.aliasid = aliasid;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	//Overriding toString method
	public String toString(){
		return alias;
	}
}
