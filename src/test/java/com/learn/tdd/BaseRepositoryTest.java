package com.learn.tdd;

import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import org.assertj.db.api.Assertions;
import org.assertj.db.api.RequestAssert;
import org.assertj.db.type.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.sql.DataSource;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@AutoConfigureEmbeddedDatabase(
        provider = AutoConfigureEmbeddedDatabase.DatabaseProvider.ZONKY,
        type = AutoConfigureEmbeddedDatabase.DatabaseType.POSTGRES,
        refresh = AutoConfigureEmbeddedDatabase.RefreshMode.AFTER_EACH_TEST_METHOD
)
public class BaseRepositoryTest {
    @Autowired
    private DataSource dataSource;

    protected RequestAssert dbAssertThat(String sql, Object... params) {
        return Assertions.assertThat(new Request(dataSource, sql, params));
    }
}
