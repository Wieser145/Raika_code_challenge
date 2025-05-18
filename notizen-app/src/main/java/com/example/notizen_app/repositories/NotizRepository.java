package com.example.notizen_app.repositories;

import com.example.notizen_app.models.Notiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for managing {@link Notiz} entities.
 */
@Repository
public interface NotizRepository extends JpaRepository<Notiz, Long> {
}
