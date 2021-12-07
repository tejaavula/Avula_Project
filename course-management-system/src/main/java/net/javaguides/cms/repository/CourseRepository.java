package net.javaguides.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.cms.entity.Course;

public interface CourseRepository extends JpaRepository<Course , Long> {

}
