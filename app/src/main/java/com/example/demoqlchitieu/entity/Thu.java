package com.example.demoqlchitieu.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Thu {
    @PrimaryKey(autoGenerate = true)
    public int tid;
    @ColumnInfo(name = "ltid")
    public int ltid;
    @ColumnInfo(name = "ten")
    public int ten;
    @ColumnInfo(name = "sotien")
    public int sotien;
    @ColumnInfo(name = "ghichu")
    public int ghichu;

}
