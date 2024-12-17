package com.works.repositories;

import com.works.entities.Address;
import com.works.projections.AddressJoinCity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query(value = """
    select AID, ADDRESS, TITLE, CID, CODE, NAME from PUBLIC.ADDRESS
    inner join PUBLIC.ADDRESS_CITIES AC on ADDRESS.AID = AC.ADDRESS_AID
    inner join PUBLIC.CITY C on C.CID = AC.CITIES_CID where c.CID = ?1
    """, nativeQuery = true)
    List<AddressJoinCity> findAddressJoinCity(int cid);

    // @Query(value = "call proName(?1)", nativeQuery = true)
    // Object getPro(String title);



}