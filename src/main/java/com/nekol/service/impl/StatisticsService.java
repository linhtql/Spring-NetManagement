package com.nekol.service.impl;

import com.nekol.dto.StatisticsDTO;
import com.nekol.repository.StatisticsRepository;
import com.nekol.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class StatisticsService implements StatisticService {

    @Autowired
    StatisticsRepository statisticsRepository;


    @Override
    public List<StatisticsDTO> statistics() {
        List<StatisticsDTO> statistics = new ArrayList<>();
        StatisticsDTO custom;
        for (Object[] e : statisticsRepository.statistics()) {
            custom = new StatisticsDTO();

            custom.setCustomerId(e[0].toString());
            custom.setCustomerName(e[1].toString());

            if (e[2] != null) {
                custom.setDeviceId(e[2].toString());
                custom.setLocation(e[3].toString());
                custom.setStatus(e[4].toString());
                custom.setDayBeganDevice(LocalDate.parse(e[5].toString()));
                custom.setTimeBeganDevice(LocalTime.parse(e[6].toString()));
                custom.setTimeOfUse(Double.parseDouble(e[7].toString()));
            }

            if (e[8] != null) {
                custom.setServiceId(e[8].toString());
                custom.setDayBeganService(LocalDate.parse(e[9].toString()));
                custom.setTimeBeganService(LocalTime.parse(e[10].toString()));
                custom.setAmount(Integer.parseInt(e[11].toString()));
                custom.setTotal(Double.parseDouble(e[12].toString()));
            }
            statistics.add(custom);
        }


        return statistics;
    }

//    @Override
//    public Page<StatisticsDTO> statistics(int pageId) {
//        return statisticsRepository.statistics(PageRequest.of(--pageId, 10));
//    }
}

