package com.example.demo.controller.core4;

import com.example.demo.model.dto.core4.EmpData;
import com.example.demo.service.core4.ServiceJV4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping({"/account/user/jv4", "/account/admin/jv4"})
public class CoreJava4 {
    @Autowired
    ServiceJV4 serviceJV4;

    @PostMapping(value = "/readfile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public List<EmpData> jvcore4(@RequestParam("f") MultipartFile f ){
        return serviceJV4.readEXcel(f);
    }
}
