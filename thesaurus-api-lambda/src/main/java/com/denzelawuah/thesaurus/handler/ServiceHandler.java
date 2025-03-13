package com.denzelawuah.thesaurus.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.denzelawuah.thesaurus.favouriteWords.FavouriteWord;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



public class ServiceHandler implements RequestHandler<FavouriteWord, Response> {

	// JSON Parser
	Gson gson = new GsonBuilder().setPrettyPrinting().create();

	// @Autowired
	// private FavouriteWordsRepository repository;
	@Override
	public Response handleRequest(FavouriteWord request, Context context) {

		//Instantiate the DynamoDB client/mapper
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.defaultClient();
		DynamoDBMapper mapper = new DynamoDBMapper(client);
	
		Response theResponse = new Response();
		
		// Logging
		LambdaLogger logger = context.getLogger();

		// Handling the Request
		switch (request.getHttpMethod()) {

		// Handle GET Requests
		case "GET":
			List<FavouriteWord> allFavouriteWords = mapper.scan(FavouriteWord.class,
					new DynamoDBScanExpression());
			theResponse.setStatus("200 OK");
			theResponse.setError(null);
			theResponse.setFavouriteWords(allFavouriteWords);

			// logger.log("Response request in get Switch: " + gson.toJson(response));

			break;

			
		// Handle POST Requests
		case "POST":
			mapper.save(request);
			theResponse.setStatus("201 Created");
			theResponse.setError(null);
			List<FavouriteWord> addWordResponse = new ArrayList<FavouriteWord>();
			addWordResponse.add(request);
			theResponse.setFavouriteWords(addWordResponse);
			break;

			
			
		//Handle DELETE Request
		case "DELETE":
			FavouriteWord wordToDelete = mapper.load(FavouriteWord.class, request.getId());
			mapper.delete(wordToDelete);
			theResponse.setStatus("200 OK - The word was successfully deleted");
			theResponse.setError(null);
			List<FavouriteWord> deleteWordResponse = new ArrayList<FavouriteWord>();
			deleteWordResponse.add(wordToDelete);
			theResponse.setFavouriteWords(deleteWordResponse);
			break;

		default:
			theResponse.setStatus("404 - NOT FOUND");
			theResponse.setError("Resource NOT FOUND");
			theResponse.setFavouriteWords(null);
			break;

		}

		// log execution details
		logger.log("ENVIRONMENT VARIABLES: " + gson.toJson(System.getenv()));
		logger.log("CONTEXT: " + gson.toJson(context));
		// process request
		logger.log("request: " + gson.toJson(request));
		logger.log("request_Fav_Word_Object: " + gson.toJson(request));
		logger.log("request TYPE: " + request.getClass());

		return theResponse;
	}
}