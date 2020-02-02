package com.project.config

import io.micronaut.configuration.jdbc.tomcat.DatasourceConfiguration
import io.micronaut.configuration.jdbc.tomcat.DatasourceFactory
import io.micronaut.context.ApplicationContext
import io.micronaut.context.annotation.*
import io.micronaut.jdbc.DataSourceResolver
import java.util.concurrent.ConcurrentHashMap
import javax.annotation.PreDestroy
import javax.sql.DataSource

@Factory
@Replaces(DatasourceFactory::class)
@Requires(env = ["db-test"])
class SharedTestDatasourceFactory(dataSourceResolver: DataSourceResolver?) : DatasourceFactory(dataSourceResolver) {
    @Context
    @EachBean(DatasourceConfiguration::class)
    @Requires(beans = arrayOf(TestPostgress::class))
    override fun dataSource(configuration: DatasourceConfiguration):DataSource{
        var managedPostgress=testPostgres()
        var dataSource = org.apache.tomcat.jdbc.pool.DataSource()
        dataSource.url=managedPostgress.psql.jdbcUrl
        dataSource.username = "test"
        dataSource.password = "test"
        dataSource.driverClassName = "org.postgresql.Driver"
        return dataSource
    }

    @Bean
    fun testPostgres():TestPostgress{
        var managedPostgress=TestPostgress()
        managedPostgress.psql.start()
        return managedPostgress
    }
}
