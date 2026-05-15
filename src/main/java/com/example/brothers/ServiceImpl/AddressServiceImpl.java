package com.example.brothers.ServiceImpl;

import com.example.brothers.Entity.Address;
import com.example.brothers.Repository.AddressRepository;
import com.example.brothers.Service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Override
    public Address addAddress(Address address) {

        // If default → unset previous default
        if (Boolean.TRUE.equals(address.getIsDefault())) {
            Address existing = addressRepository
                    .findByUserIdAndIsDefaultTrue(address.getUser().getId());

            if (existing != null) {
                existing.setIsDefault(false);
                addressRepository.save(existing);
            }
        }

        return addressRepository.save(address);
    }

    @Override
    public List<Address> getUserAddresses(Long userId) {
        return addressRepository.findByUserId(userId);
    }

    @Override
    public Address getDefaultAddress(Long userId) {
        return addressRepository.findByUserIdAndIsDefaultTrue(userId);
    }
}