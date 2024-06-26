package fr.fms.web;

import fr.fms.entities.Category;
import fr.fms.entities.Training;
import fr.fms.exception.RecordNotFoundException;
import fr.fms.exception.TrainExceptionHandler;
import fr.fms.service.ImplTrainingService;
import net.bytebuddy.dynamic.scaffold.TypeWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin
@RestController
public class TrainingController {
    @Autowired
    private ImplTrainingService implTrainingService;

    @GetMapping("/trainings")
    public List<Training> allTrainings() throws Exception{
        return implTrainingService.getTrainings();
    }

    //page 11
    /*
    @PostMapping("/trainings")
    public Training saveTraining(@RequestBody Training t){
        Training training = implTrainingService.saveTraining(t);
        return implTrainingService.saveTraining(t);
    }
     */

    //page 13
    @PostMapping("/trainings")
    public ResponseEntity<Training> saveTraining(@RequestBody Training t){
        Training training = implTrainingService.saveTraining(t);
        if (Objects.isNull(training)){
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(training.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    //page 21
    @PostMapping("/training/{id}")
    public Training getTrainingById(@PathVariable("id") Long id){
        return implTrainingService.getTrainingById(id)
                .orElseThrow(() -> new RecordNotFoundException("Erreur 404 l'id "+id+" n'a pas été trouvé"));
    }

    @GetMapping("/category")
    public List<Category> categorys(Long id) throws Exception{
        return implTrainingService.getAllCategory(id);
    }
    @GetMapping("/trainingByCategory/{id}")
    public List<Training> getTrainingsByCategory(@PathVariable("id") Long id){
        return implTrainingService.getTrainingsByCategory(id);
    }
}