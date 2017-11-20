package reviewssitefullstack;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewController {

	@Resource
	CategoryRepository categoryRepo;

	@Resource
	ReviewRepository reviewRepo;

	@Resource
	SubscriberRepository subscriberRepo = new SubscriberRepository();
	@Resource
	TagRepository tagRepo;

	@RequestMapping("/reviews")
	public String getAllBooks(Model model) {
		model.addAttribute("reviews", reviewRepo.findAll());
		return "reviews";
	}

	@RequestMapping("/categories")
	public String getAllAuthors(Model model) {
		model.addAttribute("categories", categoryRepo.findAll());
		return "categories";
	}

	@RequestMapping("/review")
	public String getOneAuthor(@RequestParam Long id, Model model) {
		model.addAttribute("review", reviewRepo.findOne(id));
		return "review";
	}

	@RequestMapping("/category")
	public String getBooksByGenre(@RequestParam Long id, Model model) {
		model.addAttribute("category", categoryRepo.findOne(id));
		return "category";
	}

	@RequestMapping("/add-subscriber")
	public String addSubscriber(String name, String email) {
		Subscriber newSubscriber = new Subscriber(name, email);
		subscriberRepo.addSubscriber(newSubscriber);

		return "redirect:/categories";
	}

	@RequestMapping("/tag")
	public String findTag(@RequestParam Long id, Model model) {
		model.addAttribute("tag", tagRepo.findOne(id));
		return "tag";
	}

	@RequestMapping("/tags")
	public String allTags(Model model) {
		model.addAttribute("tags", tagRepo.findAll());
		return "tags";
	}

	@RequestMapping("/add-tag")
	public String addTag(@RequestParam Long id, String tagName) {
		 
		Tag newTag = new Tag(tagName);
		tagRepo.save(newTag);
		Review review = reviewRepo.findOne(id);
		review.addTag(newTag);
		reviewRepo.save(review);
		return "redirect:/review?id=" + id;
	}
	@RequestMapping("/remove-tag")
	public String removeTag(@RequestParam Long id, String tagName) {
		Tag deleteTag = tagRepo.findOneByTagName(tagName);
//		Tag deleteTag = tagRepo.findOne(id);
//		find review by id
//		remove 
//		save
	Review review = reviewRepo.findOne(id);
////		Review review = reviewRepo.findOne(id);
	review.removeTag(deleteTag);
//		tagRepo.delete(newTag);
	reviewRepo.save(review);
		return "redirect:/review?id=" + id;
	}

}
