dataSource {
    pooled = true
    driverClassName = "org.postgresql.Driver"
    dialect = org.hibernate.dialect.PostgreSQLDialect
    username = "webapp"
    password = "webapp"
    properties {
        minEvictableIdleTimeMillis=1800000
        timeBetweenEvictionRunsMillis=1800000
        numTestsPerEvictionRun=3
        testOnBorrow=true
        testWhileIdle=true
        testOnReturn=true
        validationQuery="SELECT 1"
    }
}

hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
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
