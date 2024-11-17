package com.example.demo.service.sql;

import com.example.demo.model.dto.sql.level1.FilmDto_Ex2_1;
import com.example.demo.model.dto.sql.level1.FilmDto_Ex3_1;
import com.example.demo.model.dto.sql.level1.FilmDto_Ex8_1;
import com.example.demo.model.dto.sql.level2.FilmDto_Ex10_2;
import com.example.demo.model.dto.sql.level2.FilmDto_Ex3_2;
import com.example.demo.model.dto.sql.level2.FilmDto_Ex8_2;
import com.example.demo.model.dto.sql.level3.FilmDto_Ex5_3;
import com.example.demo.model.dto.sql.level3.FilmDto_Ex8_3;
import com.example.demo.model.entity.Film;
import com.example.demo.repository.FilmRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmService {
    @Autowired
    FilmRepository filmRepository;

    //Level1
    public List<FilmDto_Ex2_1> findAllTitle(){
        List<FilmDto_Ex2_1> filmDtoLevel1Ex2s = new ArrayList<>();
        for(Film a : filmRepository.findAllTitle()){
            FilmDto_Ex2_1 filmDtoLevel1Ex2 = new FilmDto_Ex2_1();
            filmDtoLevel1Ex2.setTitle(a.getTitle());
//            filmDto.setRating(a.getRating());
            filmDtoLevel1Ex2.setRentalRate(a.getRentalRate());
            filmDtoLevel1Ex2.setReplacementCost(a.getReplacementCost());
            filmDtoLevel1Ex2s.add(filmDtoLevel1Ex2);
        }
        return filmDtoLevel1Ex2s;
    }

    public List<FilmDto_Ex3_1> findTop5MostRentedFilms(){
        return filmRepository.findTop5MostRentedFilms();
    }

    public List<FilmDto_Ex8_1> findAllTitleRatingPG13And120sLength(){
        return filmRepository.findAllTitleRatingPG13And120sLength();
    }

    //Level2
    public List<FilmDto_Ex3_2> findFilmTitleWhichRentedButNeverReturned(){
        return filmRepository.findFilmTitleWhichRentedButNeverReturned();
    }

    public List<FilmDto_Ex8_2> findAllFilmsWhichRentedMoreThan50(){
        return filmRepository.findAllFilmsWhichRentedMoreThan50();
    }

    public List<FilmDto_Ex10_2> findAllFilmRentedByAllCustomersButAction(){
        return filmRepository.findAllFilmRentedByAllCustomersButAction();
    }

    //Level3
    public List<FilmDto_Ex5_3> allFilmsWasRentedByOneCustomerMoreThanOnceInSingleDay(){
        return filmRepository.allFilmsWasRentedByOneCustomerMoreThanOnceInSingleDay();
    }

    public List<FilmDto_Ex8_3> findAllFilmsWereRentedMoreThan100TimesButNotByCustomersWhoRentedAnyFilmG(){
        return filmRepository.findAllFilmsWereRentedMoreThan100TimesButNotByCustomersWhoRentedAnyFilmG();
    }

    //Level4
    @Transactional
    public void updateRentalRateAllFilmsWereRentedMoreThan100sTo110(){
        List<Film> films = filmRepository.listFilmsUpdate1();
        films.forEach(f -> f.setRentalRate(f.getRentalRate()*1.1));
        filmRepository.saveAll(films);
    }

    @Transactional
    public void updateRentalDurationAllFilmsWereRentedMoreThan5sTo105(){
        List<Film> films = filmRepository.listFilmsUpdate2();
        films.forEach(f -> f.setRentalRate(f.getRentalDuration()*1.05));
        filmRepository.saveAll(films);
    }

    @Transactional
    public void updateRateAllFilmsWereReleasedBefore2005(){
        List<Film> films = filmRepository.listFilmsUpdate3();
        films.forEach(f -> f.setRentalRate(f.getRentalRate()*1.2));
        filmRepository.saveAll(films);
    }

    @Transactional
    public void updateRentelRateAllFilmsWereRentedMoreThan10s(){
        List<Film> films = filmRepository.listFilmsUpdate5();
        for(Film f : films){
            if (f.getRentalRate()<4 && f.getRentalRate()*1.05<4){
                f.setRentalRate(f.getRentalRate()*1.05);
            } else if (f.getRentalRate()<4 && f.getRentalRate()*1.05>=4) {
                f.setRentalRate(4.0);
            }
        }
        filmRepository.saveAll(films);
    }

    @Transactional
    public void updateRentalRateAllFilmsWhichHadRatingPG13AndLength120s(){
        List<Film> films = filmRepository.listFilmsUpdate6();
        films.forEach(f -> f.setRentalRate(3.5));
        filmRepository.saveAll(films);
    }

    @Transactional
    public void updateRentalDurationEqualLength(){
        List<Film> films = filmRepository.listFilmsUpdate7();
        films.forEach(f -> f.setRentalDuration(f.getLength()));
        filmRepository.saveAll(films);
    }

    @Transactional
    public void updateRentalRate2007sComedy(){
        List<Film> films = filmRepository.listFilmsUpdate9();
        films.forEach(f -> f.setRentalRate(f.getRentalRate()*0.85));
        filmRepository.saveAll(films);
    }

    @Transactional
    public void updateRentalRateEqualLengths60G(){
        List<Film> films = filmRepository.listFilmsUpdate10();
        films.forEach(f -> f.setRentalRate(1.5));
        filmRepository.saveAll(films);
    }
}
