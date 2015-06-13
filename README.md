Vraptor-4-template
==========

Dependências
-------------

* [Java 8] (http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [WildFly 8.2] (http://download.jboss.org/wildfly/8.2.0.Final/wildfly-8.2.0.Final.tar.gz) (JBoss AS Tools)
* [Ivy - IvyDe] (https://ant.apache.org/ivy/ivyde)

Instalação
-----------

Baixe o projeto utilizando a linha de comando.

```
git clone https://github.com/imed-pf/dojo-persistence-vraptor-4-jpa-hibernate.git

```
Importe o projeto em seu eclipse, e instale a versão mais recente do plugin JBoss AS Tools.


Baixe a versão do WildFly através do link a seguir

```
http://download.jboss.org/wildfly/8.2.0.Final/wildfly-8.2.0.Final.tar.gz

```
Descompacte o servidor de aplicação em seu ambiente, vinculando e inicializando o servidor com JBoss AS Tools e eclipse.


Baixe a última versão do driver jdbc do PostgreSQL:

```
https://jdbc.postgresql.org/download/postgresql-9.4-1200.jdbc4.jar

```

Volte ao eclipse, selecione o projeto e clique com o botão direito, selecione Ivy e clique na opção Resolve. 

Faça deploy da aplicação e acesse a URL abaixo para testar:

```
http://localhost:8080/vraptor-template

```
