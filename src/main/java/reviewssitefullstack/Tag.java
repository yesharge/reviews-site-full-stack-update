package reviewssitefullstack;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;



@Entity
public class Tag {
	@Id
	@GeneratedValue
	private Long tagId;
	
	private String tagName;
	@ManyToMany (mappedBy = "tags") 
	private Set<Review> reviews;
	
	public Long getTagId() {
		return tagId;
	}

	public String getTagName() {
		return tagName;
	}

	public Set<Review> getReviews() {
		return reviews;
	}

	protected Tag() {}
	
	public Tag(String tagName) {
		this.tagName=tagName;
	}
	@Override
	public String toString() {
		return String.format("Tag[tagName='%s', description='%s']", tagName);
}
}
