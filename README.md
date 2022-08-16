<h1> FarmaciaJDBC <h1>

> Status: Concluído


## Conteúdo:
<h4>Aplicação completa e executável direto de sistema operacional de cadastro de clientes, medicamentos, criação de pedidos, logs de registros e manipulação de estoque 
com a implementação de CRUD de acordo à usuabilidade de cada classe. 
Aplicação toda gerada em JDBC e Javax com intúito de estudo para domínio das funções lógicas de integração com o banco de dados com o Data Access Object. </h4>


##<h4>Tecnologias utilizadas
+ Java
+ MySQL
+ Windows Builder

<hr>


<i><b>A execução de um POST endpoint:</i></b>
<p> 
 A classe ClienteDaoJDBC instanciada por método de DaoFabrica, carrega as propriedades de conexão (Connection) com o banco de dados. 
 Assim executa o método (POST) inserirCliente(); que recebe quatro variáveis inseridas em .textfields(); pelo usuário na interface.
 Então um objeto PreparedStatement recebe a query de inserção em MySQL em junção com as variáveis de entrada.
 Tendo esse mesmo objeto PreparedStatement sendo executado com .executeUpdate(); com sucesso retorna a linha afetada que através do método RETURN_GENERATED_KEYS torna o id que foi inserido no banco de dados retornável através de um ResultSet recebendo este PreparedStatement com o método getGenaratedKeys(); <p>

<hr>

<br/>

<p> <i>Desenvolvimento dos métodos CRUD e lógica das regras de négocio em DAO. Estruturação das propriedades de conexão com o Banco de Dados; MER, DER e esquemas relacionais no MySQL</i> realizados por :<b>Fábio Bonfim Vilela.</> <br/><br/>

<i>Desenvolvimento do design da aplicação, lógica de funcionamento relacional, aplicação e adaptação dos fluxos de execução de interface. Testes individuais de funções  e distribuição das mesmas no layout</i> realizadas por : <b>Rafael Souza</b>


<br/><br/><br/>


 





