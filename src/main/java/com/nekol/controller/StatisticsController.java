package com.nekol.controller;

import com.nekol.dto.StatisticsDTO;
import com.nekol.service.StatisticService;
import com.nekol.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class StatisticsController {

    @Autowired
    StatisticService statisticService;

    @GetMapping(value = {"/statistic", "/statistic/page={pageId}"})
    public String statistics(ModelMap modelMap, @PathVariable(required = false) Integer pageId) {

        if(pageId == null) {
            pageId = 1;
        }

        List<StatisticsDTO> results ;
        List<List<StatisticsDTO>> listPages = PageUtil.getPages(statisticService.statistics(), 10);
        results = listPages.get(--pageId);

        modelMap.put("statistics", results);
        modelMap.put("totalPage", listPages.size());

        return "statistics/statistics";
    }
}
