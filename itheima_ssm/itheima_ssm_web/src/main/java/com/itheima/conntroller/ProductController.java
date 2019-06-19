package com.itheima.conntroller;


import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(ModelAndView modelAndView){

        List<Product> productList = productService.findAll();

        modelAndView.addObject("productList",productList);

        modelAndView.setViewName("product_list");

        return modelAndView;
    }

    @RequestMapping("/save.do")
    public String save(Product product){

        productService.save(product);

        return "redirect:findAll.do";
    }

}
