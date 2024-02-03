package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.Courses;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.mycompany.myapp.domain.Courses}.
 */
public interface CoursesService {
    /**
     * Save a courses.
     *
     * @param courses the entity to save.
     * @return the persisted entity.
     */
    Courses save(Courses courses);

    /**
     * Updates a courses.
     *
     * @param courses the entity to update.
     * @return the persisted entity.
     */
    Courses update(Courses courses);

    /**
     * Partially updates a courses.
     *
     * @param courses the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Courses> partialUpdate(Courses courses);

    /**
     * Get all the courses.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Courses> findAll(Pageable pageable);

    /**
     * Get all the Courses where Orders is {@code null}.
     *
     * @return the {@link List} of entities.
     */
    List<Courses> findAllWhereOrdersIsNull();

    /**
     * Get the "id" courses.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Courses> findOne(Long id);

    /**
     * Delete the "id" courses.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
