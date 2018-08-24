package org.val.win.service.webapp;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan("org.val.win")
@ImportResource("classpath:/bootstrapContext.xml")
public class ConfigurationSpring {

}