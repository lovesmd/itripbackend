package cn.itrip;

import cn.itrip.dao.itripAreaDic.ItripAreaDicMapper;
import cn.itrip.dao.itripLabelDic.ItripLabelDicMapper;
import cn.itrip.pojo.ItripAreaDic;
import cn.itrip.util.Dto;
import cn.itrip.util.DtoUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class bizController {
    @Resource
    ItripAreaDicMapper dao;

    @Resource
    ItripLabelDicMapper dao1;

    @Resource
    ItripAreaDicMapper dao2;

    ///biz/api/hotel/queryhotcity/{id}
    @RequestMapping("/api/hotel/querytradearea/{id}")
    @ResponseBody
    public Dto GetObj1(@PathVariable("id")int id){
        return DtoUtil.returnDataSuccess(dao2.getarea(id));
    }



    @RequestMapping("api/hotel/queryhotelfeature")
    @ResponseBody
    public Dto GetObj(){
       //获取首页特色酒店
        return DtoUtil.returnDataSuccess(dao1.getfirst());
    }

    @RequestMapping("/api/hotel/queryhotcity/{id}")
    @ResponseBody
    public Dto GetObj(@PathVariable("id")int id){
        List<ItripAreaDic> list=dao.ishot(id);
        return DtoUtil.returnDataSuccess(list);
    }
}
