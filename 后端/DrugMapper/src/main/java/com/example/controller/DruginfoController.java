package com.example.controller;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.entity.Druginfo;
import com.example.server.IDruginfoService;
import com.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/druginfo")
public class DruginfoController {
    @Autowired
    private IDruginfoService druginfoService;
    //添加
    @PostMapping
    public Result AddDrug(@RequestBody Druginfo druginfo){
        boolean adddruginfo = druginfoService.updateLog(druginfo, "adddruginfo", druginfo.getUsername());
        if (adddruginfo){
            System.out.println("adddrug日志");
        }
        boolean save = druginfoService.save(druginfo);
        return new Result(save,save?"添加成功":"添加失败",null);
    }
    //修改
    @PutMapping
    public Result UpdateDrug(@RequestBody Druginfo druginfo){
        boolean updatedrug = druginfoService.updateLog(druginfo, "updatedrug", druginfo.getUsername());
        if (updatedrug){
            System.out.println("修改drug日志");
        }
        boolean update = druginfoService.updateById(druginfo);
        return new Result(update,update?"修改成功":"修改失败",null);
    }
    //删除
    @DeleteMapping("{id}/{username}")
    public Result DeleteDrug(@PathVariable Integer id,@PathVariable String username){
        Druginfo druginfo = druginfoService.QueryOneById(id);
        boolean deletedrug = druginfoService.updateLog(druginfo, "deletedrug", username);
        if (deletedrug){
            System.out.println("删除drug日志");
        }
        boolean removeById = druginfoService.removeById(id);
        return new Result(removeById,removeById?"删除成功":"删除失败",null);
    }
    //分页查询
    @GetMapping("{pagenum}/{pagesize}")
    public Result QueryFenye(@PathVariable Integer pagenum,@PathVariable Integer pagesize){
        JianCha();
        IPage<Druginfo> druginfoIPage = druginfoService.SelectPage(pagenum, pagesize, null);
        return new Result(!druginfoIPage.getRecords().isEmpty(),!druginfoIPage.getRecords().isEmpty()?"查询成功":"没有找到数据",druginfoIPage);
    }
    //分页条件
    @GetMapping("{pagenum}/{pagesize}/{search}")
    public Result QueryFenyeSelect(@PathVariable Integer pagenum,@PathVariable Integer pagesize,@PathVariable String search){
        JianCha();
        LambdaQueryWrapper<Druginfo> queryWrapper = Wrappers.<Druginfo>lambdaQuery();
        queryWrapper.like(search!=null,Druginfo::getDrugname,search);
        IPage<Druginfo> druginfoIPage = druginfoService.SelectPage(pagenum, pagesize, queryWrapper);
        return new Result(!druginfoIPage.getRecords().isEmpty(),!druginfoIPage.getRecords().isEmpty()?"查询成功":"没有找到数据",druginfoIPage);
    }
    //检查是否过期
    private void JianCha(){
        List<Druginfo> druginfo = druginfoService.QueryDate();
        Date date = new Date();
        for (Druginfo info:druginfo){
            Date producttime = info.getProducttime();
            long between = DateUtil.between(date, producttime, DateUnit.DAY);
            Integer warrenty = info.getWarrenty();
            long time=date.getTime()-producttime.getTime();
            info.setGuo(time>0);
            long l = between / 31;
            info.setGuo((l-warrenty)<0);
            if(l-warrenty<0){
                info.setGuotime("剩余保质期 "+(warrenty-l)+"月"+between%31+"日");
            }else{
                info.setGuotime("已过期 "+(l-warrenty)+"月"+between%31+"日");
            }

            druginfoService.updateById(info);
        }
    }
    //查询所有的药品名称
    @GetMapping("drugname")
    public Result QueryDrugName(){
        String[] strings = druginfoService.QueryDrugName();
        return new Result(strings.length>0,strings.length>0?"查询成功":"没有找到数据",strings);
    }
    //查询单价
    @GetMapping("price/{drugname}")
    public Result QueryPriceByName(@PathVariable String drugname){
        Double aDouble = druginfoService.QueryPrice(drugname);
        return new Result(aDouble>0,aDouble>0?"查询成功":"没有找到数据",aDouble);
    }
    //查询编号
    @GetMapping("number/{drugname}")
    public Result QueryNumberByName(@PathVariable String drugname){
        String number = druginfoService.QueryNumber(drugname);
        return new Result(number!=null,number!=null?"查询成功":"没有找到数据",number);
    }
}
