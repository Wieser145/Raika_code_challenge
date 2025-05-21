package com.example.notizen_app;

import com.example.notizen_app.models.Notiz;
import com.example.notizen_app.services.NotizService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")                                 // load application-test.properties
@AutoConfigureTestDatabase(replace = Replace.NONE)      // don’t override your test DB
@Sql(
        scripts = "/testData.sql",                                // path under src/test/resources
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
)
class NotizenDPATests {

    @Autowired
    private NotizService notizService;

    @Test
    void testGetNotiz() {
        List<Notiz> alle = (List<Notiz>) notizService.getAllNotizen();
        assertThat(alle)
                .extracting(Notiz::getDescription)
                .containsExactlyInAnyOrder("Test note A", "Test note B");
    }
}
