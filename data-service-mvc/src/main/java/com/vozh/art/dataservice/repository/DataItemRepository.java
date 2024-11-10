package com.vozh.art.dataservice.repository;

import com.vozh.art.dataservice.entity.DataItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataItemRepository extends JpaRepository<DataItem, Long> {
}
