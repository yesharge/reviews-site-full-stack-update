package reviewssitefullstack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Review {
	@Id
	@GeneratedValue
	private Long reviewId;
	private String title;
	@Lob
	private String imageUrl;
	@Lob
	private String description;

	@ManyToOne
	private Category category;

	@ManyToMany
	private Set<Tag> tags = new HashSet<Tag>();

	protected Review() {
	}

	public Review(String title, String description, String imageUrl, Category category, Tag... tags) {
		this.title = title;
		this.description = description;
		this.category = category;
		this.imageUrl = imageUrl;
		this.tags = new HashSet<Tag>(Arrays.asList(tags));
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public Long getReviewId() {
		return reviewId;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public Category getCategory() {
		return category;
	}

	public String getImageUrl() {
		return imageUrl;
	}
	public void addTag(Tag tagName) {
		tags.add(tagName);
	}
	public void removeTag(Tag tagName) {
		tags.remove(tagName);
	}
	public boolean checkIfTagExists(Tag tagName) {
		if(tags.contains(tagName)) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return String.format("Review[title='%s', description='%s', imageUrl='%s',category='%s',tags='%s]", title,
				description, imageUrl, category, tags);
	}

}
