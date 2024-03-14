package com.registro.grupos.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registro.grupos.demo.model.Group;
import com.registro.grupos.demo.repository.IGroupRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class GroupService
{
    @Autowired
    private IGroupRepository iGroupRepository;

    public Group findOne (Long id)
    {
        return iGroupRepository.findById(id).orElseThrow();
    }

    public List<Group> findAll()
    {
        return iGroupRepository.findAll();
    }

    public Group addGroup ( Group group )
    {
        return iGroupRepository.save(group);
    }

    public Group editGroup ( Group group )
    {
        return iGroupRepository.save(group);
    }

    public void deleteGroup (Long id)
    {
        iGroupRepository.deleteById(id);
    }
    
}