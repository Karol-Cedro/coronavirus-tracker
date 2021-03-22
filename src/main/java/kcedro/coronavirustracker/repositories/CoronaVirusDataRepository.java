package kcedro.coronavirustracker.repositories;

import kcedro.coronavirustracker.models.LocationStats;

import java.io.IOException;
import java.util.List;

public interface CoronaVirusDataRepository {

    void getVirusData() throws IOException, InterruptedException;

    List<LocationStats> getAllStats();
}
