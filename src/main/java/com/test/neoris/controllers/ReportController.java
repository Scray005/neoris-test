package com.test.neoris.controllers;

import com.test.neoris.interfaces.ReportService;
import com.test.neoris.models.ResponseDto;
import com.test.neoris.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
@RequestMapping("/reportes")
@RestController
public class ReportController {

    @Autowired
    ReportService report;
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto<Object> generateReport(@PathParam("fechas") String fecha, @PathParam("idCliente") Integer idCliente) {
        return  ResponseDto.builder()
                .code(200).message(Constant.MESSAGE_FIND)
                .data(report.generarReporte(idCliente, fecha))
                .build();
    }
}
