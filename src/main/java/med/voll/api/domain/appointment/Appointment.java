package med.voll.api.domain.appointment;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "Appointment")
@Entity(name = "appointment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Appointment {

    @Id
    long idDoctor;
    @Id
    long idPatient;
    LocalDateTime dateTime;
}
