package sample.service;

import sample.model.Data;

import java.util.List;

public class DataService {
    private List<Data> dataList;
    public DataService(List<Data> dataList) {
        this.dataList = dataList;
    }
}
