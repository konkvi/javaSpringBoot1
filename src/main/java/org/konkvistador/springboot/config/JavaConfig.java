package org.konkvistador.springboot.config;

import org.konkvistador.springboot.profile.DevProfile;
import org.konkvistador.springboot.profile.ProductionProfile;
import org.konkvistador.springboot.profile.SystemProfile;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

    @Bean
    @ConditionalOnProperty(
            prefix = "netology",
            name = "profile.dev",
            havingValue = "true",
            matchIfMissing = true)
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean
    @ConditionalOnProperty(
            prefix = "netology",
            name = "profile.dev",
            havingValue = "false")
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }

}
