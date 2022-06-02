package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.Druginfo;
import com.example.entity.Owinfo;
import com.example.entity.Supplier;
import com.example.log.UserLog;
import com.example.server.IDruginfoService;
import com.example.server.IOwinfoService;
import com.example.server.ISupplierSevice;
import com.example.server.impl.UserServiceImpl;
import com.example.utils.DateUtil;
import com.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/owinfo")
public class OwinfoController {
    @Autowired
    private IOwinfoService iOwinfoService;
    @Autowired
    IDruginfoService druginfoService;
    @Autowired
    ISupplierSevice supplierSevice;
    @Autowired
    UserServiceImpl userService;
    //添加
    @PostMapping
    public Result AddDrug(@RequestBody Owinfo owinfo){
        Druginfo druginfo = druginfoService.QueryDrug(owinfo.getDrugname());
        if (druginfo==null){
            Druginfo druginfo1 = new Druginfo();
            druginfo1.setDrugname(owinfo.getDrugname());
            druginfo1.setTupian(owinfo.getTupian());
            druginfo1.setStock(owinfo.getNums());
            druginfo1.setWarrenty(owinfo.getWarrenty());
            druginfo1.setProducttime(owinfo.getProducttime());
            druginfo1.setSuppliername(owinfo.getSpname());
            druginfoService.save(druginfo1);
        }
        Supplier supplier = supplierSevice.QuerySp(owinfo.getSpname());
        if (supplier==null){
            Supplier supplier1 = new Supplier();
            supplier1.setName(owinfo.getSpname());
            supplier1.setCreatetime(new Date());
            supplierSevice.save(supplier1);
        }
        String dateConvert = DateUtil.dateConvert(new Date());
        owinfo.setCtime(dateConvert);
        boolean addowinfo = iOwinfoService.updateLog(owinfo, "addowinfo", owinfo.getDruguser());
        if (addowinfo){
            System.out.println("addOwinfo日志添加成功");
        }
        boolean save = iOwinfoService.save(owinfo);
        return new Result(save,save?"添加成功":"添加失败");
    }
    //分页查询
    @GetMapping("{pageNum}/{pageSize}")
    public Result findPage(@PathVariable("pageNum") Integer pageNum,@PathVariable("pageSize") Integer pageSize){
        IPage<Owinfo> owinfoIPage = iOwinfoService.newselectPage(pageNum, pageSize);
        return new Result(true,"查询成功",owinfoIPage);
    }
    //删除
    @DeleteMapping("{id}/{username}")
    public Result DeleteDrug(@PathVariable("id") Integer id,@PathVariable String username){
        Owinfo owinfo = iOwinfoService.QueryOneById(id);
        boolean deleteowinfo = iOwinfoService.updateLog(owinfo, "deleteowinfo", username);
        if (deleteowinfo){
            System.out.println("删除owinfo日志");
        }
        boolean removeById = iOwinfoService.removeById(id);
        return new Result(removeById,removeById?"删除成功":"删除失败");
    }
    //修改
    @PutMapping
    public Result UpdateDrug(@RequestBody Owinfo owinfo){
        String dateConvert = DateUtil.dateConvert(new Date());
        owinfo.setCtime(dateConvert);
        boolean updateOwinfo = iOwinfoService.updateLog(owinfo,"updateowinfo",owinfo.getDruguser());
        if (updateOwinfo){
            System.out.println("owinfo修改日志添加成功");
        }
        boolean updateById = iOwinfoService.updateById(owinfo);
        return new Result(updateById,updateById?"修改成功":"修改失败");
    }
    //按条件分页
    @GetMapping("{pageNum}/{pageSize}/{search}")
    public Result QueryByLikeName(@PathVariable int pageNum,@PathVariable int pageSize,@PathVariable String search){
        Page<Owinfo> owinfoPage = new Page<>();
        LambdaQueryWrapper<Owinfo> wrapper=Wrappers.<Owinfo>lambdaQuery();
        if (StringUtils.isNotBlank(search)){
            wrapper.like(Owinfo::getDrugname,search);
        }
        Page<Owinfo> selectPage = iOwinfoService.selectPage(owinfoPage, wrapper);
        return new Result(!selectPage.getRecords().isEmpty(),!selectPage.getRecords().isEmpty()?"查询成功":"没有查到数据",selectPage);
    }
    //查询所有药品名称
    @GetMapping
    public Result QueryAllName(){
        String[] strings = druginfoService.QueryDrugName();
        return new Result(strings.length>0,strings.length>0?"查询成功":"未找到数据",strings);
    }
}
