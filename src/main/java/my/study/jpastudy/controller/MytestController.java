package my.study.jpastudy.controller;

import lombok.RequiredArgsConstructor;
import my.study.jpastudy.service.MytestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jpa-study")
public class MytestController {

    private final MytestService mytestService;

    @GetMapping(value = "/insert")
    public String insertBoard(){

        mytestService.insertBoard();
        return "MytestController insertBoard";
    }

    @GetMapping(value = "/list")
    public String listBoard(){

        mytestService.listBoard();
        return "MytestController listBoard";
    }
}
