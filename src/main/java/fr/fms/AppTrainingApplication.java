package fr.fms;

import fr.fms.dao.CategoryRepository;
import fr.fms.dao.TrainingRepository;
import fr.fms.entities.Category;
import fr.fms.entities.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppTrainingApplication implements CommandLineRunner {

	@Autowired
	private TrainingRepository trainingRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(AppTrainingApplication.class, args);
	}

	@Override
	public void run(String... args) throws  Exception {
		createCafe();
	}

	public void createCafe(){
		Category cafe = categoryRepository.save(new Category("Café", "Séléction de cafées"));
		Category chocolat = categoryRepository.save(new Category("Chocolats", "Séléction de chocolats"));
		Category the = categoryRepository.save(new Category("Thés", "Séléction de thés"));
		Category divers = categoryRepository.save(new Category("Autres", "Les autres boissons"));

		trainingRepository.save(new Training("Expresso", "Café court et fort", 0.93, 1, cafe));
		trainingRepository.save(new Training("Café long", "Un café long et moins intense", 1.11, 1, cafe));
		trainingRepository.save(new Training("Cappuchino", "Café + lait + chocolat", 1.93, 1, cafe));
		trainingRepository.save(new Training("Café au lait", "Un café avec du lait", 1.21, 1, cafe));
		trainingRepository.save(new Training("Mocha", "Un café avec un nuage de lait", 1.18, 1, cafe));
		trainingRepository.save(new Training("Chocolat", "Un chocolat avec du lait", 1.29, 1, chocolat));
		trainingRepository.save(new Training("Chocolat intense", "Un chocolat plus intense", 1.47, 1, chocolat));
		trainingRepository.save(new Training("Thé à la mente", "Thé à la mente", 1.42, 1, the));
		trainingRepository.save(new Training("Thé au citron", "Thé au goût de citron", 1.42, 1, the));
	}
}
