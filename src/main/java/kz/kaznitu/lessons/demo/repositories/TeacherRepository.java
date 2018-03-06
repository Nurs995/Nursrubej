package kz.kaznitu.lessons.demo.repositories;

import kz.kaznitu.lessons.demo.models.Teacher;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {
    Optional<Teacher> findById(Long id);

}


