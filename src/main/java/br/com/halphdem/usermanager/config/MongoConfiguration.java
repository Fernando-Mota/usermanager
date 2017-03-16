package br.com.halphdem.usermanager.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

public class MongoConfiguration extends AbstractMongoConfiguration {
	
	@Override
	protected String getDatabaseName() {
		return "usermanager";
	}

	@Override
	public Mongo mongo() throws Exception {
		List<ServerAddress> seeds = new ArrayList<ServerAddress>();
		seeds.add(new ServerAddress("localhost"));
		List<MongoCredential> credentials = new ArrayList<MongoCredential>();
		MongoCredential mongoCredential = MongoCredential.createCredential("halph", getDatabaseName(), "1234".toCharArray());
		credentials.add(mongoCredential);
		return new MongoClient(seeds, credentials);
	}

	@Override
	public String getMappingBasePackage() {
		return "br.com.halphdem.usermanager.model";
	}
	
	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(mongo(), getDatabaseName());
	}
}