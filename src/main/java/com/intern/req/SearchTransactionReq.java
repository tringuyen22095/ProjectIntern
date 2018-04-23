package com.intern.req;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchTransactionReq {

	// region -- Fields --

	@JsonProperty("owner")
	private String owner;
	@JsonProperty("search_string")
	private String searchString;

	// end

	// region -- Get set --

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	// end

	// region -- Methods --

	public SearchTransactionReq() {
		super();
	}

	// end
}