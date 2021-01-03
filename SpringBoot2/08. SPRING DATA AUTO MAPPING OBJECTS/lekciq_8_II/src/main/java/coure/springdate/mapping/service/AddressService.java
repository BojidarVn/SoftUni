package coure.springdate.mapping.service;

import coure.springdate.mapping.entity.Address;

import java.util.List;

public interface AddressService {

    List<Address> getAllAddress();
    Address getAddressById(Long id);
    Address addAddress(Address address);
    Address updateAddress(Address address);
    Address deleteAddress(Long id);
    long getAddressCount();
}
