package marcozagaria.app_viaggi.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record DipendenteDTO(@NotEmpty(message = "Il nome proprio è obbligatorio!")
                            @Size(min = 2, max = 40, message = "Il nome proprio deve essere compreso tra 2 e 40 caratteri!")
                            String nome,
                            @NotEmpty(message = "Il cognome proprio è obbligatorio!")
                            @Size(min = 2, max = 40, message = "Il cognome deve essere compreso tra 2 e 40 caratteri!")
                            String cognome,
                            @NotEmpty(message = "L' username proprio è obbligatorio!")
                            @Size(min = 2, max = 40, message = "L' username deve essere compreso tra 2 e 40 caratteri!")
                            String username,
                            @NotEmpty(message = "L'email è un campo obbligatorio!")
                            @Email(message = "L'email inserita non è un'email valida")
                            String email,
                            @NotEmpty(message = "La password è un campo obbligatorio!")
                            @Size(min = 4, message = "La password deve avere almeno 4 caratteri!")
                            // @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[*.!@$%^&(){}[]:;<>,.?/~_+-=|\]).{8,32}$")
                            // Tramite questa annotazione possiamo utilizzare le Regex per validare praticamente qualsiasi cosa (ad es. PW fatte secondo certi criteri)
                            String password) {
}
