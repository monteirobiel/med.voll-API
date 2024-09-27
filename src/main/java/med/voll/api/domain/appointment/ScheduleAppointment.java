package med.voll.api.domain.appointment;

import med.voll.api.repositories.AppointmentRepository;
import med.voll.api.repositories.DoctorRepository;
import med.voll.api.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleAppointment {
    @Autowired
    private AppointmentRepository repository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;


    public void schedule(AppointmentRegisterData data) {



        var patient = patientRepository.findById(data.idPatient()).isPresent();
        var doctor = doctorRepository.findById(data.idDoctor()).isPresent();
        var appointment = new Appointment();
        repository.save(appointment);
    }
}
