package demo.oauth.resourceserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

@SpringBootApplication
public class ResourceServerApp {
	
    public static void main( String[] args ){
        
    	SpringApplication.run(ResourceServerApp.class, args);
    }
    
    @Primary
    @Bean
    public RemoteTokenServices tokenService() {
    	
        RemoteTokenServices tokenService = new RemoteTokenServices();
        tokenService.setCheckTokenEndpointUrl("http://localhost:8080/oauth/check_token");
        tokenService.setClientId("clientIdPassword");
        tokenService.setClientSecret("secret");
        return tokenService;
    }
}
