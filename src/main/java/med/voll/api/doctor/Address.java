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
    String zipcode;
    String city;
    String uf;
    String complement;
    String number;

    public Address(AddressData data) {
        this.street = data.street();
        this.neighborhood = data.neighborhood();
        this.zipcode = data.zipCode();
        this.city = data.city();
        this.uf = data.uf();
        this.complement = data.complement();
        this.number = data.number();
    }
}