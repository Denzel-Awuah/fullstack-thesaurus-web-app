package com.denzelawuah.thesaurus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

@Configuration
public class DynamoDBConfiguration {

	@Bean
	public DynamoDBMapper dynamoDBMapper() {
		return new DynamoDBMapper(buildAmazonDynamoDB());
	}

	private AmazonDynamoDB buildAmazonDynamoDB() {
		return AmazonDynamoDBClientBuilder.standard()
				.withEndpointConfiguration(
						new AwsClientBuilder.EndpointConfiguration(
						  "dynamodb.ca-central-1.amazonaws.com",
						  "ca-central-1"))
				.withCredentials(
						new AWSStaticCredentialsProvider(
						 new BasicAWSCredentials(
						  "AKIAX5LAJB23IEVPXGOF",
						  "cI4C2yKGcCAgsPAHvsAtu5IKpaIxbeQTRiAZxtF5")))
				.build();
	}
}
