package com.calculator.price.repository;

import com.calculator.price.model.ItemInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface ItemInfoRepository extends JpaRepository<ItemInfo,String> {
}
