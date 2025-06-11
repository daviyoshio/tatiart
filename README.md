🎨 Tatiart - Aplicação Web de Produtos Personalizados
📖 Sobre o Projeto
Tatiart é uma aplicação web institucional e de e-commerce para a marca Tatiart, especializada na venda de produtos personalizados como canecas, bolsas, nécessaires, estojos e itens da linha baby. A plataforma foi desenvolvida com foco em uma identidade visual elegante, moderna e funcional, oferecendo uma experiência de usuário intuitiva e agradável.

O projeto foi construído utilizando Spring Boot, o que proporciona uma base robusta e de fácil manutenção para a aplicação.

✨ Funcionalidades Principais
Catálogo de Produtos: Exibição de produtos organizados por categorias como "Canecas", "Bolsas", "Nécessaires", "Estojos" e "Linha Baby".
Visualização por Categoria: Cada categoria de produto possui sua própria página, que exibe os itens, depoimentos de clientes e opções de personalização.
Internacionalização: Suporte para múltiplos idiomas (Português e Inglês) para uma experiência de usuário global.
Design Responsivo: Interface adaptável para diferentes tamanhos de tela, garantindo uma boa experiência tanto em desktops quanto em dispositivos móveis.
Páginas Institucionais: Seções "Sobre" e "Produtos" que detalham a história da marca e o processo de personalização.
🚀 Tecnologias Utilizadas
Este projeto foi desenvolvido com as seguintes tecnologias:

Backend:
Java 17
Spring Boot 3.4.5
Spring Data JPA: Para persistência de dados.
Maven: Para gerenciamento de dependências.
Frontend:
Thymeleaf: Motor de templates para renderização de páginas no servidor.
Tailwind CSS: Para estilização da interface.
JavaScript: Para interatividade no lado do cliente.
Banco de Dados:
H2 Database: Banco de dados em memória para desenvolvimento e testes.
PostgreSQL: Dependência incluída para ambiente de produção.
📦 Como Executar o Projeto Localmente
Siga os passos abaixo para executar o projeto em seu ambiente de desenvolvimento:

Pré-requisitos:
Java 17 ou superior instalado.
Maven instalado e configurado.
Uma IDE de sua preferência (ex: IntelliJ, Eclipse, VS Code).
Git para clonar o repositório.
Passos:
Clone o repositório:

Bash

git clone https://github.com/daviyoshio/tatiart.git
Navegue até o diretório do projeto:

Bash

cd tatiart
Execute o projeto com o Maven:
O projeto utiliza o Maven Wrapper, então você não precisa ter o Maven instalado globalmente.

No Linux/macOS:
Bash

./mvnw spring-boot:run
No Windows:
Bash

mvnw.cmd spring-boot:run
Acesse a aplicação:
Após a inicialização, a aplicação estará disponível em http://localhost:8080.

🗃️ Acesso ao Banco de Dados H2
Para desenvolvimento, o projeto está configurado para usar um banco de dados H2 em arquivo, que persiste os dados localmente.

URL do Console H2: http://localhost:8080/h2-console
JDBC URL: jdbc:h2:file:./data/tatiartdb
Usuário: tatiart
Senha: tatiart
🌐 Estrutura do Projeto
O projeto segue a estrutura padrão de uma aplicação Spring Boot:

src/main/java/br/com/tatiart: Contém o código-fonte da aplicação.
config: Classes de configuração do Spring (ex: InternationalizationConfig).
controller: Controladores que gerenciam as requisições web (ex: HomeController, LojaController).
model: Entidades JPA que representam os dados da aplicação (ex: Categoria, Produto, Depoimento).
repository: Interfaces do Spring Data JPA para acesso ao banco de dados (ex: CategoriaRepository, ProdutoRepository).
src/main/resources: Arquivos de configuração e estáticos.
application.properties: Configurações da aplicação, como a conexão com o banco de dados.
messages_pt_BR.properties e messages_en.properties: Arquivos de internacionalização.
static: Arquivos estáticos como CSS e JavaScript.
templates: Arquivos HTML do Thymeleaf.
