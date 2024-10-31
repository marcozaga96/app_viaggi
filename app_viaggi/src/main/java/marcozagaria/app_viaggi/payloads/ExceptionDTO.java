package marcozagaria.app_viaggi.payloads;

import java.time.LocalDateTime;

public record ExceptionDTO(String message, LocalDateTime timestamp) {
}
