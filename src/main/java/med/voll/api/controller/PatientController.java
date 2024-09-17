package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.patients.PatientListingData;
import med.voll.api.patients.Patient;
import med.voll.api.patients.PatientRegisterData;
import med.voll.api.patients.PatientUpdateData;
import med.voll.api.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientRepository repository;

    @PostMapping
    @Transactional
    public void register (@RequestBody @Valid PatientRegisterData data) {
        repository.save(new Patient(data));
    }

    @GetMapping
    public Page<PatientListingData> list(Pageable pageable) {
        return repository.findAllByActiveTrue(pageable).map(PatientListingData::new);
    }

    @PutMapping
    @Transactional
    public void update (@RequestBody @Valid PatientUpdateData data) {
        var doctor = repository.getReferenceById(data.id());
        doctor.infoUpdate(data);
    }
}
