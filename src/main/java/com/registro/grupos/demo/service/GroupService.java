package com.registro.grupos.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registro.grupos.demo.repository.IGroupRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class GroupService
{
    @Autowired
    private IGroupRepository iGroupRepository;

    
}