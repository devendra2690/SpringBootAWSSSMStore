package com.aws.ssm.store.controller;

import com.aws.ssm.store.config.DataSourceConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class FetchSSMConfigController {

    private final DataSourceConfig dataSourceConfig;

    public FetchSSMConfigController(DataSourceConfig dataSourceConfig) {
        this.dataSourceConfig = dataSourceConfig;
    }

    @GetMapping("/ssm/values")
    public Map<String,String> listSSMConfig() {

        Map<String,String> ssmValueMap = new HashMap<>();

        ssmValueMap.put("DB_URL",dataSourceConfig.getDbUrl());
        ssmValueMap.put("DB_Username",dataSourceConfig.getDbUsername());
        ssmValueMap.put("DB_Password",dataSourceConfig.getDbPassword());

         return ssmValueMap;
    }
}
