package fr.fms.service;

import fr.fms.entities.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ITrainingService {
    public Optional<Training> getTrainingById(Long id) throws Exception;
}
