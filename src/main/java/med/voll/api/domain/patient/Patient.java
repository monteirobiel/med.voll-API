package med.voll.api.domain.patient;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.doctor.Address;
import med.voll.api.patients.PatientRegisterData;
import med.voll.api.patients.PatientUpdateData;

@Entity(name = "Patient")
@Table(name = "patients")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    String name;
    String email;
    String phone;
    String cpf;

    private Boolean active;

    @Embedded
    Address address;

    public Patient(PatientRegisterData data) {
        this.name = data.name();
        this.email = data.email();
        this.phone = data.phone();
        this.cpf = data.cpf();
        this.active = true;
        this.address = new Address(data.address());
    }

    public void infoUpdate(PatientUpdateData data) {
        if (data.name() != null) {
            this.name = data.name();
        }
        if (data.phone() != null) {
            this.phone = data.phone();
        }
        if (data.address() != null) {
            this.address.infoUpdate(data.address());
        }

    }
    public void delete() {
        this.active = false;
    }
}
