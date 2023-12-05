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

        return personMapper.toPersonaDTO(returnPerson(id));

    }

    @Override
    public List<PersonResponseDTO> findAll() {


        return  personMapper.toPeopleDTO(personRepository.findAll());

    }

    @Override
    public PersonResponseDTO register(PersonRequestDTO personDTO) {
        Person person = personMapper.toPerson(personDTO);

       return personMapper.toPersonaDTO(personRepository.save(person));
    }

    @Override
    public PersonResponseDTO update( Long id, PersonRequestDTO personDTO) {

        Person person = returnPerson(id);

        personMapper.updatePersonData(person,personDTO);

       return personMapper.toPersonaDTO(personRepository.save(person));


    }

    @Override
    public String delete(Long id) {
        personRepository.deleteById(id);

        return "Person id: " + id + "deleted.";

    }

    private Person returnPerson(Long id){
        return  personRepository.findById(id).orElseThrow(()-> new RuntimeException("Person wasn't found on database"));
    }
}
