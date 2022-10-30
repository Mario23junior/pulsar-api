# Projeto pulsar

Este projeto usa Quarkus, o Supersonic Subatomic Java Framework.

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
