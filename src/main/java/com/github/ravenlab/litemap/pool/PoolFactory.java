package com.github.ravenlab.litemap.pool;

import java.nio.file.Path;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class PoolFactory {

	public Pool<?> constructPool(PoolType type, Path databaseLocation) {
		String connection = this.connectionURL(databaseLocation);
		return hikari(connection);
		
	}
	
	private String connectionURL(Path databaseLocation) {
		Path absolute = databaseLocation;
		return "jdbc:sqlite:" + absolute.toUri();
	}
	
	private Pool<?> hikari(String connection) {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(connection);
		config.setConnectionTestQuery("SELECT 1");
		config.setAutoCommit(true);
		config.setMaximumPoolSize(20);
		HikariDataSource source = new HikariDataSource(config);
		Pool<?> pool = new HikariPool(source);
		return pool;
	}
}