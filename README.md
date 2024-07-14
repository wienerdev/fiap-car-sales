<br>
<h1 align="center">
FiapCar Sales API 🚗
</h1>
<br>

[![Pipeline fiap-car-reg](https://github.com/wienerdev/fiap-car-sales/actions/workflows/openshift.yml/badge.svg)](https://github.com/wienerdev/fiap-car-sales/actions/workflows/openshift.yml)

## 💬 Sobre o repositório

O FiapCar consiste em um sistema que é utilizado em uma empresa de revenda de veículos automotores, que disponibiliza uma plataforma para cadastro, vendas, gerenciamento e pagamento de veículos.

## ⚠ Pré-requisitos para execução do projeto

* Java 21
* Maven
* PostgreSQL

## 📌 Como utilizar?

Para utilizar o FiapCar, é necessário ter uma instância de conexão do banco de dados ativa (no caso PostgreSQL), que por padrão fica na porta 5432, caso sua porta esteja diferente, especifique no application.properties em:

```
spring.datasource.url=jdbc:postgresql://localhost:<PORTA_BD>/fiap_car_sales_db
spring.datasource.username=<USUARIO_BD>
spring.datasource.password=<SENHA_BD>
```

Com o banco de dados devidamente configurado, rode a aplicação através do seguinte comando:

*Disponível em http://localhost:8080/

```
mvn spring-boot:run 
```

Com a aplicação rodando, acesse o localhost (porta 8080), e usufrua do sistema!

## Documentação 📒
A documentação da API pode ser acessada em:

[Swagger - Produção](https://fiap-car-sales-wienerdev-dev.apps.sandbox-m4.g2pi.p1.openshiftapps.com/swagger-ui/index.html)

[Swagger - Local](http://localhost:8080/swagger-ui/index.html)

### Entregas do projeto
- [x] Listagem de veículos para venda
- [x] Listagem de veículos vendidos 
- [x] Listagem de todas as vendas
- [x] Venda de veículo
- [x] Reserva de veículo
- [x] Webhook de consulta status de pagamento 

### CI/CD
- [x] Implementar Github Actions
- [x] Cobertura de testes unitários acima de 80%
- [x] Deploy no Openshift

### Infraestrutura
- [x] Cluster Openshift Red Hat.
- [x] Objetos do kubernetes (Deployment, Service, Ingress).
- [x] Banco de dados PostgreSQL OpenShift.

# Evidências

### Cobertura de testes
![image](/images/coverage-fiap-sales.png)

### CI/CD

Github Actions:

![image](/images/car-sales-cicd.png)

### Documentação da API
![image](/images/swagger-sales.png)

### Deploy K8s (Redhat Openshift)

![image](/images/pods-fiap-car.png)

Evidências dos recursos criados no Openshift:

![image](/images/evidencias-infra.png)

### Desenho da arquitetura Hexagonal

![image](/images/fiap-car-hexagonal-arch.png)

### Banco de dados

![image](/images/evidencia-bd.png)

## 🧠 Links importantes

* [Referência para o padrão arquitetural REST](https://restfulapi.net/)
* [Palheta de atalhos de comandos do IntelliJ](https://resources.jetbrains.com/storage/products/intellij-idea/docs/IntelliJIDEA_ReferenceCard.pdf)
* [Site oficial do Spring](https://spring.io/)
* [Site oficial do Spring Initialzr para setup do projeto](https://start.spring.io/)
* [SDKMan! para gerenciamento e instalação do Java e Maven](https://sdkman.io/)

---
