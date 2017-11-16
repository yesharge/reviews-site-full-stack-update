package reviewssitefullstack;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue
	private Long categoryId;

	private String title;

	@OneToMany(mappedBy = "category")
	private Set<Review> reviews;

	protected Category() {
	}

	public Category(String title) {

		this.title = title;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public Set<Review> getReviews() {
		return reviews;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public String toString() {
		return String.format("Category[title='%s']", title);
	}

}
