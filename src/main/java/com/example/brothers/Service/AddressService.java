package com.example.brothers.Service;

import com.example.brothers.Entity.Address;
import java.util.List;

public interface AddressService {

    Address addAddress(Address address);

    List<Address> getUserAddresses(Long userId);

    Address getDefaultAddress(Long userId);
}