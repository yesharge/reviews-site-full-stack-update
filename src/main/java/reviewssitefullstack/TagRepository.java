package reviewssitefullstack;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends CrudRepository<Tag,Long> {
	Tag findOneByTagName(String tagName);
}
