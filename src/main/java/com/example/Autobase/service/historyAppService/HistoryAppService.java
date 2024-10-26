package com.example.Autobase.service.historyAppService;

import com.example.Autobase.model.HistoryApp;

import java.util.List;

public interface HistoryAppService {
    void save(HistoryApp historyApp);
    int[] saveHistoryAppsList(List<HistoryApp> historyApps);
    void update(HistoryApp historyApp);
    void delete(HistoryApp historyApp);
    List<HistoryApp> findAll();
    void deleteAll();
}
