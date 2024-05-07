package fr.fms.web;

import fr.fms.entities.Training;
import fr.fms.service.ImplTrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class TrainingController {
    @Autowired
    private ImplTrainingService implTrainingService;

    @GetMapping("/trainings")
    public List<Training> allTrainings() throws Exception{
        return implTrainingService.getTrainings();
    }
}
