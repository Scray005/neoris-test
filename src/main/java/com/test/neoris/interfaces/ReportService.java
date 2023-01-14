package com.test.neoris.interfaces;

import com.test.neoris.entities.ReporteEntity;

import java.util.List;

public interface ReportService<T> {

    List<ReporteEntity> generarReporte(Integer idCliente, String fechas);

}
