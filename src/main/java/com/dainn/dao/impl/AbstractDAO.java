package com.dainn.dao.impl;

import com.dainn.dao.GenericDAO;
import com.dainn.mapper.IRowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AbstractDAO<T> implements GenericDAO<T> {

    ResourceBundle resourceBundle = ResourceBundle.getBundle("db");

    public Connection getConnection(){
        try {
            Class.forName(resourceBundle.getString("driverName"));
            String url = resourceBundle.getString("url");
            String username = resourceBundle.getString("username");
            String password = resourceBundle.getString("password");
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<T> query(String sql, IRowMapper<T> rowMapper, Object... parameters) {
        List<T> result = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = this.getConnection();
            ps = connection.prepareStatement(sql);
            setParameter(ps, parameters);
            rs = ps.executeQuery();
            while (rs.next()){
                result.add(rowMapper.mapRow(rs));
            }
            return result;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Integer insert(String sql, Object... parameters) {
        Integer id = null;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = this.getConnection();
            connection.setAutoCommit(false);
            ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            setParameter(ps, parameters);
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs.next()){
                id = rs.getInt(1);
            }
            connection.commit();
            return id;
        } catch (SQLException e){
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return null;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(String sql, Object... parameters) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = this.getConnection();
            connection.setAutoCommit(false);
            ps = connection.prepareStatement(sql);
            setParameter(ps, parameters);
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e){
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void setParameter(PreparedStatement ps, Object... parameters){
        try {
            for (int i = 0; i < parameters.length; i++){
                Object parameter = parameters[i];
                int index = i + 1;
                if (parameter instanceof String){
                    ps.setString(index, (String) parameter);
                } else if (parameter instanceof Integer){
                    ps.setInt(index, (Integer) parameter);
                } else if (parameter instanceof Timestamp){
                    ps.setTimestamp(index, (Timestamp) parameter);
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
