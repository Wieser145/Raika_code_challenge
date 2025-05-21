package com.example.notizen_app;

import com.example.notizen_app.models.Notiz;
import com.example.notizen_app.repositories.NotizRepository;
import com.example.notizen_app.services.NotizService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class NotizenAppApplicationTests {


    @InjectMocks
    private NotizService notizService;

    @Mock
    private NotizRepository notizRepository;

    @Test
    public void testGetEmployeeById() {
        // Arrange
        long notizId = 1L;
        Notiz mockNotiz = Notiz.builder()
                .id(notizId)
                .description("Buy milk")
                .title("Shopping")
                .build();

        // Mock the behavior of the repository to return the mock employee
        Mockito.when(notizRepository.findById(notizId)).thenReturn(Optional.of(mockNotiz));

        // Act
        Notiz result = notizService
                .getNotizById(notizId)
                .orElse(null);

        // Assert
        assertNotNull(result);
        assertEquals(notizId, result.getId());
        assertEquals("Buy milk", result.getDescription());
        assertEquals("Shopping", result.getTitle());
    }

}