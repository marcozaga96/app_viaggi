package marcozagaria.app_viaggi.services;

import marcozagaria.app_viaggi.entities.Dipendente;
import marcozagaria.app_viaggi.exeption.NotFoundException;
import marcozagaria.app_viaggi.payloads.DipendenteDTO;
import marcozagaria.app_viaggi.repositories.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class DipendenteService {
    @Autowired
    private DipendenteRepository dipendenteRepository;

    public Page<Dipendente> getAllDipendenteList(int page, int size, String sortBy) {
        if (size > 100) size = 100;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return dipendenteRepository.findAll(pageable);
    }

    public Dipendente saveDipendente(DipendenteDTO body) {
        Dipendente newDipendente = new Dipendente(body.nome(), body.cognome(), body.email(), body.username());
        return dipendenteRepository.save(newDipendente);
    }


    public Dipendente cercaId(UUID id) {

        return dipendenteRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public Dipendente cercaDipendenteEModifica(UUID id, DipendenteDTO body) {
        Dipendente cerca = cercaId(id);
        cerca.setNome(body.nome());
        cerca.setCognome(body.cognome());
        cerca.setEmail(body.email());
        cerca.setUsername(body.username());
        if (cerca == null) throw new NotFoundException(id);
        return dipendenteRepository.save(cerca);
    }

    public void cercaDipendenteECancella(UUID id) {
        Dipendente cerca = cercaId(id);
        if (cerca == null) throw new NotFoundException(id);
        dipendenteRepository.delete(cerca);
    }
}
