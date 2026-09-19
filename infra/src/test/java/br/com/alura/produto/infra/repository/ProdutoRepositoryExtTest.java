package br.com.alura.produto.infra.repository;

import br.com.alura.produto.domain.repository.ProdutoRepository;
import br.com.alura.produto.infra.config.JpaConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import static br.com.alura.produto.domain.entity.factory.ProdutoFactory.criarProduto;
import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@DataJpaTest
@ContextConfiguration(classes = JpaConfig.class)
class ProdutoRepositoryExtTest {

    @Autowired
    TestEntityManager em;

    @Autowired
    ProdutoRepository produtoRepository;

    @DisplayName("Quando salvar produto")
    @Nested
    class Save {

        @DisplayName("Entao deve executar com sucesso")
        @Nested
        class Success {

            @DisplayName("Dado um produto com todos os campos")
            @Test
            void test1() {
                // Given
                var produto = criarProduto()
                        .comTodosOsCamposExcetoDB();
                // When
                var actual = produtoRepository.save(produto);
                // Then
                assertThat(actual.getProdutoId())
                        .isNotNull();
            }
        }
    }
}