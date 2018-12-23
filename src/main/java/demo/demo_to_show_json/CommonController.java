package demo.demo_to_show_json;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Project:interceptordemo2
 * Package:cn.edu.scnu.interceptordemo2
 * Author:Alan Ruan
 * Date:2018-10-05 10:36
 * Description://TODO
 */
@RestController
public class CommonController {

    @RequestMapping(value = "userCtrl/createObj")
    @ResponseBody
    public List<OrderInfo> createObj() {

        OrderInfo orderInfo = new OrderInfo();
        OrderInfo orderInfo1 = new OrderInfo();
        OrderInfo orderInfo2 = new OrderInfo();

        List<OrderInfo> orderInfoList = new ArrayList<>();

        orderInfo.setOrderId("A11");
        orderInfo.setOrderStatus(1);
        orderInfo.setProductName("龙卡VIP");
        orderInfo.setProductNumber(2);
        orderInfo.setProductPrice(6.66);
        orderInfo.setUserName("小鑫");
        orderInfo.setUserAddress("华南师范大学西三425");
        orderInfo.setStartTime("2015年");
        orderInfo.setUserPhone("1234这是电话4321");
        orderInfo.setTotalMoney(13.32);

        orderInfo1.setOrderId("B11");
        orderInfo1.setOrderStatus(1);
        orderInfo1.setProductName("黑卡VIP");
        orderInfo1.setProductNumber(1);
        orderInfo1.setProductPrice(6.66);
        orderInfo1.setUserName("小鑫");
        orderInfo1.setUserAddress("华南师范大学西三425");
        orderInfo1.setStartTime("2015年");
        orderInfo1.setUserPhone("1234这是电话4321");
        orderInfo1.setTotalMoney(6.66);

        orderInfo2.setOrderId("C11");
        orderInfo2.setOrderStatus(1);
        orderInfo2.setProductName("Super VIP");
        orderInfo2.setProductNumber(2);
        orderInfo2.setProductPrice(6.66);
        orderInfo2.setUserName("小鑫");
        orderInfo2.setUserAddress("华南师范大学西三425");
        orderInfo2.setStartTime("2015年");
        orderInfo2.setUserPhone("1234这是电话4321");
        orderInfo2.setTotalMoney(13.32);

        orderInfoList.add(orderInfo);
        orderInfoList.add(orderInfo1);
        orderInfoList.add(orderInfo2);

        return orderInfoList;
    }


    @RequestMapping(value = "testCtrl/createObj")
    @ResponseBody
    public String sayNo(){
        return "创建成功";
    }

}
