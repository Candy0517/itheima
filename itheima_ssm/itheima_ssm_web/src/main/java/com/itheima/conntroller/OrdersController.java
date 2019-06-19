package com.itheima.conntroller;


import com.github.pagehelper.PageInfo;
import com.itheima.domain.Orders;
import com.itheima.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

   /* @RequestMapping("/findAll.do")
    public ModelAndView findAll() {

        List<Orders> ordersList = ordersService.findAll();

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("ordersList", ordersList);

        modelAndView.setViewName("orders-list");


        return modelAndView;
    }*/


    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",defaultValue = "1",required =false)int page,@RequestParam(name = "pageSize",defaultValue = "4",required =false)int size) {

        List<Orders> ordersList = ordersService.findAll(page,size);

        PageInfo<Orders> pageInfo = new PageInfo<>(ordersList);

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("pageInfo", pageInfo);

        modelAndView.setViewName("orders-page-list");


        return modelAndView;
    }

}
