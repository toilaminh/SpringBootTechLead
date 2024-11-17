package com.example.demo.service.sql;

import com.example.demo.model.dto.sql.level1.CustomerDto_Ex5_1;
import com.example.demo.model.dto.sql.level2.CustomerDto_Ex1_2;
import com.example.demo.model.dto.sql.level2.CustomerDto_Ex2_2;
import com.example.demo.model.dto.sql.level2.CustomerDto_Ex5_2;
import com.example.demo.model.dto.sql.level2.CustomerDto_Ex9_2;
import com.example.demo.model.dto.sql.level3.CustomerDto_Ex3_3;
import com.example.demo.model.dto.sql.level3.CustomerDto_Ex4_3;
import com.example.demo.model.dto.sql.level3.CustomerDto_Ex7_3;
import com.example.demo.model.dto.sql.level3.CustomerDto_Ex9_3;
import com.example.demo.model.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    //Level1
    public List<CustomerDto_Ex5_1> findAllCustomerWhoRentedFilmIn2022(){
        return customerRepository.findAllCustomerWhoRentedFilmIn2022(LocalDate.parse("2005-05-01"),LocalDate.parse("2005-05-31"));
    }

    //Level2
    public List<CustomerDto_Ex1_2> find10CustomerWhoSpentMostMoney(){
        return customerRepository.find10CustomerWhoSpentMostMoney();
    }

    public List<CustomerDto_Ex2_2> findCustomerRentedAllCategories(){
        return customerRepository.findCustomerRentedAllCategories();
    }

    public List<CustomerDto_Ex5_2> findCustomersRentedSameFilmMoreThanOnce(){
        return customerRepository.findCustomersRentedSameFilmMoreThanOnce();
    }

    public List<CustomerDto_Ex9_2> findCustomersRentedFilmFromCategoryThatNeverRentedBefore(){
        return customerRepository.findCustomersRentedFilmFromCategoryThatNeverRentedBefore();
    }

    //Level3
    public List<CustomerDto_Ex3_3> findAllCustomersRentedMoreThan10Films(){
        return customerRepository.findAllCustomersRentedMoreThan10Films();
    }

    public List<CustomerDto_Ex4_3> allCustomersRentedAllFilmsFromOneCategory(){
        return customerRepository.allCustomersRentedAllFilmsFromOneCategory();
    }

    public List<CustomerDto_Ex7_3> findAllCustomerRentedAtLeastOnceFilmFromEveryCategory(){
        return customerRepository.findAllCustomerRentedAtLeastOnceFilmFromEveryCategory();
    }

    public List<CustomerDto_Ex9_3> findCustomersRentedFilmFromCategoryThatNeverRentedBeforeAndNeverRentedAFilmLonger3Hours(){
        return customerRepository.findCustomersRentedFilmFromCategoryThatNeverRentedBeforeAndNeverRentedAFilmLonger3Hours();
    }

    // Level4
    @Transactional
    public void updateEmailOfAllCustomersHorror102002(){
        List<Customer> customers = customerRepository.listCustomersUpdate4();
        customers.forEach(f -> f.setEmail("horrorlover" + f.getEmail()));
        customerRepository.saveAll(customers);
    }


}
