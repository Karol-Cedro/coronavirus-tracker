package kcedro.coronavirustracker.controllers;

import kcedro.coronavirustracker.models.LocationStats;
import kcedro.coronavirustracker.services.CoronaVirusDataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CoronaVirusDataServiceImpl coronaVirusDataService;

    @GetMapping("/")
    public String home(Model model){
        List<LocationStats> allStats = coronaVirusDataService.fetchAllStats();
        int totalReportedCases = allStats.stream().mapToInt(stat-> stat.getLatestTotalCases()).sum();
        int totalNewCases = allStats.stream().mapToInt(stat-> stat.getDiffFromPrevDay()).sum();
        model.addAttribute("locationStats",allStats);
        model.addAttribute("totalReportedCases",totalReportedCases);
        model.addAttribute("totalNewCases",totalNewCases);

        return "home";
    }
}
