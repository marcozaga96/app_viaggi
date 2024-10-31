package marcozagaria.app_viaggi.controllers;

import marcozagaria.app_viaggi.entities.Dipendente;
import marcozagaria.app_viaggi.payloads.DipendenteDTO;
import marcozagaria.app_viaggi.services.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/* *************************************************** USERS CRUD ****************************************************
1. GET http://localhost:3001/users
2. POST http://localhost:3001/users (+ payload)
3. GET http://localhost:3001/users/{userId}
4. PUT http://localhost:3001/users/{userId} (+ payload)
5. DELETE http://localhost:3001/users/{userId}
*/


@RestController
@RequestMapping("/dipendente")
public class DipendenteController {

    @Autowired
    private DipendenteService dipendenteService;

    @GetMapping
    public Page<Dipendente> getAutori(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size,
                                      @RequestParam(defaultValue = "id") String sortBy) {
        // Mettiamo dei valori di default per far si che non ci siano errori se il client non ci invia uno dei query parameters
        return dipendenteService.getAllDipendenteList(page, size, sortBy);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Dipendente createDipendente(@RequestBody DipendenteDTO body) {
        return dipendenteService.saveDipendente(body);
    }

    @GetMapping("/{Id}")
    public Dipendente createDipendenteId(@PathVariable UUID Id) {
        return dipendenteService.cercaId(Id);
    }

    @PutMapping("/{Id}")
    public Dipendente cercaEModifica(@PathVariable UUID Id, @RequestBody DipendenteDTO body) {
        return dipendenteService.cercaDipendenteEModifica(Id, body);
    }

    @DeleteMapping("/{Id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    public void cercaECancella(@PathVariable UUID Id) {
        dipendenteService.cercaDipendenteECancella(Id);
    }
}
