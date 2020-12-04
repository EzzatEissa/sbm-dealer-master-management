package com.sbm.dealer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sbm.dealer.dto.DealerDto;
import com.sbm.dealer.model.Dealer;

@Repository
public interface DealerRepo extends JpaRepository<Dealer, Long> {

	@Query("select distinct (dlr) from Dealer dlr "
			+ " where ( coalesce(:#{#dealerDto.dealerName}, null) is null or  dlr.dealerName = :#{#dealerDto.dealerName})"
			+ " and ( coalesce(:#{#dealerDto.dealerCode}, null) is null or  dlr.dealerCode = :#{#dealerDto.dealerCode})"
			+ " and ( coalesce(:#{#dealerDto.preferredDealer}, null) is null or  dlr.preferredDealer = :#{#dealerDto.preferredDealer})"
			+ " and ( coalesce(:#{#dealerDto.salesPartner}, null) is null or  dlr.salesPartner = :#{#dealerDto.salesPartner})"
			+ " and ( coalesce(:#{#dealerDto.usedCategory}, null) is null or  dlr.usedCategory = :#{#dealerDto.usedCategory})")
	List<Dealer> getDealersByFields(@Param("dealerDto") DealerDto dealerDto);

}