package com.ssmvue.security;

import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResourceMapping extends MappingSqlQuery{

    /**
     * @param ds 数据源
     * @param resourceQuery 查询资源的sql
     */
    public ResourceMapping(DataSource ds, String resourceQuery) {
        super(ds, resourceQuery);
        compile();
    }

    /**
     *
     * @param rs 结果
     * @param rowNum
     * @return
     * @throws SQLException
     */
    @Override
    protected Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        String url = rs.getString(1);
        String role = rs.getString(2);
        Resource resource = new Resource(url, role);
        return resource;
    }
}