Manual de Sistemas de Locadora em Java - Introdução á Programação Orientada a Objetos
Este Manual apresenta um sistema simples de locadora de
veículos desenvolvido em Java, utilizando os princípios da 
programação orientada a objetos (POO). 
O projeto é composto por quatro classes principais:Carro, Cliente, Locadora e Principal, 
cada uma com funções específicas que se complementam para simular o 
funcionamento de uma locadora.
A classe Carro representa os veículos disponíveis para alugeul.
Ela armazena informações como modelo, ano, cor de disponibilidade
(se o carro está ou não alugado). Essa classe possui dois tipos de
construtores: um que permite criar um objeto sem definir os dados inicialmente,
e outro que já recebe os dados completos. Para acessar ou modificar essas informações,
são utilizados métodos chamados getters e setters. Além disso, há um método que exibe
os dados do carro de forma organizada, facilitando a vizualização pelo usuário.
A classe cliente representa a pessoa que irá alugar o carro. Ela guarda dados como 
CPF, nome e idade. Assim como a classe carro, também possui dois tipos de construtores
e métodos getters e setters para manipulação dos dados. Existe ainda um método que apresenta
as informações do cliente de maneira clara e objetiva.
A classe locadora é responsável por gerenciar os carros e os clientes cadastrados. Ela utiliza 
listas para armazenar os objetos criados e oferece métodos para cadastrar novos carros e clientes,
alugar e devolver veículos, além de listar os carros disponíveis. Quando um carro é alugado, seu
status de disponibilidade é alterado, a ao ser devolvido, ele volta a ficar disponível para novos clientes.
Essa classe funciona como o coração do sistema, conectando os dados e as ações de forma organizada.
Por fim, a classe Principal é o ponto de entrada do programa. Ela cria uma instância da locadora e apresenta
um menu interativo com opções como cadastrar carro, cadastrar cliente, alugar carro, devolver carro e listar os veículos
disponíveis. A interação com o usuário é feita por meio de interface visual, e o sistema também trata possíveis 
erros de entrada, como dados inválidos. A classe Principal é responsável por chamar os métodos das outras 
classes, fazendo com que o sistema funcione de forma integrada e intuitiva.
Este projeto é uma ótima introdução da programação orientada a objetos, pois mostra como dividir responsábilidades entre 
classes e como elas se comunicam para realizar tarefas, com foco em organização, reutilização de código e clareza na construção dos objetos.
