package com.github.ravenlab.litemap;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.github.ravenlab.litemap.exception.MissingPropertyException;
import com.github.ravenlab.litemap.pool.Pool;
import com.github.ravenlab.litemap.pool.PoolFactory;
import com.github.ravenlab.litemap.pool.PoolType;

public class Maker {
	
	private static final PoolFactory factory = new PoolFactory();
	
	private Path location;
	private PoolType type;
	
	protected Maker() {
		this.type = PoolType.HIKARI;
	}
	
	public Maker location(String name) {
		return this.location(Paths.get(name));
	}
	
	public Maker location(File file) {
		return this.location(file.toPath());
	}
	
	public Maker location(Path path) {
		this.location = path;
		return this;
	}
	
	public Database make() throws MissingPropertyException {
		Pool<?> pool = factory.constructPool(this.type, this.location);
		return new Database(pool);
	}
	
}