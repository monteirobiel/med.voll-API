package med.voll.api.patients;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.doctor.Address;

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

    public void infoUpdate(PatientRegisterData dados) {
        if (dados.name() != null) {
            this.name = dados.name();
        }
        if (dados.phone() != null) {
            this.phone = dados.phone();
        }
        if (dados.address() != null) {
            this.address.infoUpdate(dados.address());
        }
    }
}
