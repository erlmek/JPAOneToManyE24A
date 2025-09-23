package org.example.jpaonetomanye24a.controller;

import org.example.jpaonetomanye24a.model.Kommune;
import org.example.jpaonetomanye24a.model.Region;
import org.example.jpaonetomanye24a.service.ApiServiceGetKommuner;
import org.example.jpaonetomanye24a.service.ApiServiceGetRegioner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tool")
public class ToolRestController {

    @Autowired
    ApiServiceGetRegioner apiServiceGetRegioner;

    @Autowired
    ApiServiceGetKommuner apiServiceGetKommuner;

    @GetMapping("getregioner")
    public List<Region> getRegioner() {
        List<Region> lstRegioner = apiServiceGetRegioner.getRegioner();
        return lstRegioner;
    }

    @GetMapping("getkommuner")
    public List<Kommune> getKommuner() {
        List<Kommune> lstKommuner = apiServiceGetKommuner.getKommuner();
        return lstKommuner;
    }




}
