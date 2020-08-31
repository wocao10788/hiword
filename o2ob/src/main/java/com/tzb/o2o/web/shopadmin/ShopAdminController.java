package com.tzb.o2o.web.shopadmin;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/shopadmin", method = RequestMethod.GET)
public class ShopAdminController {

    @RequestMapping(value = "/shopoperation")
    public String shopOperation(){
        // spring-web.xml 配置了html路径
        return "shop/shopoperation";
    }
    @RequestMapping(value = "/shoplist")
    public String shoplist(){
        // spring-web.xml 配置了html路径
        return "shop/shoplist";
    }
    @RequestMapping(value = "/shopmanagement")
    public String shopManagement(){
        // spring-web.xml 配置了html路径
        return "shop/shopmanagement";
    }
    @RequestMapping(value = "/productcategorymanagement")
    public String productCategory(){
        // spring-web.xml 配置了html路径
        return "shop/productcategorymanagement";
    }
    @RequestMapping(value = "/productoperation")
    public String productOperation(){
        return "shop/productoperation";
    }
    @RequestMapping(value = "/productmanagement")
    public String productmanagement(){
        return "shop/productmanagement";
    }

    @RequestMapping(value = "/shopauthmanagement")
    public String shopAuthManagement() {
        // 转发至店铺授权页面
        return "shop/shopauthmanagement";
    }

    @RequestMapping(value = "/shopauthedit")
    public String shopAuthEdit() {
        // 转发至授权信息修改页面
        return "shop/shopauthedit";
    }

    @RequestMapping(value = "/operationsuccess", method = RequestMethod.GET)
    private String operationSuccess() {
        // 转发至操作失败的页面
        return "shop/operationsuccess";
    }

    @RequestMapping(value = "/operationfail", method = RequestMethod.GET)
    private String operationFail() {
        // 转发至操作成功的页面
        return "shop/operationfail";
    }

    @RequestMapping(value = "/productbuycheck", method = RequestMethod.GET)
    private String productBuyCheck() {
        // 转发至店铺的消费记录的页面
        return "shop/productbuycheck";
    }

    @RequestMapping(value = "/awardmanagement", method = RequestMethod.GET)
    private String awardManagement() {
        // 奖品管理页路由
        return "shop/awardmanagement";
    }

    @RequestMapping(value = "/awardoperation", method = RequestMethod.GET)
    private String awardEdit() {
        // 奖品编辑页路由
        return "shop/awardoperation";
    }

    @RequestMapping(value = "/usershopcheck", method = RequestMethod.GET)
    private String userShopCheck() {
        // 店铺用户积分统计路由
        return "shop/usershopcheck";
    }

    @RequestMapping(value = "/awarddelivercheck", method = RequestMethod.GET)
    private String awardDeliverCheck() {
        // 店铺用户积分兑换路由
        return "shop/awarddelivercheck";
    }
}

