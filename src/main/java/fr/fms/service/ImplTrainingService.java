package fr.fms.service;

import fr.fms.dao.CategoryRepository;
import fr.fms.entities.Category;
import fr.fms.entities.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fr.fms.dao.TrainingRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ImplTrainingService implements ITrainingService{

    @Autowired
    TrainingRepository trainingRepository;
    @Autowired
    CategoryRepository categoryRepository;

    private List<Training> trainingsList;

    public List<Training> getTrainings() {
        return trainingRepository.findAll();
    }

    public Training saveTraining(Training training){
        return trainingRepository.save(training);
    }

    @Override
    public Optional<Training> getTrainingById(Long id){
        return trainingRepository.findById(id);
    }

    public List<Training> getTrainingsByCategory(Long id) {
        return trainingRepository.findByCategoryId(id);
    }
    public List<Category> getAllCategory(Long id) {
        return categoryRepository.findAll();
    }
}