package point.model;

import javax.persistence.*;

@Entity
@Table(name = "points")
@NamedQueries({
  @NamedQuery(name = Point.FIND_ALL, query = "SELECT u FROM Course u")})
public class Point {
	
	public static final String FIND_ALL = "Point.findAll";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private double latitude;
	private double longitude;
	private String category;
	private String subcategory;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	
	

}
