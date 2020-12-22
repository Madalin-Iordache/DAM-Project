package com.feaa.project.main.repository;

import com.feaa.project.main.model.TableMetadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TableMetadataRepository extends JpaRepository<TableMetadata, Integer> {

    @Query(value = "Select COLUMN_NAME_LOGICAL from METADATA_TABLE WHERE TABLE_NAME = ?1", nativeQuery = true)
    List<String> getClientColumnByTable(String tableName);

}
