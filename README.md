# Ujay Java Challenge

Estudo sobre as rentabilidades mensais de um fundo de investimento.

 O código pede para ser inserido uma url de consulta para rentabilidades diárias, com conteúdo no seguinte formato: dd/MM/yyyy;rentabilidade.

Considerando que a rentabilidade de um mês é a soma de todas as rentabilidades diárias daquele mesmo mês, o programa baixa os dados do endereço e lista, no formato "MM/yyyy: rentabilidade" e em ordem descrecente, as rentabilidades de todos os meses presentes no arquivo, até a útlima data disponível.

O código utiliza uma classe chamada "MonthReturns" que tem como atributo o nome do mês em String no formato "MM/yyyy" e uma lista de valores de rentabilidades. 
Conforme lê o conteúdo da URL o código cria esses objetos lendo linha por linha e os armazena em um HashMap com os índices sendo os nomes dos meses e o conteúdo sendo os objetos criados com os valores de rentabilidades.

Ao final o programa cria um HashMap novo, mas apenas com os nomes do meses e suas respectivas somas de rentabilidades diárias como resultado.

# Java JDK 21 (LTS)

