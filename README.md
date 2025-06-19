# 🎨 Tatiart - Catálogo de Produtos Personalizados

Uma aplicação web institucional e catálogo online para a marca Tatiart, especializada na apresentação de produtos personalizados. O projeto foi desenvolvido com foco em uma identidade visual elegante e funcional, e otimizado com técnicas de SEO para garantir maior visibilidade online.

| Badge | Tecnologia |
| --- | --- |
| ![Badge do Spring Boot](https://img.shields.io/badge/Spring_Boot-3.4.5-brightgreen) | Spring Boot |
| ![Badge do Java](https://img.shields.io/badge/Java-17-blue) | Java |
| ![Badge do Maven](https://img.shields.io/badge/Maven-blueviolet) | Maven |
| ![Badge do H2](https://img.shields.io/badge/Database-H2-orange) | H2 Database |
| ![Badge do Thymeleaf](https://img.shields.io/badge/Thymeleaf-teal) | Thymeleaf |

## 📖 Sobre o Projeto

**Tatiart** é uma plataforma para a exibição e divulgação de produtos personalizados, incluindo canecas, bolsas, necessaires, estojos e itens da linha baby. A aplicação foi construída utilizando **Spring Boot** para garantir uma base de código robusta e escalável, servindo como um portfólio digital para que clientes possam conhecer os produtos e entrar em contato.

---

## ✨ Otimizações de SEO Implementadas

Para garantir que o site seja facilmente encontrado e bem ranqueado em mecanismos de busca como o Google, foram implementadas as seguintes estratégias de SEO:

### 1. Base Técnica para Indexação
* **Sitemap Dinâmico (`sitemap.xml`):** Foi criado um endpoint que gera automaticamente um `sitemap.xml`. Este mapa do site lista todas as páginas estáticas (Home, Sobre, Produtos) e dinâmicas (cada categoria de produto), garantindo que os buscadores descubram e indexem todo o conteúdo de forma eficiente.
* **Arquivo de Orientações (`robots.txt`):** O arquivo `robots.txt` foi configurado para instruir os robôs de busca sobre como rastrear o site, permitindo a indexação completa e apontando a localização do sitemap.

### 2. Otimização On-Page
* **Títulos e Metadados Otimizados:** Todas as páginas principais (`index`, `sobre`, `produtos` e `pagina_categoria`) agora possuem:
    * **Títulos (`<title>`) e Descrições (`<meta name="description">`)** únicos e relevantes para o conteúdo.
    * **Tags Open Graph** para garantir que os links sejam exibidos de forma atraente quando compartilhados em redes sociais.
    * **Links Canônicos (`<link rel="canonical">`)** para evitar problemas de conteúdo duplicado.
* **Conteúdo Dinâmico e SEO:** Nas páginas de categoria, os títulos e descrições são gerados dinamicamente com base na categoria visualizada, criando conteúdo altamente relevante para cada seção do site.

### 3. Semântica e Estrutura de Conteúdo
* **Hierarquia de Títulos:** A estrutura de títulos foi revisada para seguir as melhores práticas de SEO, como o uso correto da tag `<h1>` para o título principal de cada página.
* **URLs Amigáveis:** A estrutura das URLs foi melhorada para ser mais semântica e descritiva (ex: `/produtos/canecas`), o que facilita a compreensão tanto para usuários quanto para os buscadores.

### 4. SEO Multilíngue
* **Integração com i18n:** Todas as otimizações de títulos e descrições foram integradas ao sistema de internacionalização, permitindo que o SEO seja eficaz tanto em português quanto em inglês.

---

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
    * No Linux/macOS:
        ```bash
        ./mvnw spring-boot:run
        ```
    * No Windows:
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
