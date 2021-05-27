package cn.jbit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 源码学院只为培养优秀的bat程序员而生
 *
 * @author 学员张在成
 * @data 2020/8/30
 *
 *  前后端分离要做跨域的配置
 *
 */
@Configuration
public class CorsConfig {

    private  CorsConfiguration  buildConfig(){
        CorsConfiguration corsConfiguration=new CorsConfiguration();
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedMethod("*");
        return  corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource  configurationSource=new UrlBasedCorsConfigurationSource();
        configurationSource.registerCorsConfiguration("/**",buildConfig());
        return  new CorsFilter(configurationSource);
    }
}
