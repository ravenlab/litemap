package com.github.ravenlab.litemap.pool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

import com.zaxxer.hikari.HikariDataSource;

public class HikariPool extends Pool<HikariDataSource> {

	public HikariPool(HikariDataSource pool) {
		super(pool);
	}

	@Override
	public Optional<Connection> getConnection() {
		try {
			return Optional.of(this.get().getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
			return Optional.empty();
		}
	}
}