package unrn.mongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unrn.mongo.api.PageServicio;
import unrn.mongo.modelo.dto.PageDTO;

import java.util.Collections;
import java.util.List;
@RestController
@RequestMapping("/pages")
public class PageController {

    @Autowired
    private PageServicio pageService;

    @GetMapping("/{id}")
    List<PageDTO> findPageById(@PathVariable String id){
        return Collections.singletonList(this.pageService.findPage(id));
    }

}


