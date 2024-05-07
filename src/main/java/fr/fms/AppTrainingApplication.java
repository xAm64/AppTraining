package fr.fms;

import fr.fms.dao.TrainingRepository;
import fr.fms.entities.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppTrainingApplication implements CommandLineRunner {

	@Autowired
	private TrainingRepository trainingRepository;

	public static void main(String[] args) {
		SpringApplication.run(AppTrainingApplication.class, args);
	}

	@Override
	public void run(String... args) throws  Exception {
		trainingRepository.save(new Training("Expresso", "Café court et fort", 0.93, 1));
		trainingRepository.save(new Training("Café long", "Un café long et moins intense", 1.11, 1));
		trainingRepository.save(new Training("Cappuchino", "Café + lait + chocolat", 1.93, 1));
		trainingRepository.save(new Training("Café au lait", "Un café avec du lait", 1.21, 1));
		trainingRepository.save(new Training("Mocha", "Un café avec un nuage de lait", 1.18, 1));
		trainingRepository.save(new Training("Chocolat", "Un chocolat avec du lait", 1.29, 1));
		trainingRepository.save(new Training("Chocolat intense", "Un chocolat plus intense", 1.47, 1));
		trainingRepository.save(new Training("Thé à la mente", "Thé à la mente", 1.42, 1));
	}

}
