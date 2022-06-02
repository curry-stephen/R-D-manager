package com.example.controller.menhu.add;

import com.example.entity.menhu.Drugdata;
import com.example.entity.menhu.Tongzhi;
import com.example.entity.menhu.WebHome;
import com.example.entity.menhu.dongtaiimg.Imgs;
import com.example.entity.menhu.myfuwu.Icondata;
import com.example.entity.menhu.nowdataitem.Carddata;
import com.example.entity.menhu.nowdataitem.Newdata;
import com.example.entity.menhu.work.Works;
import com.example.entity.menhu.work.Worksselect;
import com.example.server.menhuimpl.*;
import com.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.PublicKey;

@RestController
@RequestMapping("/add")
public class AddInfo {
    @Autowired
    DrugdataService drugdataService;
    @Autowired
    IcondataService icondataService;
    @Autowired
    WebHomeService webHomeService;
    @Autowired
    ImgsService imgsService;
    @Autowired
    CarddataService carddataService;
    @Autowired
    NewdataService newdataService;//热门信息
    @Autowired
    WorksService worksService;
    @Autowired
    WorksselectService worksselectService;
    @Autowired
    TongzhiService tongzhiService;
    @PostMapping("drug")
    public Result AddDrug(@RequestBody Drugdata drugdata){
        boolean addinfo = drugdataService.Addinfo(drugdata);
        return new Result(addinfo,addinfo?"添加成功":"添加失败",null);
    }
    @PostMapping("icon")
    public Result AddIcon(@RequestBody Icondata icondata){
        boolean addinfo = icondataService.Addinfo(icondata);
        return new Result(addinfo,addinfo?"添加成功":"添加失败",null);
    }
    @PostMapping("webhome")
    public Result AddWebHome(@RequestBody WebHome webHome){
        boolean addinfo = webHomeService.Addinfo(webHome);
        return new Result(addinfo,addinfo?"添加成功":"添加失败",null);
    }
    @PostMapping("imgs")
    public Result AddImg(@RequestBody Imgs imgs){
        boolean addinfo = imgsService.Addinfo(imgs);
        return new Result(addinfo,addinfo?"添加成功":"添加失败",null);
    }
    @PostMapping("card")
    public Result AddCard(@RequestBody Carddata carddata){
        boolean addinfo = carddataService.Addinfo(carddata);
        return new Result(addinfo,addinfo?"添加成功":"添加失败",null);
    }
    @PostMapping("newdata")
    public Result AddNewData(@RequestBody Newdata newdata){
        boolean addinfo = newdataService.Addinfo(newdata);
        return new Result(addinfo,addinfo?"添加成功":"添加失败",null);
    }
    @PostMapping("works")
    public Result AddWorks(@RequestBody Works works){
        boolean addinfo = worksService.Addinfo(works);
        return new Result(addinfo,addinfo?"添加成功":"添加失败",null);
    }
    @PostMapping("workselect")
    public Result AddWorkSelect(@RequestBody Worksselect worksselect){
        boolean addinfo = worksselectService.Addinfo(worksselect);
        return new Result(addinfo,addinfo?"添加成功":"添加失败",null);
    }
    @PostMapping("tongzhi")
    public Result AddTongzhi(@RequestBody Tongzhi tongzhi){
        boolean addinfo = tongzhiService.Addinfo(tongzhi);
        return new Result(addinfo,addinfo?"添加成功":"添加失败",null);
    }
}
