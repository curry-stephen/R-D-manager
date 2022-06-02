package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.entity.Saleinfo;
import com.example.entity.Supplier;
import com.example.server.IDruginfoService;
import com.example.server.ISaleinfoService;
import com.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/saleinfo")
public class SaleinfoController {
    @Autowired
    private ISaleinfoService service;
    @Autowired
    private IDruginfoService druginfoService;
    //添加
    @PostMapping
    public Result AddSaleinfo(@RequestBody Saleinfo saleinfo){
        String tupian = druginfoService.QueryTupian(saleinfo.getDrugname());
        saleinfo.setTupian(tupian);
        saleinfo.setOperatetime(new Date());
        service.updateLog(saleinfo,"addsaleinfo",saleinfo.getOperator());
        boolean save = service.save(saleinfo);
        return new Result(save,save?"添加成功":"添加失败",null);
    }
    //修改
    @PutMapping
    public Result UpdateSaleinfo(@RequestBody Saleinfo saleinfo){
        System.out.println(saleinfo);
        String tupian = druginfoService.QueryTupian(saleinfo.getDrugname());
        saleinfo.setTupian(tupian);
        saleinfo.setOperatetime(new Date());
        service.updateLog(saleinfo,"updatesaleinfo",saleinfo.getOperator());
        boolean b = service.updateById(saleinfo);
        return new Result(b,b?"修改成功":"修改失败",null);
    }
    //删除
    @DeleteMapping("{id}/{username}")
    public Result DeleteSaleinfo(@PathVariable Integer id,@PathVariable String username){
        Saleinfo saleinfo = service.QueryOneById(id);
        service.updateLog(saleinfo,"deletesaleinfo",username);
        boolean remove = service.removeById(id);
        return new Result(remove,remove?"删除成功":"删除失败",null);
    }
    //分页查询
    @GetMapping("{pagenum}/{pagesize}")
    public Result SelectSaleinfoFenye(@PathVariable Integer pagenum,@PathVariable Integer pagesize){
        IPage<Supplier> supplierIPage = service.QueryPage(pagenum, pagesize, null);
        return new Result(!supplierIPage.getRecords().isEmpty(),!supplierIPage.getRecords().isEmpty()?"查询成功":"查询失败",supplierIPage);
    }
    //分页条件查询
    @GetMapping("{pagenum}/{pagesize}/{search}")
    public Result SelectSaleinfoFen(@PathVariable Integer pagenum,@PathVariable Integer pagesize,@PathVariable String search){
        LambdaQueryWrapper<Saleinfo> wrapper = Wrappers.<Saleinfo>lambdaQuery();
        wrapper.like(search!=null,Saleinfo::getDrugname,search);
        IPage<Supplier> supplierIPage = service.QueryPage(pagenum, pagesize, wrapper);
        return new Result(!supplierIPage.getRecords().isEmpty(),!supplierIPage.getRecords().isEmpty()?"查询成功":"查询失败",supplierIPage);
    }
}
