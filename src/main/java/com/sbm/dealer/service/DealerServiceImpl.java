package com.sbm.dealer.service;

import com.sbm.dealer.common.consts.AppConstants;
import com.sbm.dealer.common.exception.GenericExceptionMapper;
import com.sbm.dealer.common.utils.MapperHelper;
import com.sbm.dealer.dto.DealerDto;
import com.sbm.dealer.model.Dealer;
import com.sbm.dealer.repository.DealerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DealerServiceImpl implements DealerService {

    @Autowired
    private DealerRepo dealerRepo;

    @Autowired
    private MapperHelper mapperHelper;

    private final String DEALER_NOT_FOUND = "Dealer_Not_Found";

    @Override
    public DealerDto getDealerById(Long id) throws GenericExceptionMapper{
        Optional<Dealer> dealer = dealerRepo.findById(id);
        if(dealer.isPresent())
            return mapperHelper.transform(dealer.get(), DealerDto.class);
        else
            throw new GenericExceptionMapper(DEALER_NOT_FOUND, AppConstants.HTTP_CODE_NOT_FOUND);
    }

    @Override
    public List<DealerDto> getAllDealers() {
        return mapperHelper.transform(dealerRepo.findAll(), DealerDto.class);
    }

    @Override
    public DealerDto saveDealer(DealerDto dealerDto) throws GenericExceptionMapper{
        try{
            return mapperHelper.transform(dealerRepo.save(mapperHelper.transform(dealerDto, Dealer.class)), DealerDto.class);
        } catch(Exception ex){
            throw new GenericExceptionMapper(ex.getMessage(), AppConstants.HTTP_CODE_SEVER_ERROR);
        }

    }

    @Override
    public DealerDto updateDealer(DealerDto dealerDto) throws GenericExceptionMapper{
        Optional<Dealer> dealer = dealerRepo.findById(dealerDto.getId());

        if(dealer.isPresent()){
            try {
                mapperHelper.partialMap(dealerDto, dealer.get());
                return mapperHelper.transform(dealerRepo.save(dealer.get()), DealerDto.class);
            } catch (Exception ex){
                throw new GenericExceptionMapper(ex.getMessage(), AppConstants.HTTP_CODE_SEVER_ERROR);
            }
        } else
            throw new GenericExceptionMapper(DEALER_NOT_FOUND, AppConstants.HTTP_CODE_NOT_FOUND);

    }

    @Override
    public void deleteDealer(Long id) throws GenericExceptionMapper{
        Optional<Dealer> dealer = dealerRepo.findById(id);
        if(dealer.isPresent()){
            try {
                dealerRepo.delete(dealer.get());
            } catch (Exception ex) {
                throw new GenericExceptionMapper(ex.getMessage(), AppConstants.HTTP_CODE_SEVER_ERROR);
            }
        }
        else
            throw new GenericExceptionMapper(DEALER_NOT_FOUND, AppConstants.HTTP_CODE_NOT_FOUND);
    }
}