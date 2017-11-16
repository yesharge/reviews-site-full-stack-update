package reviewssitefullstack;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ReviewPopulator implements CommandLineRunner {

	@Resource
	private ReviewRepository reviewRepo;
	@Resource
	private CategoryRepository categoryRepo;
	@Resource
	TagRepository tagRepo;

	@Override
	public void run(String... args) throws Exception {
		Category anastasia = new Category("Anastasia");
		categoryRepo.save(anastasia);

		Category fentyBeauty = new Category("Fenty Beauty");
		categoryRepo.save(fentyBeauty);

		Category tarte = new Category("Tarte");
		categoryRepo.save(tarte);
		Category nars = new Category("Nars");
		categoryRepo.save(nars);
		Category lorac = new Category("Lorac");
		categoryRepo.save(lorac);
		Category becca = new Category("Becca");
		categoryRepo.save(becca);

		Tag eyebrows = new Tag("eyebrows");
		tagRepo.save(eyebrows);
		Tag face = new Tag("face");
		tagRepo.save(face);
		Tag lips = new Tag("lips");
		tagRepo.save(lips);
		Tag highlight = new Tag("highlight");
		tagRepo.save(highlight);

		reviewRepo.save(new Review("Dip brow",
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\n"
						+ "tempor incididunt ut labore et dolore magna aliqua.",
				"/images/anastasia.jpg", anastasia, eyebrows, face));
		reviewRepo.save(new Review("Clay-Foundation", "Lorem ipsum dolor sit amet, consectetur adipisicing elit.",
				"/images/tarte.jpg", tarte, face));
		reviewRepo.save(new Review("Eye Bright As Day", "Lorem ipsum dolor sit amet, consectetur adipisicing elit.",
				"/images/tarte2.jpg", tarte, face));
		reviewRepo.save(
				new Review("Highlight Seen From Space ", "Lorem ipsum dolor sit amet, consectetur adipisicing elit.",
						"/images/becca2.jpg", becca, face, highlight));
		reviewRepo.save(new Review("Eye Shadow For the Lazy",
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit.", "/images/lorac.jpg", lorac, face));
		reviewRepo.save(new Review("Eye Shadow For the Mundane",
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit.", "/images/lorac2.jpg", lorac, face));
		reviewRepo
				.save(new Review("Highlight of the Night", "Lorem ipsum dolor sit amet, consectetur adipisicing elit.",
						"/images/trophywife.jpg", fentyBeauty, face, highlight));
		reviewRepo.save(new Review("Dab on these Haters", "Lorem ipsum dolor sit amet, consectetur adipisicing elit.",
				"/images/fentydab.jpg", fentyBeauty, face));
		reviewRepo.save(new Review("Steal the Spotlight", "Lorem ipsum dolor sit amet, consectetur adipisicing elit.",
				"/images/fentysteal.jpg", fentyBeauty, lips));
		reviewRepo.save(new Review("Bold Lips", "Lorem ipsum dolor sit amet, consectetur adipisicing elit.",
				"/images/narsbold.jpg", nars, lips));
		reviewRepo.save(new Review("Warm Lips", "Lorem ipsum dolor sit amet, consectetur adipisicing elit.",
				"/images/narswarm.jpg", nars, lips));
	}

}
