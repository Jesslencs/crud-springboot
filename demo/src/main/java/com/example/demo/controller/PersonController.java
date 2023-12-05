package com.example.demo.controller;

import com.example.demo.dto.request.PersonRequestDTO;
import com.example.demo.dto.response.PersonResponseDTO;
import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/people")
@RequiredArgsConstructor
public class PersonController {


    private final PersonService personService;

    @GetMapping(value = "/{id}")
    private ResponseEntity<PersonResponseDTO> findByid(@PathVariable (name = "id")Long id) {

        return ResponseEntity.ok().body(personService.findbyId(id));

    }

    @GetMapping
    private ResponseEntity<List<PersonResponseDTO>> findAll() {
        return ResponseEntity.ok().body(personService.findAll());
    }

    @PostMapping
    public ResponseEntity<PersonResponseDTO> register( @RequestBody  PersonRequestDTO personRequestDTO, UriComponentsBuilder uriBuilder) {



        PersonResponseDTO personResponseDTO = personService.register(personRequestDTO);

        URI uri = uriBuilder.path("/people/{id}").buildAndExpand(personResponseDTO.getId()).toUri();

        return  ResponseEntity.created(uri).body(personResponseDTO);
    }


    @PutMapping(value = "/{id}")

    public ResponseEntity<PersonResponseDTO> update(@RequestBody PersonRequestDTO personDTO, @PathVariable(name = "id") Long id) {

        return ResponseEntity.ok().body(personService.update(id,personDTO));



    }

    @DeleteMapping(value = "/{id}")
    public  ResponseEntity<String> delete(@PathVariable(value = "id")Long id) {
        return ResponseEntity.ok().body(personService.delete(id));
    }




}
