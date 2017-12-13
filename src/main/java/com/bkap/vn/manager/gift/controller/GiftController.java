package com.bkap.vn.manager.gift.controller;

import com.bkap.vn.manager.gift.service.GiftService;
import com.bkap.vn.manager.gift.service.GiftServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("quan-tri")
public class GiftController {

    @Autowired
    GiftService giftService = new GiftServiceImpl();
}