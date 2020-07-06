package com.github.ravenlab.litemap.pool;

import java.sql.Connection;
import java.util.Optional;

public abstract class  Pool<T> {

	private T pool;
	
	public Pool(T pool) {
		this.pool = pool;
	}
	
	public abstract Optional<Connection> getConnection();

	public T get() {
		return this.pool;
	}
}