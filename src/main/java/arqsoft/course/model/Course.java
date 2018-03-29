package arqsoft.course.model;

import javax.persistence.*;

@Entity
@Table(name = "courses")
@NamedQueries({
  @NamedQuery(name = Course.FIND_ALL, query = "SELECT u FROM Course u")})
public class Course {

    public static final String FIND_ALL = "Course.findAll";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    String name;
    String address;
    String category;
    String contact;
  	String email;
  	float latitude;
  	float longitude;
  	String business_hours;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName(){
      return name;
    }
    public void setName(String name){
      this.name = name;
    }
    public String getAddress() {
	      return address;
	  }
	  public void setAddress(String address) {
	      this.address = address;
	  }
    public String getCategory() {
	      return category;
	  }
	  public void setCategory(String category) {
	      this.category = category;
	  }
	  public String getContact() {
	      return contact;
	  }
	  public void setContact(String contact) {
	      this.contact = contact;
	  }
	  public String getEmail() {
	      return email;
	  }
	  public void setEmail(String email) {
	      this.email = email;
	  }
    public float getLatitude() {
        return latitude;
    }
    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }
    public float getLongitude() {
        return longitude;
    }
    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
    public String getBusiness_hours() {
        return business_hours;
    }
    public void setBusiness_hours(String business_hours) {
        this.business_hours = business_hours;
    }

}
