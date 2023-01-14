package com.test.neoris.services;

import com.test.neoris.interfaces.ReportService;
import com.test.neoris.entities.ReporteEntity;
import com.test.neoris.repositorys.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImp implements ReportService {

    @Autowired
    ReportRepository reportRepository;
    @Override
    public List<ReporteEntity> generarReporte(Integer idCliente, String fechas){
        return reportRepository.findLastSaldo(idCliente, fechas);
    }
}
