package br.com.tatiart.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class InternationalizationConfig implements WebMvcConfigurer {

    // Define a fonte das suas traduções
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        // Onde os arquivos de tradução estarão. "messages" é o nome base.
        messageSource.setBasename("classpath:messages"); 
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    // Define qual será o idioma padrão e como ele será armazenado (neste caso, na sessão do usuário)
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        // Define o idioma padrão como Português do Brasil
        slr.setDefaultLocale(new Locale("pt", "BR")); 
        return slr;
    }

    // Permite que o idioma seja alterado via um parâmetro na URL (ex: ?lang=en)
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang"); // Nome do parâmetro na URL para trocar de idioma
        return lci;
    }

    // Registra o interceptador acima no Spring
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
}