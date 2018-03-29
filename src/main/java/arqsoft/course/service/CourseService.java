package arqsoft.course.service;

import arqsoft.course.model.Course;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class CourseService {

    @PersistenceContext
    EntityManager entityManager;

    public List<Course> getAllCourses(int first, int maxResult) {
        return entityManager.createNamedQuery(Course.FIND_ALL)
                .setFirstResult(first).setMaxResults(maxResult).getResultList();
    }

    public Course getCourseById(int id){
        return entityManager.find(Course.class, id);
    }

    public void createCourse(Course course) {
        entityManager.persist(course);
    }

    public Course updateCourse(int id, Course course) {
        Course courseToUpdate = entityManager.find(Course.class, id);
        courseToUpdate.setName(course.getName());
        courseToUpdate.setAddress(course.getAddress());
        courseToUpdate.setCategory(course.getCategory());
        courseToUpdate.setContact(course.getContact());
        courseToUpdate.setEmail(course.getEmail());
        courseToUpdate.setLatitude(course.getLatitude());
        courseToUpdate.setLongitude(course.getLongitude());
        courseToUpdate.setBusiness_hours(course.getBusiness_hours());
        return entityManager.merge(courseToUpdate);
    }

    public void deleteCourse(int id) {
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }
}
