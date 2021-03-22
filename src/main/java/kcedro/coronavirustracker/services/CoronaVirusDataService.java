package kcedro.coronavirustracker.services;

import kcedro.coronavirustracker.models.LocationStats;

import java.io.IOException;
import java.util.List;

public interface CoronaVirusDataService {

     void fetchVirusData() throws IOException, InterruptedException;

    List<LocationStats> fetchAllStats();
}
