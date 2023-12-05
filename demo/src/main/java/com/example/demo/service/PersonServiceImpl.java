package com.example.demo.service;


import com.example.demo.dto.request.PersonRequestDTO;
import com.example.demo.dto.response.PersonResponseDTO;
import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;
import com.example.demo.util.PersonMapper;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final  PersonRepository personRepository;

    private final PersonMapper personMapper;
    @Override
    public PersonResponseDTO findbyId(Long id) {
        Person person = returnPerson(id);
        return personMapper.toPersonalDTO(person);

    }

    @Override
    public List<PersonResponseDTO> findAll() {


        return  personMapper.toPeopleDTO(personRepository.findAll());

    }

    @Override
    public PersonResponseDTO register(PersonRequestDTO personDTO) {
        return null;
    }

    @Override
    public PersonResponseDTO update(PersonRequestDTO personDTO, Long id) {

        Person person = returnPerson(id);
    }

    @Override
    public String delete(Long id) {
        return null;
    }

    private Person returnPerson(Long id){
        return  personRepository.findById(id).orElseThrow(()-> new RuntimeException("Person wasn't found on database"));
    }
}
