dataSource {
	pooled = true
}

/*
Database driver org.hsqldb.jdbcDriver 
for HSQLDB not found. Since Grails 2.0 H2 is now the default database. 
You need to either add the 'org.h2.Driver' class as your database driver and change the connect URL format 
(for example 'jdbc:h2:mem:devDb') in DataSource.groovy or add HSQLDB as a dependency of your application.
*/

hibernate {
	cache.use_second_level_cache = true
	cache.use_query_cache = true
	cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}
// environment specific settings
environments {
	development {
		dataSource {
			driverClassName = "com.mysql.jdbc.Driver"
			username = "root"
			password = "root"
			dbCreate = "update" // one of 'create', 'create-drop','update', 'none'
			url = "jdbc:mysql://localhost:3306/cgmbr"
		}
	}
	
	test {
		dataSource {
			dbCreate = "update"
			url = "jdbc:h2:mem:testDb;MVCC=TRUE"
		}
	}
	
	production {
		dataSource {
			username = "cgmbruser"
			password = "m4n4g3r"
			dbCreate = "update"
			url = "jdbc:mysql://localhost:3306/cgmbr"
			pooled = true
			properties {
				maxActive = -1
				minEvictableIdleTimeMillis=1800000
				timeBetweenEvictionRunsMillis=1800000
				numTestsPerEvictionRun=3
				testOnBorrow=true
				testWhileIdle=true
				testOnReturn=true
				validationQuery="SELECT 1"
			}
		}
	}
}
