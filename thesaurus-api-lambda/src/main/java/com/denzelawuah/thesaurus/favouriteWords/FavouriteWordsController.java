//package com.denzelawuah.thesaurus.favouriteWords;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class FavouriteWordsController {
//
//
//	@Autowired
//	private FavouriteWordsRepository repository;
//	
//	
//	@PostMapping("/word")
//	public String addFavouriteWord(@RequestBody FavouriteWord theFavouriteWord) {
//		
//		FavouriteWord addWord = repository.save(theFavouriteWord);
//		
//		return "The word was added to the DynamoDB!";
//	}
//	
//	
//	@GetMapping("/words")
//	public List<FavouriteWord> getAllWords(){
//		return repository.getAllFavouriteWords();
//	}
//	
//}
