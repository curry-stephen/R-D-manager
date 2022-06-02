package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.Owinfo;
import com.example.server.IMatterService;
import com.example.server.IOwinfoService;
import com.example.utils.DateUtil;
import com.example.utils.Result;
import com.example.entity.Matter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/matter")
public class MatterController {
    @Autowired
    private IMatterService iMatterService;
    @Autowired
    private IOwinfoService iOwinfoService;
    //分页条件查询
    @GetMapping("{pageNum}/{pageSize}/{search}")
    private Result QueryMatter(@PathVariable int pageNum,@PathVariable int pageSize,@PathVariable String search){
        System.out.println("search:"+search);
        Page<Matter> matterPage = new Page<>(pageNum,pageSize);
        LambdaQueryWrapper<Matter> wrapper= Wrappers.<Matter>lambdaQuery();
        wrapper.like(search!=null,Matter::getDrugname,search);
        IPage<Matter> matterIPage = iMatterService.selectPage(matterPage, wrapper);
        return new Result(!matterIPage.getRecords().isEmpty(),"查询成功",matterIPage);
    }
    //分页查询
    @GetMapping("{pageNum}/{pageSize}")
    private Result QueryMatterFenye(@PathVariable int pageNum,@PathVariable int pageSize){
        Page<Matter> matterPage = new Page<>(pageNum,pageSize);
        IPage<Matter> matterIPage = iMatterService.selectPage(matterPage,null);
        return new Result(!matterIPage.getRecords().isEmpty(),"查询成功",matterIPage);
    }
    //新增
    @PostMapping
    public Result AddDrug(@RequestBody Matter matter){
        String tupian = iOwinfoService.QueryTupian(matter.getDrugname());
        matter.setImg(tupian);
        String dateConvert = DateUtil.dateConvert(new Date());
        matter.setCtime(dateConvert);
        iMatterService.updateLog(matter,"addmatter",matter.getUsername());
        boolean save = iMatterService.save(matter);
        return new Result(save,save?"添加成功":"添加失败");
    }
    //删除
    @DeleteMapping("{id}/{username}")
    public Result DeleteDrug(@PathVariable("id") Integer id,@PathVariable String username){
        boolean removeById = iMatterService.removeById(id);
        Matter matter = iMatterService.QueryOneById(id);
        iMatterService.updateLog(matter,"deletematter",username);
        return new Result(removeById,removeById?"删除成功":"删除失败");
    }
    //查看一个
    @GetMapping("{id}")
    public Result QueryById(@PathVariable("id") Integer id){
        Matter byId = iMatterService.getById(id);
        return new Result(byId!=null,byId!=null?"查询成功":"没有查到数据",byId);
    }
    //修改
    @PutMapping
    public Result UpdateDrug(@RequestBody Matter matter){
        String tupian = iOwinfoService.QueryTupian(matter.getDrugname());
        matter.setImg(tupian);
        String dateConvert = DateUtil.dateConvert(new Date());
        matter.setCtime(dateConvert);
        iMatterService.updateLog(matter,"updatematter",matter.getUsername());
        boolean updateById = iMatterService.updateById(matter);
        return new Result(updateById,updateById?"修改成功":"修改失败");
    }
}
