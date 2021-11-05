package com.denzelawuah.thesaurus.handler;

import java.util.List;

import com.denzelawuah.thesaurus.favouriteWords.FavouriteWord;

public class Response {

	private String status;
	private String error;
	private List<FavouriteWord> favouriteWords;
	
	public Response () {
		
	}
	
	public Response(String status, String error, List<FavouriteWord> favouriteWords) {
		super();
		this.status = status;
		this.error = error;
		this.favouriteWords = favouriteWords;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public List<FavouriteWord> getFavouriteWords() {
		return favouriteWords;
	}
	public void setFavouriteWords(List<FavouriteWord> favouriteWords) {
		this.favouriteWords = favouriteWords;
	}

	@Override
	public String toString() {
		return "Response [status=" + status + ", error=" + error + ", favouriteWords=" + favouriteWords + "]";
	}
	
	
	
	
	
}
