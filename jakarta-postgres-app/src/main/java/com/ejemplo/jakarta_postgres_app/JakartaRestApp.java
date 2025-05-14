package com.ejemplo.jakarta_postgres_app;

import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@DataSourceDefinition(
	    name = "java:app/PostgresDS",
	    className = "org.postgresql.ds.PGSimpleDataSource",
	    user = "admin",
	    password = "admin",
	    databaseName = "midb",
	    url = "jdbc:postgresql://postgres:5432/midb"
	)

@ApplicationPath("/api")
public class JakartaRestApp extends Application {
}