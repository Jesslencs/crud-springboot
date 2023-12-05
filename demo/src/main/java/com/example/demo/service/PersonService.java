package com.example.demo.service;

import com.example.demo.dto.request.PersonRequestDTO;
import com.example.demo.dto.response.PersonResponseDTO;

import java.util.List;

public interface PersonService {

    PersonResponseDTO findbyId(Long id );

    List<PersonResponseDTO> findAll();

    PersonResponseDTO register(PersonRequestDTO personDTO);

    PersonResponseDTO update( Long id,PersonRequestDTO personDTO);

    String delete(Long id);
}
