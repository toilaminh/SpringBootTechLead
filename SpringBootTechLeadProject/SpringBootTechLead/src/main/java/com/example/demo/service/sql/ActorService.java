package com.example.demo.service.sql;

import com.example.demo.model.dto.sql.level1.ActorDto_Ex1_1;
import com.example.demo.model.dto.sql.level1.ActorDto_Ex7_1;
import com.example.demo.model.dto.sql.level2.ActorDto_Ex4_2;
import com.example.demo.model.dto.sql.level2.ActorDto_Ex6_2;
import com.example.demo.model.dto.sql.level2.ActorDto_Ex7_2;
import com.example.demo.model.dto.sql.level3.ActorDto_Ex10_3;
import com.example.demo.model.dto.sql.level3.ActorDto_Ex1_3;
import com.example.demo.model.dto.sql.level3.ActorDto_Ex2_3;
import com.example.demo.model.dto.sql.level3.ActorDto_Ex6_3;
import com.example.demo.model.entity.Actor;
import com.example.demo.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActorService {
    @Autowired
    ActorRepository actorRepository;

    //Level1
    public List<ActorDto_Ex1_1> findAllFirstNameAndLastName(){
        List<ActorDto_Ex1_1> actorDtoLevel1Ex1s = new ArrayList<>();
        for(Actor a : actorRepository.findAll()){
            ActorDto_Ex1_1 t = new ActorDto_Ex1_1(a.getFirstName(), a.getLastName());
            actorDtoLevel1Ex1s.add(t);
        }
        return actorDtoLevel1Ex1s;
//        return actorRepository.findAllFirstnameAndLastname();
    }

    public List<ActorDto_Ex7_1> findAllActorsWhoAppearedMoreThan20Films(){
        return actorRepository.findAllActorsWhoAppearedMoreThan20Films();
    }

    //Level2
    public List<ActorDto_Ex4_2> findAllActorsWhoAppearedAtLeastOnceInEachCategory(){
        return actorRepository.findAllActorsWhoAppearedAtLeastOnceInEachCategory();
    }

    public List<ActorDto_Ex6_2> totalRevenueGeneratedByEachActor(){
        return actorRepository.totalRevenueGeneratedByEachActor();
    }

    public List<ActorDto_Ex7_2> findActorsWhoAppearedInRButG(){
        return actorRepository.findActorsWhoAppearedInRButG();
    }

    //Level3
    public List<ActorDto_Ex1_3> avgRentalDuration(){
        return actorRepository.avgRentalDuration();
    }

    public List<ActorDto_Ex2_3> findActorsAppearedIn2HoursFilmRButG(){
        return actorRepository.findActorsAppearedIn2HoursFilmRButG();
    }

    public List<ActorDto_Ex6_3> allActorsWhoAppearedWithEveryOtherActorsAtLeastOnce(){
        return actorRepository.allActorsWhoAppearedWithEveryOtherActorsAtLeastOnce();
    }

    public List<ActorDto_Ex10_3> findActorAppearedInPG13MoreThan2AndRMoreThan1_5(){
        return actorRepository.findActorAppearedInPG13MoreThan2AndRMoreThan1_5();
    }
}
