package med.voll.api.doctor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Doctor")
@Table(name = "doctors")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String crm;

    @Enumerated(EnumType.STRING)
    Specialty specialty;

    @Embedded
    Address address;

    public Doctor(DoctorRegisterData data) {
        this.name = data.name();
        this.email = data.email();
        this.crm = data.crm();
        this.specialty = data.specialty();
        this.address = new Address(data.address());
    }
}
