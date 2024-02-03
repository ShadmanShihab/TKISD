package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.Instructor;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Instructor entity.
 */
@SuppressWarnings("unused")
@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {}
