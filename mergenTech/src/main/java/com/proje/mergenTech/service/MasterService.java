package com.proje.mergenTech.service;

import com.proje.mergenTech.entity.Filtre;
import com.proje.mergenTech.entity.Master;
import com.proje.mergenTech.entity.Throwable;
import org.hibernate.service.spi.ServiceException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


public interface MasterService {
    Master createMaster( Master master);
    List<Master> getMasters();
    Master getMaster(Long id);
    List<Master> getMastersf(Filtre filtre);
    void exceptionOrnek(Filtre filtre) throws ServiceException;
}
