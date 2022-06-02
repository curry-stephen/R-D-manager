package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.entity.Bill;
import com.example.server.IBillService;
import com.example.server.IDruginfoService;
import com.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/bill")
public class BillController {
    @Autowired
    IBillService billService;
    @Autowired
    IDruginfoService druginfoService;
    //添加
    @PostMapping
    public Result AddBill(@RequestBody Bill bill){
        String tupian = druginfoService.QueryTupian(bill.getDrugname());
        bill.setTupian(tupian);
        bill.setCreatetime(new Date());
        boolean addbill = billService.updateLog(bill, "addbill", bill.getUsername());
        if (addbill){
            System.out.println("addbill日志");
        }
        boolean save = billService.save(bill);
        return new Result(save,save?"添加成功":"添加失败",null);
    }
    //修改
    @PutMapping
    public Result UpdateBill(@RequestBody Bill bill){
        String tupian = druginfoService.QueryTupian(bill.getDrugname());
        bill.setTupian(tupian);
        bill.setCreatetime(new Date());
        boolean updatebill = billService.updateLog(bill, "updatebill", bill.getUsername());
        if (updatebill){
            System.out.println("修改bill日志");
        }
        boolean update = billService.updateById(bill);
        return new Result(update,update?"修改成功":"修改失败",null);
    }
    //删除
    @DeleteMapping("{id}/{username}")
    public Result DeleteBill(@PathVariable Integer id,@PathVariable String username){
        Bill bill = billService.QueryOneById(id);
        boolean deletebill = billService.updateLog(bill, "deletebill", username);
        if (deletebill){
            System.out.println("删除bill日志");
        }
        boolean remove = billService.removeById(id);
        return new Result(remove,remove?"删除成功":"删除失败",null);
    }
    //分页查询
    @GetMapping("{pagenum}/{pagesize}")
    public Result QueryPage(@PathVariable Integer pagenum,@PathVariable Integer pagesize){
        IPage<Bill> iPage = billService.QueryPage(pagenum, pagesize, null);
        return new Result(!iPage.getRecords().isEmpty(),!iPage.getRecords().isEmpty()?"查询成功":"没有找到数据",iPage);
    }
    //分页条件查询
    @GetMapping("{pagenum}/{pagesize}/{search}")
    public Result QueryPageSelect(@PathVariable Integer pagenum,@PathVariable Integer pagesize,@PathVariable String search){
        LambdaQueryWrapper<Bill> wrapper = Wrappers.<Bill>lambdaQuery();
        wrapper.like(search!=null,Bill::getDrugname,search);
        IPage<Bill> iPage = billService.QueryPage(pagenum, pagesize, wrapper);
        return new Result(!iPage.getRecords().isEmpty(),!iPage.getRecords().isEmpty()?"查询成功":"没有找到数据",iPage);
    }
}
