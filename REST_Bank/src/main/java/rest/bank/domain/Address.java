package rest.bank.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Address extends AbstractEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Long id;
	
	@NotEmpty(message= "{street.valid}")
	@Column
	private String street;
	@Column
	
	@NotEmpty(message= "{city.valid}")
	private String city;
	
	
	@NotEmpty(message= "{zip.valid}")
	@Column
	private String zip;
	
	
	@Size(min=2, message= "{state.size}")
	@Column
	private String state;
	
	public Address() {
		super();
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", zip=" + zip + ", state=" + state + "]";
	}
	
	
}
