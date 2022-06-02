package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.entity.Returngoods;
import com.example.server.IDruginfoService;
import com.example.server.IReturngoodsService;
import com.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/returngoods")
public class ReturngoodsController {
    @Autowired
    IReturngoodsService returngoodsService;
    @Autowired
    IDruginfoService druginfoService;
    //添加
    @PostMapping
    public Result AddReturngoods(@RequestBody Returngoods returngoods){
        String tupian = druginfoService.QueryTupian(returngoods.getDrugname());
        returngoods.setTupian(tupian);
        returngoods.setOperatetime(new Date());
        returngoodsService.updateLog(returngoods,"addreturngoods",returngoods.getUsername());
        boolean save = returngoodsService.save(returngoods);
        return new Result(save,save?"添加成功":"添加失败",null);
    }
    //修改
    @PutMapping
    public Result UpdateReturngoods(@RequestBody Returngoods returngoods){
        String s = druginfoService.QueryTupian(returngoods.getDrugname());
        returngoods.setTupian(s);
        returngoods.setOperatetime(new Date());
        returngoodsService.updateLog(returngoods,"updateretrungoods",returngoods.getUsername());
        boolean update = returngoodsService.updateById(returngoods);
        return new Result(update,update?"修改成功":"修改失败",null);
    }
    //删除
    @DeleteMapping("{username}/{id}")
    public Result DeleteReturngoods(@PathVariable Integer id,@PathVariable String username){
        System.out.println(id+","+username);
        boolean remove = returngoodsService.removeById(id);
        Returngoods returngoods = returngoodsService.QueryOneById(id);
        System.out.println(returngoods);
        returngoodsService.updateLog(returngoods,"deletereturngoods",username);
        return new Result(remove,remove?"删除成功":"删除失败",null);
    }
    //分页条件查询
    @GetMapping("{pagenum}/{pagesize}/{search}")
    public Result QueryPageSelete(@PathVariable Integer pagenum,@PathVariable Integer pagesize,@PathVariable String search){
        LambdaQueryWrapper<Returngoods> wrapper = Wrappers.<Returngoods>lambdaQuery();
        wrapper.like(search!=null,Returngoods::getDrugname,search);
        IPage<Returngoods> iPage = returngoodsService.QueryPage(pagenum, pagesize, wrapper);
        return new Result(!iPage.getRecords().isEmpty(),!iPage.getRecords().isEmpty()?"查询成功":"查询失败",iPage);
    }
    //分页查询
    @GetMapping("{pagenum}/{pagesize}")
    public Result QueryPage(@PathVariable Integer pagenum,@PathVariable Integer pagesize){
        IPage<Returngoods> iPage = returngoodsService.QueryPage(pagenum, pagesize, null);
        return new Result(!iPage.getRecords().isEmpty(),!iPage.getRecords().isEmpty()?"查询成功":"查询失败",iPage);
    }
}
