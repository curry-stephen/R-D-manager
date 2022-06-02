package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.entity.Supplier;
import com.example.server.ISupplierSevice;
import com.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    private ISupplierSevice iSupplierSevice;
    //查询所有厂商名字
    @GetMapping
    public Result QueryAllName(){
        String[] strings = iSupplierSevice.QueryName();
        return new Result(strings.length>0,strings.length>0?"查询成功":"没有找到数据",strings);
    }
    //添加
    @PostMapping
    public Result AddSupplier(@RequestBody Supplier supplier){
        supplier.setCreatetime(new Date());
        iSupplierSevice.updateLog(supplier,"addsupplier",supplier.getUsername());
        boolean save = iSupplierSevice.save(supplier);
        return new Result(save,save?"添加成功":"添加失败",null);
    }
    //修改
    @PutMapping
    public Result UpdateSupplier(@RequestBody Supplier supplier){
        supplier.setCreatetime(new Date());
        iSupplierSevice.updateLog(supplier,"updatesupplier",supplier.getUsername());
        boolean update = iSupplierSevice.updateById(supplier);
        return new Result(update,update?"修改成功":"修改失败",null);
    }
    //删除
    @DeleteMapping("{id}/{username}")
    public Result DeleteSupplier(@PathVariable Integer id,@PathVariable String username){
        Supplier supplier = iSupplierSevice.QueryOneById(id);
        iSupplierSevice.updateLog(supplier,"deletesupplier",username);
        boolean remove = iSupplierSevice.removeById(id);
        return new Result(remove,remove?"删除成功":"删除失败",null);
    }
    //分页查询
    @GetMapping("{pagenum}/{pagesize}")
    public Result QueryFenye(@PathVariable Integer pagenum,@PathVariable Integer pagesize){
        IPage<Supplier> supplierIPage = iSupplierSevice.SeletePage(pagenum, pagesize,null);
        return new Result(!supplierIPage.getRecords().isEmpty(),!supplierIPage.getRecords().isEmpty()?"查询成功":"没有查到数据",supplierIPage);
    }
    //分页条件
    @GetMapping("{pagenum}/{pagesize}/{search}")
    public Result QueryFenyeSelect(@PathVariable Integer pagenum,@PathVariable Integer pagesize,@PathVariable String search){
        LambdaQueryWrapper<Supplier> wrapper= Wrappers.<Supplier>lambdaQuery();
        wrapper.like(search!=null,Supplier::getName,search);
        IPage<Supplier> supplierIPage = iSupplierSevice.SeletePage(pagenum, pagesize, wrapper);
        return new Result(!supplierIPage.getRecords().isEmpty(),!supplierIPage.getRecords().isEmpty()?"查询成功":"没有查到数据",supplierIPage);
    }
}
