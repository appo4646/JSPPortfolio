package com.ds.vo;

public class SearchDTO {
	private String searchType;
	private String searchValue;
	
	public SearchDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SearchDTO(String searchType, String searchValue) {
		super();
		this.searchType = searchType;
		this.searchValue = searchValue;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	@Override
	public String toString() {
		return "SearchDTO [searchType=" + searchType + ", searchValue=" + searchValue + "]";
	}
	
}
