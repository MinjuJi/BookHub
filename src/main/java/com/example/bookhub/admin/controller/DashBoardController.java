package com.example.bookhub.admin.controller;

import com.example.bookhub.admin.dto.DayTotalDto;
import org.springframework.ui.Model;;
import com.example.bookhub.admin.service.DashBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class DashBoardController {

    private final DashBoardService dashBoardService;
    private final RestTemplate restTemplate;

    // 총 회원 수
    @RequestMapping("/allCustomer.do")
    public @ResponseBody Map<String, Object> getAllUserCnt(Model model){
        int cnt = dashBoardService.getAllUserCnt();

        Map<String, Object> map = new HashMap<>();
        map.put("allCustomer", cnt);
        model.addAttribute("allCustomer", cnt);
        return map;

    }

    // 총 책의 권 수
    @RequestMapping("/getAllBookCnt.do")
    public @ResponseBody Map<String, Object> getAllBookCnt(Model model){
        int cnt = dashBoardService.getAllBookCnt();
        Map<String, Object> map = new HashMap<>();
        map.put("allBook", cnt);
        model.addAttribute("allBook", cnt);
        return map;
    }

    // 최근 7일치의 매출 현황
    @RequestMapping("/getTotalYesterday.do")
    public @ResponseBody List<DayTotalDto> getTotalYesterday(Model model){
        return dashBoardService.getTotalDate();
    }

    @RequestMapping("/noAnswerCnt.do")
    public @ResponseBody Map<String, Object> getUserCnt(Model model){
        int cnt = dashBoardService.noAnswerCnt();
        Map<String, Object> map = new HashMap<>();
        map.put("noAnswer", cnt);
        model.addAttribute("noAnswer", cnt);
        return map;
    }
}
