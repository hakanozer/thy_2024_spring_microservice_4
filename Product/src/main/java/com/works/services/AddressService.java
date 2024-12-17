package com.works.services;

import com.works.entities.Address;
import com.works.projections.AddressJoinCity;
import com.works.repositories.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    final AddressRepository addressRepository;

    public Address save(Address address) {
        return addressRepository.save(address);
    }

    public List<AddressJoinCity> list(int cid) {
        List<AddressJoinCity> ls = addressRepository.findAddressJoinCity(cid);
        for (AddressJoinCity addressJoinCity : ls) {
            //System.out.println(addressJoinCity.getAid());
        }
        return ls;
    }


}
