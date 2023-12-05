package com.example.demo.util;


import com.example.demo.dto.request.PersonRequestDTO;
import com.example.demo.dto.response.PersonResponseDTO;
import com.example.demo.entity.Person;

import java.util.List;
import java.util.stream.Collectors;

public class PersonMapper {

    public Person toPerson (PersonRequestDTO personDTO) {
        return Person.builder()

                .name(personDTO.getName())
                .cpf(personDTO.getCpf())
                .age(personDTO.getAge())


                .build();
    }

    public PersonResponseDTO toPersonalDTO(Person person) {
        return new PersonResponseDTO(person);

    }

    public List<PersonResponseDTO> toPeopleDTO(List<Person> peopleList){
        return peopleList.stream().map(PersonResponseDTO::new).collect(Collectors.toList());

    }


}
