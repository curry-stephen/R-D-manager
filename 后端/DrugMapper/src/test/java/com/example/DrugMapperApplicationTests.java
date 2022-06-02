package com.example;
import cn.hutool.*;
import cn.hutool.core.date.DateUnit;
import com.example.mapper.SupplierMapper;
import com.example.server.IOwinfoService;
import com.example.utils.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class DrugMapperApplicationTests {
    @Value("${server.port}")
    private String port;
    @Autowired
    private IOwinfoService iOwinfoService;
    @Autowired
    private SupplierMapper supplierMapper;
    @Test
    void contextLoads() {
        System.out.println("端口:"+port);
    }
    @Test
    void querytupianTest(){
        String tupian = iOwinfoService.QueryTupian("云南白药");
        System.out.println(tupian);
    }
    @Test
    void QueryAllNameTest(){
        String[] strings = supplierMapper.QueryAllName();
        for(String s:strings){
            System.out.print(s);
        }
    }
    @Test
    void TimeTest(){
//        Owinfo byId = iOwinfoService.getById("1");
//        String ctime = byId.getCtime();
//        System.out.println(ctime);
        String dattime="2022年02月09日 11时57分55秒";
        Date date = DateUtil.StringToDate(dattime);
        Date date1 = new Date();
        long between = cn.hutool.core.date.DateUtil.between(date1, date, DateUnit.DAY);
        long datacha=date1.getTime()-date.getTime();
        System.out.println(datacha);
        System.out.println(between);
    }
}
