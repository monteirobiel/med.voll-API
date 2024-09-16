package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.doctor.Doctor;
import med.voll.api.doctor.DoctorListingData;
import med.voll.api.doctor.DoctorRegisterData;
import med.voll.api.doctor.DoctorUpdateData;
import med.voll.api.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;


    @Transactional
    @PostMapping
    public void register(@RequestBody @Valid DoctorRegisterData data) {
        repository.save(new Doctor(data));
    }

    @GetMapping
    public Page<DoctorListingData> list(Pageable pageable) {
        return repository.findAllByActiveTrue(pageable).map(DoctorListingData::new);
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid DoctorUpdateData data){
        var doctor = repository.getReferenceById(data.id());
        doctor.infoUpdate(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable long id) {
        var doctor = repository.getReferenceById(id);
        doctor.delete();
    }
}
