package med.voll.api.domain.appointment;

import java.time.LocalDateTime;

public record AppointmentDetailData(

        Long id,
        Long idPatient,
        String idDoctor,
        LocalDateTime dateTime) {
}
