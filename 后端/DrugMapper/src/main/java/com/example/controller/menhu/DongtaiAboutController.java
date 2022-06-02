package com.example.controller.menhu;

import com.example.entity.menhu.Tongzhi;
import com.example.entity.menhu.dongtaiimg.Imgs;
import com.example.entity.menhu.nowdataitem.Carddata;
import com.example.entity.menhu.nowdataitem.Newdata;
import com.example.entity.menhu.work.Works;
import com.example.entity.menhu.work.Worksselect;
import com.example.server.menhuimpl.*;
import com.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/dongtai")
public class DongtaiAboutController {
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
    //NowDataItem页面数据
    @GetMapping("nowdataitem")
    public Result GetAllData(){
        List<Carddata> carddata = carddataService.QueryInfo();
        List<Newdata> newdata = newdataService.QueryInfo();
        HashMap<String, Object> map = new HashMap<>();
        map.put("carddata",carddata);
        map.put("newsdata",newdata);
        return new Result(!map.isEmpty(),!map.isEmpty()?"数据加载成功":"数据加载失败",map);
    }
    //Works页面数据
    @GetMapping("works")
    public Result GetWorks(){
        List<Works> works = worksService.QueryInfo();
        List<Worksselect> worksselects = worksselectService.QueryInfo();
        HashMap<String, Object> map = new HashMap<>();
        map.put("works",works);
        map.put("worksselect",worksselects);
        return new Result(!map.isEmpty(),!map.isEmpty()?"数据加载成功":"数据加载失败",map);
    }
    //TongZHi页面数据
    @GetMapping("tongzhi")
    public Result GetTongzhi(){
        List<Tongzhi> tongzhis = tongzhiService.QueryInfo();
        return new Result(!tongzhis.isEmpty(),!tongzhis.isEmpty()?"数据加载成功":"数据加载失败",tongzhis);
    }
    //DongtaiImg页面数据
    @GetMapping("dongtai")
    public Result GetDongtai(){
        List<Imgs> imgs = imgsService.QueryInfo();
        return new Result(!imgs.isEmpty(),!imgs.isEmpty()?"数据加载成功":"数据加载失败",imgs);
    }
}
