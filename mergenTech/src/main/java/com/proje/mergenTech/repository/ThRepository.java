package com.proje.mergenTech.repository;

import com.proje.mergenTech.entity.Master;
import com.proje.mergenTech.entity.Throwable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ThRepository extends JpaRepository<Master,Long> {


}
