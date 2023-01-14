package com.test.neoris.controllers;

import com.test.neoris.entities.CuentaEntity;
import com.test.neoris.interfaces.GenericService;
import com.test.neoris.models.ResponseDto;
import com.test.neoris.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/clientes")
@RestController
public class ClienteController {

    @Autowired
    @Qualifier("cliente")
    GenericService clienteRepository;

    @GetMapping(value = "/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto<Object> find(@PathVariable("id") Integer idx) {
        return  ResponseDto.builder()
                .code(200).message(Constant.MESSAGE_FIND)
                .data(clienteRepository.find(idx))
                .build();
    }

    @GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto<Object> findAll() {
        return  ResponseDto.builder()
                .code(200).message(Constant.MESSAGE_FIND)
                .data(clienteRepository.findAll())
                .build();
    }
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto<Object> save(@RequestBody CuentaEntity cuentaEntity) {
        clienteRepository.save(cuentaEntity);
        return  ResponseDto.builder()
                .code(200)
                .message(Constant.MESSAGE_CREATE)
                .build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto<Object> delete(@PathVariable("id") Integer idx) {
        clienteRepository.delete(idx);
        return  ResponseDto.builder()
                .code(200).message(Constant.MESSAGE_DELETE)
                .build();
    }
}
