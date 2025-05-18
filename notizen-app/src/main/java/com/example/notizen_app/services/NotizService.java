package com.example.notizen_app.services;

import com.example.notizen_app.models.Notiz;
import com.example.notizen_app.repositories.NotizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

/**
 * Service for accessing and manipulating {@link Notiz} entities.
 */
@Service
public class NotizService {

    @Autowired
    private NotizRepository notizRepository;

    /**
     * Collection of all Notizen
     *
     * @return a List of all Notizen
     */
    public Iterable<Notiz> getAll() {
        return notizRepository.findAll();
    }

    public Optional<Notiz> getById(Long id){
        return notizRepository.findById(id);
    }

    public Notiz save(Notiz notiz){
        if (notiz.getId() == null){
            notiz.setCreatedAt(Instant.now());
        }
        notiz.setUpdatedAt(Instant.now());
        return notizRepository.save(notiz);
    }

    public void delete(Notiz notiz){
        notizRepository.delete(notiz);
    }
}
