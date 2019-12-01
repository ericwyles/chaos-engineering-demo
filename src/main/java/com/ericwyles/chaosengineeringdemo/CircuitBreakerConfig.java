package com.ericwyles.chaosengineeringdemo;

import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@Slf4j
public class CircuitBreakerConfig {
    @Bean
    public BeanPostProcessor circuitBreakerRegistryPostProcessor() {
        return new BeanPostProcessor() {
            @Override
            public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
                return bean;
            }

            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                if (bean instanceof CircuitBreakerRegistry) {
                    CircuitBreakerRegistry circuitBreakerRegistry = (CircuitBreakerRegistry)bean;
                    circuitBreakerRegistry.circuitBreaker("stockPriceCircuitBreaker").getEventPublisher().onEvent(event -> {
                        log.info("Circuit Breaker {}, Event Type {}, Event Creation Time {}",
                                 event.getCircuitBreakerName(),
                                 event.getEventType(),
                                 event.getCreationTime());
                    });

                }
                return bean;
            }
        };
    }
}
