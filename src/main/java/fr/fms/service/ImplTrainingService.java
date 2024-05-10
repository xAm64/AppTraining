package fr.fms.service;

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

    private List<Training> trainingsList;

    public List<Training> getTrainings() {
        return trainingRepository.findAll();
    }

    public Training saveTraining(Training training){
        return trainingRepository.save(training);
    }

    @Override
    public Training getTrainingById(Long id){
        return trainingRepository.findById(id).get();
    }
}