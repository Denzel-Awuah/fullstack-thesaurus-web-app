package com.denzelawuah.thesaurus.handler;

import java.util.List;

import com.denzelawuah.thesaurus.favouriteWords.FavouriteWord;


// Request Class: Handles function traffic
public class Request {


	private List<FavouriteWord> favouriteWord;

	public Request() {

	}

	public Request(List<FavouriteWord> favouriteWord) {
		super();
		this.favouriteWord = favouriteWord;
	}

	public List<FavouriteWord> getFavouriteWord() {
		return favouriteWord;
	}

	public void setFavouriteWord(List<FavouriteWord> favouriteWord) {
		this.favouriteWord = favouriteWord;
	}

	@Override
	public String toString() {
		return "Request [favouriteWord=" + favouriteWord + "]";
	}

}
