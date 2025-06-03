🎨 **Tatiart**

Aplicação web institucional da marca **Tatiart**, desenvolvida com **Spring Boot**. A plataforma apresenta produtos personalizados como canecas, bolsas e nécessaires, com foco em uma identidade visual elegante, moderna e funcional.

---

🚀 **Tecnologias Utilizadas**

- Java 17  
- Spring Boot 3.4.5  
- Spring Data JPA  
- Thymeleaf  
- Banco de dados H2 (persistente localmente e no Railway)  
- Maven  

---

💾 **Persistência com H2**

A aplicação usa um banco de dados **H2 persistente**, salvo em arquivo local (`./data/tatiartdb.mv.db`).  
Esse banco continua funcional **mesmo após reinicializações**, inclusive em ambientes como **Railway (free plan)**.

Para acessar o console localmente:

http://localhost:8080/h2-console

- JDBC URL: `jdbc:h2:file:./data/tatiartdb`
- Usuário: `tatiart`
- Senha: `tatiart`

---

📦 **Como rodar o projeto localmente**

### Pré-requisitos:
- Java 17
- Maven
- IDE (IntelliJ, Eclipse ou VS Code)

### Passos:

1. Clone o repositório:

```bash
git clone https://github.com/daviyoshio/tatiart.git
cd tatiart

