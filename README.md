# 🎨 Tatiart - Aplicação Web de Produtos Personalizados

Uma aplicação web institucional para a marca Tatiart, especializada em produtos personalizados. O projeto foi desenvolvido com foco em uma identidade visual elegante, moderna e funcional.

| Badge | Tecnologia |
| --- | --- |
| ![Badge do Spring Boot](https://img.shields.io/badge/Spring_Boot-3.4.5-brightgreen) | Spring Boot |
| ![Badge do Java](https://img.shields.io/badge/Java-17-blue) | Java |
| ![Badge do Maven](https://img.shields.io/badge/Maven-blueviolet) | Maven |
| ![Badge do H2](https://img.shields.io/badge/Database-H2-orange) | H2 Database |
| ![Badge do Thymeleaf](https://img.shields.io/badge/Thymeleaf-teal) | Thymeleaf |

## 📖 Sobre o Projeto

**Tatiart** é uma plataforma para a venda de produtos personalizados, incluindo canecas, bolsas, nécessaires, estojos e itens da linha baby. A aplicação foi construída utilizando **Spring Boot** para garantir uma base de código robusta, escalável e de fácil manutenção.

## ✨ Funcionalidades Principais

* **Catálogo de Produtos:** Exibição de produtos organizados por categorias.
* **Páginas de Categoria:** Cada categoria possui sua própria página com produtos, depoimentos e detalhes de personalização.
* **Internacionalização (i18n):** Suporte completo para Português e Inglês.
* **Design Responsivo:** Interface adaptável para desktops e dispositivos móveis.
* **Páginas Institucionais:** Seções "Sobre" e "Produtos" para apresentar a marca.

## 🌐 Internacionalização (i18n)

A aplicação possui suporte a múltiplos idiomas (inglês e português) para alcançar um público global. A implementação foi feita utilizando os recursos nativos do Spring Boot.

* **Como funciona?** A troca de idioma é feita através do parâmetro `lang` na URL.
    * Para visualizar em português: `http://localhost:8080/?lang=pt_BR`
    * Para visualizar em inglês: `http://localhost:8080/?lang=en`

* **Arquivos de Tradução:** As traduções estão centralizadas nos arquivos `messages.properties`:
    * `src/main/resources/messages_pt_BR.properties` (Português)
    * `src/main/resources/messages_en.properties` (Inglês)

* **Configuração:** A lógica de interceptação e resolução do idioma está configurada na classe `br.com.tatiart.config.InternationalizationConfig.java`, que define o `LocaleChangeInterceptor` e o `SessionLocaleResolver`.

## 🚀 Tecnologias Utilizadas

| Finalidade | Tecnologia |
| --- | --- |
| **Backend** | Java 17, Spring Boot 3.4.5, Spring Data JPA |
| **Frontend** | Thymeleaf, Tailwind CSS, JavaScript |
| **Banco de Dados** | H2 (desenvolvimento), PostgreSQL (produção) |
| **Dependências** | Maven |

## 📦 Como Executar o Projeto

Siga os passos abaixo para executar o projeto em seu ambiente local.

### Pré-requisitos:

* Java 17 ou superior
* Maven
* Git

### Passos:

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/daviyoshio/tatiart.git](https://github.com/daviyoshio/tatiart.git)
    cd tatiart
    ```

2.  **Execute a aplicação com o Maven Wrapper:**
    *No Linux/macOS:*
    ```bash
    ./mvnw spring-boot:run
    ```
    *No Windows:*
    ```bash
    mvnw.cmd spring-boot:run
    ```

3.  **Acesse a aplicação:**
    A aplicação estará disponível em `http://localhost:8080`.

## 🗃️ Banco de Dados H2

Para o ambiente de desenvolvimento, o projeto utiliza um banco de dados H2 em memória.

* **URL do Console:** `http://localhost:8080/h2-console`
* **JDBC URL:** `jdbc:h2:file:./data/tatiartdb`
* **Usuário:** `tatiart`
* **Senha:** `tatiart`
