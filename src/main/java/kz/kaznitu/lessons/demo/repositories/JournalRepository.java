package kz.kaznitu.lessons.demo.repositories;


import kz.kaznitu.lessons.demo.models.Journal;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface JournalRepository extends CrudRepository<Journal,Long> {
    Optional<Journal> findById(Long id);
}