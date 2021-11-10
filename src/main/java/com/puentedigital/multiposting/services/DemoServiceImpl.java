package com.puentedigital.multiposting.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class DemoServiceImpl implements DemoService{

    @Override
    public String someServiceAction() {
        return null;
    }
}
