package com.example.futheadbackend.confs
//
import com.example.futheadbackend.interceptor.PlayerByIdInterceptor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class InterceptorConf(@Autowired @Qualifier("playerByIdInterceptor") val playerByIdInterceptor: PlayerByIdInterceptor) : WebMvcConfigurer {
    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(playerByIdInterceptor).addPathPatterns("/players/**")
    }
}