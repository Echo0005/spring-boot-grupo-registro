package com.registro.grupos.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.registro.grupos.demo.service.GroupService;

@RestController
@RequestMapping("/group")
public class GroupController
{
    @Autowired
    private GroupService groupService;

}
