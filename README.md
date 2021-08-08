# publicacoes-online-avaliacao

## End-points

### GET

/usuarios retorna todos os seus usuarios 

/usuarios/page retorna todos os usuarios de maneira paginada

/usuarios/{id} retorna um usuário com todos os seus processos e seus processos com todos os seus reus

/usuarios/processos retorna todos os seus processos

### DELETE

/usuarios/{id} deleta o usuário que tem o id passado na url
/usuarios/processos/{id} deleta o processo que tem o id passado na url

### POST

/usuarios adiciona um usuario com processos ou não

/usuarios/processos/{id}/reu adiciona um Réu a um processo de id passado na url

/usuarios/processos/ adiciona um processo sem reu
