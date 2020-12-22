package com.feaa.project.main.service;

import com.feaa.project.main.repository.TableMetadataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetadataServiceImpl implements MetadataService {

    @Autowired
    TableMetadataRepository tableMetadataRepository;

    @Override
    public List<String> getTableColumns(String tableName) {
        return tableMetadataRepository.getClientColumnByTable(tableName);
    }
}
