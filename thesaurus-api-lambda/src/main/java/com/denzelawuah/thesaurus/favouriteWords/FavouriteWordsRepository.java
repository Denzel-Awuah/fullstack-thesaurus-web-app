//package com.denzelawuah.thesaurus.favouriteWords;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
//import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
//import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedScanList;
//
//@Repository
//public class FavouriteWordsRepository {
//
//	@Autowired
//	private DynamoDBMapper dynamoDBMapper;
//
//	// Handle POST
//	public FavouriteWord save(FavouriteWord theFavouriteWord) {
//		dynamoDBMapper.save(theFavouriteWord);
//		return theFavouriteWord;
//	}
//
//	//Handle GET word by id
//	public FavouriteWord getFavouriteWordById(String theFavouriteWordId) {
//		return dynamoDBMapper.load(FavouriteWord.class, theFavouriteWordId);
//	}	public FavouriteWord getEmployeeById(String theFavouriteWordId) {
//		return dynamoDBMapper.load(FavouriteWord.class, theFavouriteWordId);
//	}
//	
//	
//	public PaginatedScanList<FavouriteWord> getAllFavouriteWords() {
//		return dynamoDBMapper.scan(FavouriteWord.class, new DynamoDBScanExpression());
//	}
//	
//
//	//Handle DELETE word by id
//	public String deleteFavouriteWordById(String theFavouriteWordId) {
//		FavouriteWord word = dynamoDBMapper.load(FavouriteWord.class, theFavouriteWordId);
//		dynamoDBMapper.delete(word);
//		return "Word was successfully Deleted!";
//	}
//
//}
