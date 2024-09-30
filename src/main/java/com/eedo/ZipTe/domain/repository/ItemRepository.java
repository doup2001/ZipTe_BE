package com.eedo.ZipTe.domain.repository;

import com.eedo.ZipTe.domain.entity.item.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ItemRepository extends JpaRepository<Item,Long> {

    @Query("select i from Item i where i.delFlag = false")
    Page<Item> selectList(Pageable pageable);
}
