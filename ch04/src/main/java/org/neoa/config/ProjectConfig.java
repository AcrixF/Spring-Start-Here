package org.neoa.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.neoa.proxies", "org.neoa.services", "org.neoa.repositories"})
public class ProjectConfig {
}
