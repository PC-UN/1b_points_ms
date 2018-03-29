package point.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import point.model.Point;

import java.util.List;

public class PointService {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public List<Point> getAllPoints(int first, int maxResult){
		return entityManager.createNamedQuery(Point.FIND_ALL)
				.setFirstResult(first).setMaxResults(maxResult).getResultList();
	}
	
	public Point getPointById(long id) {
		return entityManager.find(Point.class, id);
	}
	
	public void createPoint(Point point) {
		entityManager.persist(point);
	}
	
	public Point updatePoint(long id, Point point) {
		Point pointToUpdate = entityManager.find(Point.class, id);
		pointToUpdate.setLatitude(point.getLatitude());
		pointToUpdate.setLongitude(point.getLongitude());
		pointToUpdate.setCategory(point.getCategory());
		pointToUpdate.setSubcategory(point.getSubcategory());
		return entityManager.merge(pointToUpdate);
	}
	
	public void deletePoint(long id) {
		Point point = entityManager.find(Point.class, id);
		entityManager.remove(point);
	}
	
	

}
