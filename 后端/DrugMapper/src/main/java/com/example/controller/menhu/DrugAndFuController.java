package com.example.controller.menhu;

import com.example.entity.menhu.Drugdata;
import com.example.entity.menhu.WebHome;
import com.example.entity.menhu.myfuwu.Icondata;
import com.example.server.menhuimpl.DrugdataService;
import com.example.server.menhuimpl.IcondataService;
import com.example.server.menhuimpl.WebHomeService;
import com.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/drugandfu")
public class DrugAndFuController {
    @Autowired
    DrugdataService drugdataService;
    @Autowired
    IcondataService icondataService;
    @Autowired
    WebHomeService webHomeService;
    //DrugAndFuItem页面
    @GetMapping("drugandfuitem")
    public Result GetDrugandFuData(){
        List<Drugdata> drugdata = drugdataService.QueryInfo();
        return new Result(!drugdata.isEmpty(),!drugdata.isEmpty()?"数据加载成功":"数据加载失败",drugdata);
    }
    //MyFuwu页面
    @GetMapping("myfuwu")
    public Result GetMyFuwu(){
        List<Icondata> icondata = icondataService.QueryInfo();
        return new Result(!icondata.isEmpty(),!icondata.isEmpty()?"数据加载成功":"数据加载失败",icondata);
    }
    //WebHome页面
    @GetMapping("webhome")
    public Result GetWebHomeData(){
        List<WebHome> webHomes = webHomeService.QueryInfo();
        return new Result(!webHomes.isEmpty(),!webHomes.isEmpty()?"数据加载成功":"数据加载失败",webHomes);
    }
}
