package iotd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConfigController {

    private static final Logger log = LoggerFactory.getLogger(ConfigController.class);
  
    @Value("${environment}")
	private String environment;

    @Value("${apod.url}")
	private String apodUrl;
    
    @RequestMapping("/config")
    public Config get() {
        log.debug("** GET /config called"); 
        return new Config(environment, apodUrl);
    }
}
