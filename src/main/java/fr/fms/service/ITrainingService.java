package fr.fms.service;

import fr.fms.entities.*;
import org.springframework.stereotype.Service;

@Service
public interface ITrainingService {
    public Training getTrainingById(Long id) throws Exception;
}
