package arqsoft.course.resource;

import arqsoft.course.model.Course;
import arqsoft.course.service.CourseService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

@Path("/point")
public class CourseResource {

    @Context
    UriInfo uriInfo;

    @EJB
    CourseService courseService;

    @GET
    public List<Course> getAllCourses(@QueryParam("first") int first, @QueryParam("maxResult") int maxResult) {
        return courseService.getAllCourses(first, maxResult);
    }

    @GET
    @Path("{id}")
    public Course getCourseById(@PathParam("id") int id) {
        return courseService.getCourseById(id);
    }

    @POST
    public Course createCourse(Course course) {
        courseService.createCourse(course);
        return course;
        //return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    public Response updateCourse(@PathParam("id") int id, Course course) {
        courseService.updateCourse(id, course);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteCourse(@PathParam("id") int id) {
        courseService.deleteCourse(id);
        return Response.status(Response.Status.OK).build();
    }

}
