# Game Card


## Aplicativo que consome API e mostra uma listagem de cartas, o usuário consegue ver alguns detalhes clicando na respectiva carta.


## Tecnologias utlizadas:


1. **Android Navigation**: Parte da biblioteca Jetpack, nos auxilia entre a
   navegação das telas do aplicativo, inclusive permite a passagem
   segura de informações entre telas.
2. **Retrofit**: Um completo cliente HTTP para android, nesse caso foi
   utilizado somente para requisições GET e POST
3. **HILT**: Utilizado como Injetor de Dependência, nos poupa trabalho
   quando precisamos referencias objetos que precisam de parâmetros
4. **Timber**: É uma classe de log que não gera logs em produção
5. **Android LiveData**: Também faz parte da biblioteca Jetpack, é uma
   classe que observa dados
6. **Android ViewModel**:  ------------------------------------------,
   cuida da armazenagem e gerenciamento de dados relacionado à UI, como
   por exemplo, manter o estado de um objeto após o usuário rotacionar
   a tela do device, porém nesse caso, foi utilizada para manter o
   princípio de separação de regras de negócio da view como no Design
   Pattern MVVW
7. **GLIDE**: Utilizado para renderizar imagens vindas na API
8. **MVVW**: É um modelo de padrão de projeto recomendado pela Google, que
   tem como objetivo a separação de responsabilidades em camadas
   (model, view, data ...)
9. Entre outras ...

| Device 3,7" | Device 5,5" |
:-------------------------:|:-------------------------:
<img src="https://user-images.githubusercontent.com/18620624/197845689-fd995b6c-66ae-43df-a63f-5e37e4fe632f.png" width="200" heidth="300">  |  <img src="https://user-images.githubusercontent.com/18620624/197845780-f272ba2a-9e43-46f0-9594-b9f38db818df.png" width="200" heidth="300">
