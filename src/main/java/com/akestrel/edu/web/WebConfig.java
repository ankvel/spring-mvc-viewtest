package com.akestrel.edu.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ui.context.ThemeSource;
import org.springframework.ui.context.support.ResourceBundleThemeSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ThemeResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.theme.CookieThemeResolver;
import org.springframework.web.servlet.theme.ThemeChangeInterceptor;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles2.TilesConfigurer;
import org.springframework.web.servlet.view.tiles2.TilesView;

import com.akestrel.edu.model.AksMessage;
import com.akestrel.edu.model.AksMessages;
import com.akestrel.edu.support.StringToDateTimeConverter;
import com.akestrel.edu.web.controller.ControllerConfig;

@EnableWebMvc
@Configuration
@Import({ ControllerConfig.class })
// @ComponentScan("com.akestrel.edu.web.controller")
public class WebConfig extends WebMvcConfigurerAdapter {

	@Bean
	public ThemeResolver themeResolver() {
		CookieThemeResolver themeResolver = new CookieThemeResolver();
		themeResolver.setCookieName("theme");
		themeResolver.setDefaultThemeName("standart");
		return themeResolver;
	}

	@Bean
	public ThemeSource themeSource() {
		ResourceBundleThemeSource themeSource = new ResourceBundleThemeSource();
		themeSource.setBasenamePrefix("com.akestrel.edu.web.themes.");
		return themeSource;
	}

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
		ms.setBasenames("WEB-INF/i18n/messages", "WEB-INF/i18n/application");
		ms.setDefaultEncoding("UTF-8");
		ms.setFallbackToSystemLocale(false);
		return ms;
	}

	@Bean
	public LocaleResolver localeResolver() {
		CookieLocaleResolver localeResolver = new CookieLocaleResolver();
		localeResolver.setCookieName("locale");
		return localeResolver;
	}

	@Bean
	public ViewResolver tilesViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setViewClass(TilesView.class);
		// resolver.setPrefix("/WEB-INF/pages/");
		// resolver.setSuffix(".jsp");

		return resolver;
	}

	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer
				.setDefinitions(new String[] { "/WEB-INF/layouts/layouts.xml" });

		return tilesConfigurer;
	}

	// FIXME delete this
	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		registry.addInterceptor(localeChangeInterceptor);

		ThemeChangeInterceptor themeChangeInterceptor = new ThemeChangeInterceptor();
		registry.addInterceptor(themeChangeInterceptor);

		// registry.addInterceptor(new SomeHandlerInterceptor());
	}

	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("home");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**")
				.addResourceLocations("/WEB-INF/resources/")
				.setCachePeriod(31556926);
	}

	private final Class<?>[] JAXB_CLASSES_TO_BE_BOUND = { AksMessage.class,
			AksMessages.class };

	@Bean
	public RequestMappingHandlerAdapter getHandlerAdapter() {
		List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
		converters.add(new StringHttpMessageConverter());

		Jaxb2Marshaller m = new Jaxb2Marshaller();
		m.setClassesToBeBound(JAXB_CLASSES_TO_BE_BOUND);

		MarshallingHttpMessageConverter converter = new MarshallingHttpMessageConverter();
		converter.setMarshaller(m);
		converter.setUnmarshaller(m);
		converters.add(converter);

		converters.add(new FormHttpMessageConverter());
		converters.add(new ByteArrayHttpMessageConverter());
		converters.add(new BufferedImageHttpMessageConverter());
		// converters.add(new MappingJacksonHttpMessageConverter());

		RequestMappingHandlerAdapter adapter = new RequestMappingHandlerAdapter();

		adapter.setMessageConverters(converters);

		return adapter;

	}

	/*@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new StringToDateTimeConverter("dd/MM/yyyy"));		
	}*/

}
