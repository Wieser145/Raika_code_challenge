package com.example.notizen_app.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;

/**
 * Entity representing a Notiz.
 * A Notiz consists of a description and a title, further also the created Timestamp and the updated Timestamp are saved
 */
@Getter
@Setter
@Entity
@Table(name="notizen_table")
public class Notiz implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Description is required")
    private String description;

    private String title;

    private Instant createdAt;

    private Instant updatedAt;

    @Override
    public String toString() {
        return "Notiz{" +
                "id=" + id +
                ", text='" + description + '\'' +
                ", title='" + title + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
