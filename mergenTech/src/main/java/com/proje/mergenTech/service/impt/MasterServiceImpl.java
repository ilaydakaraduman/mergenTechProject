package com.proje.mergenTech.service.impt;

import com.proje.mergenTech.entity.Filtre;
import com.proje.mergenTech.entity.Master;
import com.proje.mergenTech.entity.Throwable;
import com.proje.mergenTech.repository.MasterRepository;
import com.proje.mergenTech.repository.ThRepository;
import com.proje.mergenTech.service.MasterService;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MasterServiceImpl implements MasterService {
    private final MasterRepository masterRepository;
    private final ThRepository thRepository;


    @PersistenceUnit
   private EntityManagerFactory entityManagerFactory ;

    @Override
    public Master createMaster(Master master) {

        master.getThrowables().forEach(throwable -> throwable.setMaster(master));
        return masterRepository.save(master);
    }

    @Override
    public List<Master> getMasters() {
        EntityManager eManager = entityManagerFactory.createEntityManager();

        Query q = eManager.createQuery("select s from Master s");
        List<Master> supportersList = new ArrayList<Master>();
        supportersList = q.getResultList();
        return supportersList;

        //return masterRepository.findAll();
    }

    @Override
    public Master getMaster(Long id) {
        Master master= masterRepository.findByIds(id);
        if (master.getM_Id()!=null){
            return masterRepository.findByIds(id);
        }

        throw new RuntimeException("Kullanici bulunamadı");
    }

    @Override
    public List<Master> getMastersf(Filtre filtre) throws ServiceException{

        exceptionOrnek(filtre);
        EntityManager eManager = entityManagerFactory.createEntityManager();
        String query="select s from Master s WHERE 0=0 ";
        if (filtre.getHastaneAdi()!=null){

                query+=" AND s.hastaneAdi= :hastaneadi ";

        }
        if (filtre.getKullaniciKodu()!=null){

                query+=" AND s.kullaniciKodu= :kullanicikodu ";

        }
        if (filtre.getIlkTarih()!=null){

                    query+=" AND s.zaman > :ilktarih AND s.zaman < :sontarih";
        }

        Query q = eManager.createQuery(query);
        if (filtre.getHastaneAdi()!=null){
            q.setParameter("hastaneadi",filtre.getHastaneAdi());
        }
        if (filtre.getKullaniciKodu()!=null){
            q.setParameter("kullanicikodu",filtre.getKullaniciKodu());
        }
        if (filtre.getIlkTarih()!=null){
            if (filtre.getSonTarih()!=null) {
                q.setParameter("ilktarih", filtre.getIlkTarih());
                q.setParameter("sontarih", filtre.getSonTarih());
            }
        }

        List<Master> supportersList = new ArrayList<Master>();
        supportersList = q.getResultList();

        return supportersList;
    }
    @Override
    public void exceptionOrnek(Filtre filtre) throws ServiceException {

        if(filtre.getIlkTarih()!=null && filtre.getSonTarih()!=null){
            if (filtre.getIlkTarih().compareTo(filtre.getSonTarih())>0)
            {
                throw new ServiceException("İlk tarih son tarihten ileri bir zaman diliminde girilemez");
            }
        }
        if(filtre.getHastaneAdi()==null || filtre.getHastaneAdi().isEmpty() || filtre.getHastaneAdi().isBlank()){
            throw new ServiceException("Bu Değer 'HASTANE ADI' boş gönderilemez");
        }

    }

}
