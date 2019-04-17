package com.sonydafa.SQLfunctionProcedure;

import com.mysql.cj.MysqlType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;


@Repository
public class SqlFunctionAndProcedure {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void call_sql_function(){
        String sql="select deal_id,money(amount,expense)as money from deal";
        SqlRowSet rw= jdbcTemplate.queryForRowSet(sql);
        while(rw.next()){
            String deal_id=rw.getString("deal_id");
            double amount=rw.getDouble("money");
            System.out.println("deal id:"+deal_id+"\tamount:"+amount);
        }
    }
    public void call_sql_procedure() throws Exception{
        DataSource ds=jdbcTemplate.getDataSource();
        Connection connection=ds.getConnection();
        CallableStatement cs=connection.prepareCall("{call count_items(?)}");
        //输入一个参数，返回输入的参数+统计的deal里的内容
        cs.setInt(1,100);
        cs.registerOutParameter(1, MysqlType.FIELD_TYPE_INT24);
        cs.execute();
        int num=cs.getInt(1);
        System.out.println("procedure return: "+num);
        connection.close();
    }
}
