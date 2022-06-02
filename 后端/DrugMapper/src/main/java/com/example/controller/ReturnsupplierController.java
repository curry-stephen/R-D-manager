package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.entity.Returnsupplier;
import com.example.server.IDruginfoService;
import com.example.server.IReturnsupplierService;
import com.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/returnsupplier")
public class ReturnsupplierController {
    @Autowired
    IReturnsupplierService service;
    @Autowired
    IDruginfoService druginfoService;
    //添加
    @PostMapping
    public Result AddRsupplier(@RequestBody Returnsupplier returnsupplier){
        String tupian = druginfoService.QueryTupian(returnsupplier.getDrugname());
        System.out.println(tupian);
        returnsupplier.setTupian(tupian);
        returnsupplier.setCreatetime(new Date());
        service.updateLog(returnsupplier,"addreturnsupplier",returnsupplier.getUsername());
        boolean save = service.save(returnsupplier);
        return new Result(save,save?"添加成功":"添加失败",null);
    }
    //修改
    @PutMapping
    public Result UpdateRsupplier(@RequestBody Returnsupplier returnsupplier){
        String tupian = druginfoService.QueryTupian(returnsupplier.getDrugname());
        returnsupplier.setTupian(tupian);
        returnsupplier.setCreatetime(new Date());
        service.updateLog(returnsupplier,"updatereturnsupplier",returnsupplier.getUsername());
        boolean update = service.updateById(returnsupplier);
        return new Result(update,update?"修改成功":"修改失败",null);
    }
    //删除
    @DeleteMapping("{id}/{username}")
    public Result DeleteRsupplier(@PathVariable Integer id,@PathVariable String username){
        Returnsupplier returnsupplier = service.QueryOneById(id);
        service.updateLog(returnsupplier,"deletereturnsupplier",returnsupplier.getUsername());
        boolean remove = service.removeById(id);
        return new Result(remove,remove?"删除成功":"删除失败",null);
    }
    //分页查询
    @GetMapping("{pagenum}/{pagesize}")
    public Result QueryPage(@PathVariable Integer pagenum,@PathVariable Integer pagesize){
        IPage<Returnsupplier> page = service.QueryPage(pagenum, pagesize, null);
        return new Result(!page.getRecords().isEmpty(),!page.getRecords().isEmpty()?"查询成功":"没有找到数据",page);
    }
    //分页条件查询
    @GetMapping("{pagenum}/{pagesize}/{search}")
    public Result QueryPageSelect(@PathVariable Integer pagenum,@PathVariable Integer pagesize,@PathVariable String search){
        LambdaQueryWrapper<Returnsupplier> wrapper = Wrappers.<Returnsupplier>lambdaQuery();
        wrapper.like(search!=null,Returnsupplier::getDrugname,search);
        IPage<Returnsupplier> page = service.QueryPage(pagenum, pagesize, wrapper);
        return new Result(!page.getRecords().isEmpty(),!page.getRecords().isEmpty()?"查询成功":"没有找到数据",page);
    }
}
