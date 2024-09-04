package med.voll.api.doctor;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    String street;
    String neighborhood;
    String zipCode;
    String city;
    String uf;
    String complement;
    String number;
}
