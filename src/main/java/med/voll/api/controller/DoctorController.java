package med.voll.api.controller;

import med.voll.api.doctor.Doctor;
import med.voll.api.doctor.DoctorRegisterData;
import med.voll.api.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;


    @Transactional
    @PostMapping
    public void register(@RequestBody DoctorRegisterData data) {
        repository.save(new Doctor(data));
    }
}
