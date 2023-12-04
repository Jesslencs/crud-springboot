package com.example.demo.service;


import com.example.demo.dto.request.PersonRequestDTO;
import com.example.demo.dto.response.PersonResponseDTO;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class PersonServiceImpl implements PersonService {
    @Override
    public PersonResponseDTO findbyId(Long id) {
        return null;
    }

    @Override
    public List<PersonResponseDTO> findAll() {
        return null;
    }

    @Override
    public PersonResponseDTO register(PersonRequestDTO personDTO) {
        return null;
    }

    @Override
    public PersonResponseDTO update(PersonRequestDTO personDTO) {
        return null;
    }

    @Override
    public String delete(Long id) {
        return null;
    }
}
