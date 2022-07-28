package com.learn.tdd;

import org.assertj.db.api.Assertions;
import org.assertj.db.api.RequestAssert;
import org.assertj.db.type.Request;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import javax.sql.DataSource;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BaseRepositoryTest {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    protected RequestAssert dbAssertThat(String sql, Object... params) {
        return Assertions.assertThat(new Request(dataSource, sql, params));
    }

    @AfterEach
    protected void clean() {
        jdbcTemplate.execute("delete from accounts");
        jdbcTemplate.execute("delete from notifications");
    }
}
