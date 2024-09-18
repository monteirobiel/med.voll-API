package med.voll.api.domain.doctor;

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
        this.zipcode = data.zipcode();
        this.city = data.city();
        this.uf = data.uf();
        this.complement = data.complement();
        this.number = data.number();
    }

    public void infoUpdate(AddressData data) {
        if(data.street() != null) {
            this.street = data.street();
        }
        if(data.neighborhood() != null) {
            this.neighborhood = data.neighborhood();
        }
        if(data.zipcode() != null) {
            this.zipcode = data.zipcode();
        }
        if(data.city() != null) {
            this.city = data.city();
        }
        if(data.uf() != null) {
            this.uf = data.uf();
        }
        if(data.complement() != null) {
            this.complement = data.complement();
        }
        if(data.number() != null) {
            this.number = data.number();
        }
    }
}