# code-donus
projeto backend do Challenge Code 

Para iniciar o projeto pasta fazer clone na sua máquina, abrir com sua IDE e subir o projeto.
Nele vai conter um SQL com 2 usuários para não ter a necessidade de sempre ficar criando toda hora um novo pelo endpoint.
Usei o banco H2 para teste justamente por ser um projeto mais simples e você conseguir usa-lo pelo próprio browser.
Eu criei toda a regra de negócio no pacote Service que trabalha com a transferência de uma conta para outro e deposito em uma conta.

Criei apenas 2 classes, ContaBancaria onde simula uma conta real que possui alguns dados do cliente da aplicação e a outra classe de Transferencia, ela é responsável por ser uma intermediadora das transferências, onde ela necessita o número das contas e o valor da transferência , por exemplo:

"O Rennan gostaria de fazer uma transferência para o João, logo ele coloca o número da sua conta e transfere para a conta destino de João ". 

Nesse caso a conta de origem é da pessoa quem vai realizar uma transferência para outra conta que seria a conta de destino, que seria:

Rennan, contaOrigem "1234" vai realizar uma transferência para o João que possui a contaDestino "6789".

No caso do Depósito funciona da mesma forma, porém o depósito é feito direto na contaDestino, que seria a própria pessoa colocando dinheiro lá e não uma outra conta.

Vou deixar abaixo a URL para usar no Postman juntamente ao body.


TRANSAÇÃO:

http://localhost:8080/transacao

{
    "contaOrigem": "12345",
    "valorTransferencia": 200,
    "contaDestino": "67890"
}

DEPÓSITO

http://localhost:8080/transacao/deposito

{
    "valorTransferencia": 200.0,
    "contaDestino": "67890"
}
