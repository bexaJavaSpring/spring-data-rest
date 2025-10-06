package uz.java.springdatarest.dto.reponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.java.springdatarest.model.Address;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddressResponse {
    private String street;
    private String city;
    private String state;
    private String zip;
    private String country;

    public static AddressResponse toDto(Address address) {
        if (address == null) return null;
        AddressResponse addressResponse = new AddressResponse();
        addressResponse.setStreet(address.getStreet());
        addressResponse.setCity(address.getCity());
        addressResponse.setState(address.getState());
        addressResponse.setZip(address.getZip());
        return addressResponse;
    }
}
