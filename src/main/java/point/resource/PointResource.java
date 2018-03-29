package point.resource;
import point.model.Point;
import point.service.PointService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import java.net.URI;
import java.util.List;



@Path("/point")
public class PointResource {
	
	@Context
    UriInfo uriInfo;
	
	@EJB
	PointService pointService;
	
	@GET
	public List<Point> getAllPoints(@QueryParam("first") int first, @QueryParam("maxResult") int maxResult){
		return pointService.getAllPoints(first, maxResult);
	}
	
	@GET
	@Path("{id}")
	public Point getPointById(@PathParam("id") long id) {
		return pointService.getPointById(id);
	}
	
	@POST
	public Response createPoint(Point point) {
		pointService.createPoint(point);
		return Response.status(Response.Status.CREATED).build();
	}
	
	@PUT
	@Path("{id}")
	public Response updatePont(@PathParam("id") long id, Point point) {
		pointService.updatePoint(id, point);
		return Response.status(Response.Status.NO_CONTENT).build();
	}
	
	@DELETE
	@Path("{id")
	public Response deletePoint(@PathParam("id") long id) {
		pointService.deletePoint(id);
		return Response.status(Response.Status.OK).build();
	}

}
