package com.campus.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;

@Configuration
public class MongoConfig {
	@Value("${spring.data.mongodb.database}")
	String db;
	@Bean
	public GridFSBucket getBucket(MongoClient mongoClient) {
		MongoDatabase mongoDatabase=mongoClient.getDatabase(db);
		GridFSBucket bucket=GridFSBuckets.create(mongoDatabase);
		return bucket;
	}
}
