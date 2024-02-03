package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.domain.Courses;
import com.mycompany.myapp.repository.CoursesRepository;
import com.mycompany.myapp.service.CoursesService;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.mycompany.myapp.domain.Courses}.
 */
@Service
@Transactional
public class CoursesServiceImpl implements CoursesService {

    private final Logger log = LoggerFactory.getLogger(CoursesServiceImpl.class);

    private final CoursesRepository coursesRepository;

    public CoursesServiceImpl(CoursesRepository coursesRepository) {
        this.coursesRepository = coursesRepository;
    }

    @Override
    public Courses save(Courses courses) {
        log.debug("Request to save Courses : {}", courses);
        return coursesRepository.save(courses);
    }

    @Override
    public Courses update(Courses courses) {
        log.debug("Request to update Courses : {}", courses);
        return coursesRepository.save(courses);
    }

    @Override
    public Optional<Courses> partialUpdate(Courses courses) {
        log.debug("Request to partially update Courses : {}", courses);

        return coursesRepository
            .findById(courses.getId())
            .map(existingCourses -> {
                if (courses.getCourseName() != null) {
                    existingCourses.setCourseName(courses.getCourseName());
                }
                if (courses.getDescription() != null) {
                    existingCourses.setDescription(courses.getDescription());
                }
                if (courses.getPrice() != null) {
                    existingCourses.setPrice(courses.getPrice());
                }
                if (courses.getNumberOfClasses() != null) {
                    existingCourses.setNumberOfClasses(courses.getNumberOfClasses());
                }
                if (courses.getTotalDuration() != null) {
                    existingCourses.setTotalDuration(courses.getTotalDuration());
                }

                return existingCourses;
            })
            .map(coursesRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Courses> findAll(Pageable pageable) {
        log.debug("Request to get all Courses");
        return coursesRepository.findAll(pageable);
    }

    /**
     *  Get all the courses where Orders is {@code null}.
     *  @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<Courses> findAllWhereOrdersIsNull() {
        log.debug("Request to get all courses where Orders is null");
        return StreamSupport
            .stream(coursesRepository.findAll().spliterator(), false)
            .filter(courses -> courses.getOrders() == null)
            .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Courses> findOne(Long id) {
        log.debug("Request to get Courses : {}", id);
        return coursesRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Courses : {}", id);
        coursesRepository.deleteById(id);
    }
}
