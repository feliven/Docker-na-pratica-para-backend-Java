package br.com.alura.produto.infra.config;

import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@TestConfiguration
@EnableJpaAuditing
@EntityScan("br.com.alura")
@EnableJpaRepositories("br.com.alura")
public class TestJpaConfig {
}
