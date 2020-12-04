package com.sbm.dealer.service;

import java.util.List;

import com.sbm.dealer.common.exception.GenericExceptionMapper;
import com.sbm.dealer.dto.DealerDto;

public interface DealerService {

    DealerDto getDealerById(Long id) throws GenericExceptionMapper;

    List<DealerDto> getAllDealers() ;

    DealerDto saveDealer(DealerDto dealerDto) throws GenericExceptionMapper;

    DealerDto updateDealer(DealerDto dealerDto) throws GenericExceptionMapper;

    void deleteDealer(Long id) throws GenericExceptionMapper;
    
    List<DealerDto> getDealersByFields(DealerDto dealerDto) throws GenericExceptionMapper;
}
