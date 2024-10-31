package marcozagaria.app_viaggi.exeption;

import java.util.UUID;

public class NotFoundException extends RuntimeException {
    public NotFoundException(UUID id) {
        super("l'id: " + id + " no è stato trovato");
    }
}
