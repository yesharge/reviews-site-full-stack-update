package reviewssitefullstack;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


public class Subscriber {
	
		@Id
		@GeneratedValue
		private Long subscriberId;
	private String name;
	private String email;
	
	protected Subscriber() {}
	

	public Subscriber (String name, String email) {
		this.name=name;
		this.email=email;
	}
	
	public Long getSubscriberId() {
		return subscriberId;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}


}
