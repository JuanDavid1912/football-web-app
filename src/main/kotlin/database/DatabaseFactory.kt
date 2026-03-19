package dev.davidbuitrago.database

import org.jetbrains.exposed.v1.jdbc.Database
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource

object DatabaseFactory {
    fun init() {
        val url = System.getenv("DB_URL")
        val user = System.getenv("DB_USER")
        val password = System.getenv("DB_PASSWORD")

        Database.connect(hikari(url, user, password))
    }

    private fun hikari(url: String, user: String, pass: String): HikariDataSource {
        val config = HikariConfig()
        config.driverClassName = "org.postgresql.Driver"

        config.jdbcUrl = url
        config.username = user
        config.password = pass

        config.maximumPoolSize = 3
        config.isAutoCommit = false
        config.transactionIsolation = "TRANSACTION_REPEATABLE_READ"
        config.validate()

        return HikariDataSource(config)
    }
}