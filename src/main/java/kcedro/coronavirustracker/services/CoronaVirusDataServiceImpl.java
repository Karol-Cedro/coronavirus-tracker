package kcedro.coronavirustracker.services;

import kcedro.coronavirustracker.models.LocationStats;
import kcedro.coronavirustracker.repositories.CoronaVirusDataRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

@Service
public class CoronaVirusDataServiceImpl implements CoronaVirusDataService{

    @Autowired
    CoronaVirusDataRepository coronaVirusDataRepository;

    @Override
    public void fetchVirusData() throws IOException, InterruptedException {
        coronaVirusDataRepository.getVirusData();
    }

    @Override
    public List<LocationStats> fetchAllStats() {
        return coronaVirusDataRepository.getAllStats();
    }
}
