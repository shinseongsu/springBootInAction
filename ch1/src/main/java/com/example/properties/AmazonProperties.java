package com.example.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
// @ConfigurationProperties("amazon")      // "amazon" 접두어가 붙은 프로퍼티 주입
public class AmazonProperties {

    @Value("${amazon.associateId}")
    private String associateId;

    public void setAssociatedId(String associateId) {
        this.associateId = associateId;
    }

    public String getAssociateId() {
        return associateId;
    }

}
