/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dnt.travel.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author DikamonTu
 */
@Configuration
public class AppConfig {
    @Value("${app.pagesize}")
    private int pageSize;

    public int getPageSize() {
        return pageSize;
    }

}
