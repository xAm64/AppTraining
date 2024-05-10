package fr.fms.exception;

import lombok.Data;
import java.util.List;

@Data
public class ErrorReponse {
    private String message;
    private List<String> details;

    public ErrorReponse(String message, List<String> details){
        super();
        this.message = message;
        this.details = details;
    }
}
