package com.sbm.dealer.repository;

import com.sbm.dealer.model.Dealer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealerRepo extends JpaRepository<Dealer, Long>{

}
