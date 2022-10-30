# Projeto pulsar

 <div id="top"></div> 

<br />
<div align="center">
  <a href="logo.gif">
    <img src="logo/pulsar.gif" alt="Logo" width="700" height="300" style="border-radius: 50%"/>
  </a>

  
  <h3 align="center"> Pulsares-API</h3>

  <h4 align="center">
     <br />
    <a href="https://github.com/othneildrew/Best-README-Template"><strong>Explore the docs »</strong></a>
    <br />
    <br />
     ·
    <a href="">Reportar Bug</a>
    ·
    <a href="">Soliciatar recurso</a>
  </p>
</div>

 <h3 align="center">
API REST de código aberto para dados de consulta e pesquisa, as informações contida foram desenvolvidas usando como base dados obtidos pela agencia espacial NASA.
<p align="center">
 
<p align="center">
  <a href="https://github.com/Mario23junior/Galaxy-API/runs/7950437483?check_suite_focus=true"><img src="https://github.com/Mario23junior/Galaxy-API/actions/workflows/Maven.yml/badge.svg"></a>
<a href="https://en.wikipedia.org/wiki/Representational_state_transfer"><img src="https://img.shields.io/badge/interface%20-build-green.svg"></a>
</p>


## 🔩 Instruções para uso local

Clone o repositório:

Git:
```
$ git clone https://github.com/Mario23junior/pulsar-api.git
```
Ou baixe um ZIP de main [manualmente](https://github.com/Mario23junior/Galaxy-API/archive/refs/heads/main.zip) e expanda o conteúdo em algum lugar em seu sistema

## 📋  Pré-requisitos

* Tenha um JDK Java11 ou superior instalado
* Tenha o Maven instalado e disponível em seu PATH ou IDE
* Tenha um iterador de APIs para testes HTTP ex: [Postman](https://www.postman.com/downloads/), [Insonia](https://insomnia.rest/download)

 
Se você quiser saber mais sobre o Quarkus, visite o site: https://quarkus.io/ .

## Executando o aplicativo no modo dev

Você pode executar seu aplicativo no modo dev que permite a codificação ao vivo usando:
```script de shell
./mvnw compile quarkus:dev
```

> **_NOTE:_** Quarkus agora vem com uma Dev UI, que está disponível no modo dev apenas em http://localhost:8080/q/dev/.

## Empacotando e executando o aplicativo

O aplicativo pode ser empacotado usando:
```script de shell
./mvnw package
```
Ele produz o arquivo `quarkus-run.jar` no diretório `target/quarkus-app/`.
Esteja ciente de que não é um _über-jar_ pois as dependências são copiadas para o diretório `target/quarkus-app/lib/`.

O aplicativo agora pode ser executado usando `java -jar target/quarkus-app/quarkus-run.jar`.

Se você deseja construir um _über-jar_, execute o seguinte comando:
```script de shell
./mvnw package -Dquarkus.package.type=uber-jar
```

O aplicativo, empacotado como um _über-jar_, agora pode ser executado usando `java -jar target/*-runner.jar`.

## Criando um executável nativo

Você pode criar um executável nativo usando:
```script de shell
./mvnw package -Pnative
```

Ou, se você não tiver o GraalVM instalado, poderá executar a compilação executável nativa em um contêiner usando:
```script de shell
./mvnw pacote -Pnative -Dquarkus.native.container-build=true
```

Você pode então executar seu executável nativo com: `./target/pulsar-1.0-runner`

Se você quiser saber mais sobre como criar executáveis ​​nativos, consulte https://quarkus.io/guides/maven-tooling.

## Guias relacionados

- RESTEasy Classic ([guide](https://quarkus.io/guides/resteasy)): estrutura de endpoint REST implementando JAX-RS e muito mais

## Código fornecido

### RESTEasy JAX-RS

Inicie facilmente seus serviços Web RESTful

[Seção de guia relacionada...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)
