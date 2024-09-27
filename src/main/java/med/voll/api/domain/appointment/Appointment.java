package med.voll.api.domain.appointment;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.domain.doctor.Doctor;

import java.time.LocalDateTime;

@Table(name = "appointments")
@Entity(name = "Appointment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Doctor patient;

    private LocalDateTime date;
}
