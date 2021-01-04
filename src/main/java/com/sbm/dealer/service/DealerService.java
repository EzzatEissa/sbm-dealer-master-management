package com.sbm.dealer.service;

import java.util.List;

import com.sbm.dealer.common.exception.GenericExceptionMapper;
import com.sbm.dealer.dto.DealerDto;
import com.sbm.dealer.dto.PageResultDto;

public interface DealerService {

    DealerDto getDealerById(Long id) throws GenericExceptionMapper;

    PageResultDto getAllDealers(int page, int size) ;

    DealerDto saveDealer(DealerDto dealerDto) throws GenericExceptionMapper;

    DealerDto updateDealer(DealerDto dealerDto) throws GenericExceptionMapper;

    void deleteDealer(Long id) throws GenericExceptionMapper;
    
    List<DealerDto> getDealersByFields(DealerDto dealerDto) throws GenericExceptionMapper;
}
