package com.proje.mergenTech.repository;

import com.proje.mergenTech.entity.Master;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MasterRepository extends JpaRepository<Master,Long> {

    @Query(value = "SELECT t FROM Master t " )
    List<Master> findAll();

    @Query(value = "SELECT t FROM Master t WHERE t.m_Id=:id" )
    Master findByIds(@Param("id") Long id);
}
