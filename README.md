# ❄️ Sistema de Doações de Inverno

Plataforma web desenvolvida em Java com Quarkus que conecta cidadãos a ONGs, permitindo doações de itens e valores para ajudar pessoas em situação de vulnerabilidade durante o inverno.

---

## 🛠️ Tecnologias Utilizadas

- Java 17  
- Quarkus 3.2.5  
- Hibernate ORM com Panache  
- RESTEasy Reactive  
- Oracle Database

---

## 🧱 Arquitetura do Projeto

```
src/main/java/br/sistemadoacoes/
├── model       → Entidades JPA (Usuario, Ong, Doacao)
├── dto         → Objetos de Transferência (DTOs)
├── resource    → Endpoints RESTful da API
├── bo          → Camada de Regras de Negócio (Business Object)
└── exception   → Exceções Personalizadas
```

---

## 🔁 Endpoints da API

### 👤 Usuários

| Método | Rota         | Descrição                         |
|--------|--------------|-----------------------------------|
| POST   | `/register`  | Cadastra um novo usuário          |
| POST   | `/login`     | Autentica um usuário              |
| PUT    | `/update`    | Atualiza dados do usuário         |
| DELETE | `/update`    | Remove usuário com e-mail/senha   |

---

### 🏢 ONGs

| Método | Rota                  | Descrição                              |
|--------|-----------------------|----------------------------------------|
| POST   | `/ong/register`       | Registra uma nova ONG                  |
| GET    | `/ong`                | Lista todas as ONGs                    |
| GET    | `/ong/{id}`           | Busca ONG por ID                       |
| GET    | `/ong/{id}/doacoes`   | Lista as doações recebidas por uma ONG|

---

### 💸 Doações

| Método | Rota           | Descrição                   |
|--------|----------------|-----------------------------|
| POST   | `/help-center` | Realiza uma nova doação     |

---

### 🧾 Perfil do Usuário

| Método | Rota       | Descrição                                |
|--------|------------|------------------------------------------|
| GET    | `/profile` | Retorna dados do usuário e suas doações  |

---

### 📡 Status da API

| Método | Rota   | Descrição                     |
|--------|--------|-------------------------------|
| GET    | `/`    | Verifica se a API está online |

---

## ⚙️ Observações

- O projeto utiliza DTOs para separar entrada de dados da lógica de persistência.
- Toda a lógica de negócio está encapsulada na camada `bo`.
- Exceções personalizadas tratam erros de forma elegante.
- A API está estruturada para integração com front-end moderno (ex: Next.js).

---

## 👨‍💻 Desenvolvedor

**Madjer Finamor**  
🔗 [GitHub](https://github.com/MadjerFin)  
🔗 [LinkedIn](https://www.linkedin.com/in/madjer-finamor-51196117b/)

**Caio Lucas**

🔗 [GitHub](https://github.com/caiolucasxz55)  
🔗 [LinkedIn](https://www.linkedin.com/in/caio-lucas-a892b4324/?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app)
