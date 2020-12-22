package com.feaa.project.main.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name= "METADATA_TABLE")
public class TableMetadata implements Serializable {

    @Id
    @Column(name="ID_ROW", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRow;

    @Column(name="TABLE_NAME")
    String tableName;

    @Column(name="COLUMN_NAME")
    String columnName;

    public TableMetadata () {}

    public TableMetadata(String tableName, String columnName) {
        this.tableName = tableName;
        this.columnName = columnName;
    }

    public Integer getIdRow() {
        return idRow;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public String toString() {
        return "TableMetadata{" +
                "tableName='" + tableName + '\'' +
                ", columnName='" + columnName + '\'' +
                '}';
    }
}
