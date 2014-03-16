dataSource {
    pooled = true
	jmxExport = true
    driverClassName = "org.postgresql.Driver"
    dialect = org.hibernate.dialect.PostgreSQLDialect
    username = "webapp"
    password = "webapp"
    properties {
        jmxEnabled = true
        initialSize = 5
        maxActive = 50
        minIdle = 5
        maxIdle = 25
        maxWait = 10000
        maxAge = 10 * 60000
        timeBetweenEvictionRunsMillis = 5000
        minEvictableIdleTimeMillis = 60000
        validationQuery = "SELECT 1"
        validationQueryTimeout = 3
        validationInterval = 15000
        testOnBorrow = true
        testWhileIdle = true
        testOnReturn = false
        jdbcInterceptors = "ConnectionState"
        defaultTransactionIsolation = java.sql.Connection.TRANSACTION_READ_COMMITTED
    }
}

hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
	singleSession = true
}

environments {
    development {
        dataSource {
            dbCreate = "create"
            url = "jdbc:postgresql://localhost/webapp"
        }
    }
    test {
        dataSource {
            dbCreate = "update"
            driverClassName = "org.h2.Driver"
			dialect = org.hibernate.dialect.H2Dialect
            url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
            username = "sa"
			password = ""
        }
    }
    stage {
        dataSource {
            // Supplied by Heroku plugin
        }
    }
    production {
        dataSource {
            // Supplied by Heroku plugin
        }
    }
}
