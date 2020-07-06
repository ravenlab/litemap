package com.github.ravenlab.litemap;

import com.github.ravenlab.litemap.pool.Pool;

public class Database {

	private Pool<?> pool;
	
	public Database(Pool<?> pool) {
		this.pool = pool;
	}
	
}