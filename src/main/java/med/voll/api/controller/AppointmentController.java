package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.appointment.Appointment;
import med.voll.api.domain.appointment.AppointmentDetailData;
import med.voll.api.domain.appointment.AppointmentRegisterData;
import med.voll.api.domain.appointment.ScheduleAppointment;
import med.voll.api.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentRepository repository;

    @Autowired
    private ScheduleAppointment scheduleAppointment;

    @PostMapping
    @Transactional
    public ResponseEntity schedule (@RequestBody @Valid AppointmentRegisterData data){
        scheduleAppointment.schedule(data);
        return ResponseEntity.ok(new AppointmentDetailData(null, null,null,null));
    }
}
