# 📚 Library-Java

> **Idiomas Disponíveis / Available Languages:** [Português](#português) | [English](#english)

---

## Português

Um Sistema de Gerenciamento de Bibliotecas desenvolvido em Java 24, aplicando a arquitetura MVC e utilizando o padrão DAO para interações com o banco de dados. O sistema utiliza MySQL 8.0.42 para persistência de dados e possui uma interface gráfica (GUI) em português.

### ✅ Funcionalidades

- Cadastro e gerenciamento de livros e autores
- Arquitetura MVC para melhor organização e escalabilidade
- Padrão DAO para acesso ao banco de dados de forma limpa e eficiente
- Interface gráfica em português utilizando Java Swing

### 🛠️ Tecnologias

- Java 24
- MySQL 8.0.42
- Java Swing (GUI)
- JDBC (Conexão com banco de dados)

### 🗄️ Configuração do Banco de Dados

#### 1. Localize o arquivo SQL

O arquivo de dump SQL está localizado em:

```
/src/main/resources/dump-library-202505252112.sql
```

#### 2. Restaure o banco de dados

Use o seguinte comando para restaurar o banco de dados:

```bash
mysql -u your_user -p your_database < dump-library-202505252112.sql
```

Substitua `your_user` pelo seu usuário do MySQL e `your_database` pelo nome do banco de dados.

#### 3. Configure o db.properties

O arquivo está localizado em:

```
/src/main/resources/db.properties
```

Edite com as credenciais reais do seu banco de dados:

```properties
db.url=jdbc:mysql://localhost:3306/library
db.user=your_user
db.password=your_password
```

Certifique-se:

- ✅ O banco de dados existe e foi restaurado
- ✅ O usuário e senha correspondem ao seu MySQL
- ✅ A porta 3306 está correta (ou ajuste se necessário)

### 🚀 Como Executar

#### Pré-requisitos

- Java 24 instalado
- MySQL 8.0.42 configurado
- Banco de dados restaurado e db.properties configurado

#### Passos

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/Rafael-de-Sa/Library-Java.git
   ```

2. **Abra o projeto na sua IDE**

3. **Verifique a configuração do banco de dados:**
   - Garanta que o arquivo `/src/main/resources/db.properties` contém as credenciais corretas

4. **Execute a aplicação:**
   - Compile e execute o projeto através da sua IDE

### 📸 Capturas de Tela do Sistema

O sistema possui uma interface gráfica intuitiva desenvolvida em Java Swing, com todas as funcionalidades organizadas de forma clara e acessível.

#### 🏠 Tela Principal
<div align="center">

![Main Screen](./assets/MainScreen.png)

**Interface Principal do Sistema**  
*Tela inicial com acesso às principais funcionalidades: gerenciamento de livros e autores, com menu organizado e design limpo em português.*

</div>

---

#### 👤 Módulo de Gerenciamento de Autores

<table>
<tr>
<td width="50%">

**Cadastro de Novo Autor**
![Author Register](./assets/RegisterAuthor.png)
*Formulário para cadastro de novos autores com campos de validação*

</td>
<td width="50%">

**Edição de Autor Existente**
![Author Update](./assets/AuthorUpdate.png)
*Interface para atualização dos dados de autores já cadastrados*

</td>
</tr>
</table>

**Validação e Tratamento de Erros**
<div align="center">

![Author Error](./assets/AuthorError.png)

*Sistema robusto de validação com mensagens de erro claras e informativas, garantindo que o usuário seja orientado adequadamente durante operações incorretas ou incompletas*

</div>

---

#### 📚 Módulo de Gerenciamento de Livros

<div align="center">

![Book Update](./assets/BookUpdate.png)

**Interface de Atualização de Livros**  
*Tela para edição de informações dos livros, incluindo título, autor, ISBN e outras propriedades relevantes.*

</div>

### 🎨 Características da Interface

- **Design Responsivo**: Interface adaptável com componentes bem organizados
- **Idioma Português**: Todas as labels, botões e mensagens em português brasileiro
- **Validação em Tempo Real**: Feedback imediato para o usuário durante operações
- **Navegação Intuitiva**: Menus e botões organizados de forma lógica
- **Tratamento de Erros**: Mensagens claras e informativas para diferentes situações

---

## English

A simple Library Management System developed in Java 24, applying the MVC architecture and using the DAO pattern for database interactions. The system uses MySQL 8.0.42 for data persistence and provides a graphical user interface (GUI) in Portuguese.

### ✅ Features

- Register and manage books and authors
- MVC architecture for better organization and scalability
- DAO pattern for clean and efficient database access
- GUI in Portuguese using Java Swing

### 🛠️ Technologies

- Java 24
- MySQL 8.0.42
- Java Swing (GUI)
- JDBC (Database connection)

### 🗄️ Database Setup

#### 1. Locate the SQL dump

The SQL dump is located at:

```
/src/main/resources/dump-library-202505252112.sql
```

#### 2. Restore the database

Use the following command to restore the database:

```bash
mysql -u your_user -p your_database < dump-library-202505252112.sql
```

Replace `your_user` with your MySQL user and `your_database` with the name of the database you want to restore.

#### 3. Configure db.properties

The file is located at:

```
/src/main/resources/db.properties
```

Edit it with your actual database credentials:

```properties
db.url=jdbc:mysql://localhost:3306/library
db.user=your_user
db.password=your_password
```

Make sure:

- ✅ The database exists and was restored
- ✅ The user and password match your MySQL configuration
- ✅ The port 3306 is correct (or adjust if necessary)

### 🚀 How to Run

#### Prerequisites

- Java 24 installed
- MySQL 8.0.42 configured
- Database restored and db.properties properly set

#### Steps

1. **Clone the repository:**
   ```bash
   git clone https://github.com/Rafael-de-Sa/Library-Java.git
   ```

2. **Open the project in your IDE**

3. **Check database configuration:**
   - Ensure that `/src/main/resources/db.properties` has your correct MySQL credentials

4. **Run the application:**
   - Compile and run the project via your IDE

### 📸 Screenshots

The system features an intuitive graphical interface developed in Java Swing, with all functionalities organized in a clear and accessible manner.

#### 🏠 Main Screen
<div align="center">

![Main Screen](./assets/MainScreen.png)

**System Main Interface**  
*Initial screen with access to main functionalities: book and author management, with organized menu and clean design in Portuguese.*

</div>

---

#### 👤 Author Management Module

<table>
<tr>
<td width="50%">

**New Author Registration**
![Author Register](./assets/RegisterAuthor.png)
*Form for registering new authors with validation fields*

</td>
<td width="50%">

**Existing Author Editing**
![Author Update](./assets/AuthorUpdate.png)
*Interface for updating data of already registered authors*

</td>
</tr>
</table>

**Validation and Error Handling**
<div align="center">

![Author Error](./assets/AuthorError.png)

*Robust validation system with clear and informative error messages, ensuring users are properly guided during incorrect or incomplete operations*

</div>

---

#### 📚 Book Management Module

<div align="center">

![Book Update](./assets/BookUpdate.png)

**Book Update Interface**  
*Screen for editing book information, including title, author, ISBN and other relevant properties.*

</div>

### 🎨 Interface Features

- **Responsive Design**: Adaptable interface with well-organized components
- **Portuguese Language**: All labels, buttons and messages in Brazilian Portuguese
- **Real-time Validation**: Immediate feedback for users during operations
- **Intuitive Navigation**: Menus and buttons organized in a logical way
- **Error Handling**: Clear and informative messages for different situations

---

## 🙋‍♂️ Autor | Author

**Rafael de Sá**  
[GitHub](https://github.com/Rafael-de-Sa) | [LinkedIn](https://www.linkedin.com/in/rafael-de-sa/)
