
CREATE TABLE Cliente (
id_cliente BIGSERIAL PRIMARY KEY,
Nome VARCHAR(254),
Senha VARCHAR(254),
Email VARCHAR(254)
)

CREATE TABLE Filme (
id_filme BIGSERIAL PRIMARY KEY,
Nome VARCHAR(254),
Diretor VARCHAR(254),
Elenco VARCHAR(254),
Classificacao INTEGER,
Sinopse VARCHAR(5000),
Duracao INTEGER,
DataLancamento VARCHAR(254),
Genero VARCHAR(254)
);



create TABLE Perfil (
	id_perfil  BIGSERIAL PRIMARY KEY,
	id_filme INTEGER,
	Acao INTEGER,
	Terror INTEGER,
	Suspense INTEGER,
	Animacao INTEGER,
	Documentario INTEGER,
	Comedia INTEGER,
	Romance INTEGER,
	FOREIGN KEY(id_filme) REFERENCES Filme (id_filme)
);
CREATE TABLE Cinema (
id_cinema BIGSERIAL PRIMARY KEY,
Nome VARCHAR(254),
Endereco VARCHAR(254),
Cidade VARCHAR(254),
Telefone varchar(254)
)

CREATE TABLE Ingresso (
id_engresso SERIAL PRIMARY KEY,
id_filme INTEGER,
Data_filme VARCHAR(254),
Valor DECIMAL,
FOREIGN KEY(id_filme) REFERENCES Filme (id_filme)
)

CREATE TABLE Compras (
id_compras BIGSERIAL PRIMARY KEY,
id_cliente INTEGER,
Data_Compra VARCHAR(254),
Total DECIMAL,
FOREIGN KEY(id_cliente) REFERENCES Cliente (id_cliente)
)

CREATE TABLE Produto (
idProduto  BIGSERIAL PRIMARY KEY,
NomeProduto VARCHAR(254),
TipoProduto VARCHAR(254),
PrecoProduto DECIMAL,
QtdProduto INTEGER
)

Create TABLE Perfil_cliente(
id_perfil  BIGSERIAL PRIMARY KEY,
id_cliente INTEGER,
Acao INTEGER,
Terror INTEGER,
Suspense INTEGER,
Animacao INTEGER,
Documentario INTEGER,
Comedia INTEGER,
Romance INTEGER,
FOREIGN KEY(id_cliente) REFERENCES Cliente (id_cliente))


CREATE TABLE Salas (
id_sala BIGSERIAL PRIMARY KEY,
id_cinema INTEGER,
Nome VARCHAR(254),
FOREIGN KEY(id_cinema) REFERENCES Cinema (id_cinema)
)

CREATE TABLE Filmes_Cinemas (
id_cinema BIGSERIAL,
id_filme INTEGER,
FOREIGN KEY(id_cinema) REFERENCES Cinema (id_cinema),
FOREIGN KEY(id_filme) REFERENCES Filme (id_filme)
)

CREATE TABLE Ingresso_Compras (
id_compras BIGSERIAL,
id_engresso INTEGER,
Quantidade INTEGER,
FOREIGN KEY(id_compras) REFERENCES Compras (id_compras),
FOREIGN KEY(id_engresso) REFERENCES Ingresso (id_engresso)
)

CREATE TABLE Compras_Produto (
id_compras INTEGER,
id_produto  INTEGER,
Quantidade INTEGER,
FOREIGN KEY(id_compras) REFERENCES Compras (id_compras),
FOREIGN KEY(id_produto) REFERENCES Produto (idProduto)
)

drop table filme cascade;


CREATE TABLE Filme (
id_filme SERIAL PRIMARY KEY,
Nome VARCHAR(254),
Diretor VARCHAR(254),
Elenco VARCHAR(254),
Classificacao Varchar(254),
Sinopse VARCHAR(5000),
Duracao INTEGER,
DataLancamento VARCHAR(254),
Genero VARCHAR(254),
imagem varchar(254)
);

drop table Perfil cascade;

create TABLE Perfil (
	id_perfil  SERIAL PRIMARY KEY,
	id_filme INTEGER,
	Acao INTEGER,
	Terror INTEGER,
	Suspense INTEGER,
	Animacao INTEGER,
	Documentario INTEGER,
	Comedia INTEGER,
	Romance INTEGER,
	drama integer,
	FOREIGN KEY(id_filme) REFERENCES Filme (id_filme)
);

insert into filme(nome , diretor, elenco , classificacao, sinopse , duracao ,datalancamento ,genero , imagem)
values('DeadPool','Tim MIller', 'Ryan Reynolds, Morena Baccarin, Ed Skrein', 16, 'Ex-militar e mercenário, Wade Wilson 
(Ryan Reynolds) é diagnosticado com câncer em estado terminal, porém encontra uma possibilidade de cura em
uma sinistra experiência científica. Recuperado, com poderes e um incomum senso de humor, ele torna-se Deadpool
 (...)', 120 , '11/02/2016' ,'Ação','deadpool.jpg');

insert into Perfil( id_filme , acao , terror , suspense, animacao , documentario ,comedia , romance , drama)
values(1 , 5 , 2, 0, 0, 0 , 5 , 3, 2);

insert into filme(nome , diretor, elenco , classificacao, sinopse , duracao ,datalancamento , genero , imagem)
values('Zootopia',' Byron Howard, Rich Moore, Jared Bush',' Jared Bush, Phil Johnston', 10, 
'Zootopia é uma cidade diferente de tudo o que você já viu. Formada por "bairros-habitat", como a elegante Praça
 Sahara e a gelada Tundralândia, essa metrópole abriga uma grande diversidade de animais irreverentes sempre
  prontos para encarar uma nova e divertida aventura.Quando Judy Hopps (voz de Monica Iozzi) chega em Zootopia,
   ela descobre que ser a primeira coelha da equipe da polícia, formada por animais grandes e fortes, não é nada
    fácil. Determinada a provar seu valor, ela embarca em uma aventura atrapalhada e bem humorada, ao lado do 
    malandro raposo Nick Wilde (voz de Rodrigo Lombardi) para desvendar um grande mistério.', 108 , '10/02/2016' 
, 'Animação' ,'Zootopia.jpg');

insert into Perfil( id_filme , acao , terror , suspense, animacao , documentario ,comedia , romance , drama)
values(2 , 0 , 0, 0, 5, 0 , 5 , 2,2);

insert into filme(nome , diretor, elenco , classificacao, sinopse , duracao ,datalancamento ,genero , imagem)
values('O Regresso',' Alejandro González Iñárritu', 'Leonardo DiCaprio, Tom Hardy, Domhnall Gleeson ...', 16,
'1822. Hugh Glass (Leonardo DiCaprio) parte para o oeste americano disposto a ganhar dinheiro caçando. 
Atacado por um urso, fica seriamente ferido e é abandonado à própria sorte pelo parceiro John Fitzgerald 
(Tom Hardy), que ainda rouba seus pertences. Entretanto, mesmo com toda adversidade, Glass consegue sobreviver
 e inicia uma árdua jornada em busca de vingança.', 156 , '04/02/2016' ,'Faroeste, Aventura','regresso.jpg');

insert into Perfil( id_filme , acao , terror , suspense, animacao , documentario ,comedia , romance , drama)
values(3 , 3 , 0, 3, 0, 2 , 1 , 3, 5);

insert into filme(nome , diretor, elenco , classificacao, sinopse , duracao ,datalancamento ,genero , imagem)
values('CAPITÃO AMÉRICA',' Anthony Russo, Joe Russo', ' Chris Evans, Robert Downey Jr., Scarlett
 Johansson mais..', 12,'Steve Rogers (Chris Evans) é o atual líder dos Vingadores, super-grupo de heróis formado 
 por Viúva Negra (Scarlett Johansson), Feiticeira Escarlate (Elizabeth Olsen), Visão (Paul Bettany), Falcão 
 (Anthony Mackie) e Máquina de Combate (Don Cheadle). O ataque de Ultron fez com que os políticos buscassem 
 algum meio de controlar os super-heróis, já que seus atos afetam toda a humanidade. Tal decisão coloca o
  Capitão América em rota de colisão com Tony Stark (Robert Downey Jr.), o Homem de Ferro.', 148 , '28/04/2016' ,' Ação, Fantasia',
  'capitao-america.png');
  
insert into Perfil( id_filme , acao , terror , suspense, animacao , documentario ,comedia , romance , drama)
values(4 , 5 , 0, 3, 0, 3 , 5 , 2, 3);

insert into filme(nome , diretor, elenco , classificacao, sinopse , duracao ,datalancamento ,genero , imagem)
values('WARCRAFT','Duncan Jones', ' Travis Fimmel, Toby Kebbell, Paula Patton mais'
, 12, 'A região de Azeroth sempre viveu em paz, até a chegada dos guerreiros Orc. Com a abertura de um portal,
 eles puderam chegar à nova Terra com a intenção de destruir o povo inimigo. Cada lado da batalha possui um 
 grande herói, e os dois travam uma disputa pessoal, colocando em risco seu povo, sua família e todas as pessoas
  que amam.', 124 , '02/06/2016' ,' Ação, Aventura','warcraft.jpg');

insert into Perfil( id_filme , acao , terror , suspense, animacao , documentario ,comedia , romance , drama)
values(5 , 5 , 0, 0, 4, 3 , 2 , 3, 4);


insert into filme(nome , diretor, elenco , classificacao, sinopse , duracao ,datalancamento ,genero , imagem)
values('BATMAN VS SUPERMAN ',' Zack Snyder', ' Ben Affleck, Henry Cavill, Jesse Eisenberg mais'
, 12, 'O confronto entre Superman (Henry Cavill) e Zod (Michael Shannon) em Metrópolis fez com que a população 
mundial se dividisse acerca da existência de extra-terrestres na Terra. Enquanto muitos consideram o Superman
 como um novo deus, há aqueles que consideram extremamente perigoso que haja um ser tão poderoso sem qualquer 
 tipo de controle. Bruce Wayne (Ben Affleck) é um dos que acreditam nesta segunda hipótese. Sob o manto de um 
 Batman violento e obcecado, ele investiga o laboratório de Lex Luthor (Jesse Eisenberg), que descobriu uma 
 pedra verde que consegue eliminar e enfraquecer os filhos de Krypton.', 153 , '24/03/2016' ,' Ação, Fantasia',
 'BatmanSuperman.jpg');

insert into Perfil( id_filme , acao , terror , suspense, animacao , documentario ,comedia , romance , drama)
values(6 , 5 , 0, 2, 3, 2 , 2 , 0, 1);

insert into filme(nome , diretor, elenco , classificacao, sinopse , duracao ,datalancamento ,genero , imagem)
values('MAD MAX',' George Miller', ' Tom Hardy, Charlize Theron, Zoë Kravitz mais'
, 16, 'Após ser capturado por Immortan Joe, um guerreiro das estradas chamado Max (Tom Hardy) se vê no meio de 
uma guerra mortal, iniciada pela Imperatriz Furiosa (Charlize Theron) na tentativa se salvar um grupo de garotas.
 Também tentanto fugir, Max aceita ajudar Furiosa em sua luta contra Joe e se vê dividido entre mais uma vez 
 seguir sozinho seu caminho ou ficar com o grupo.', 120 , '14/05/2015' ,'  Ação, Ficção científica','Mad-Max.jpg');

insert into Perfil( id_filme , acao , terror , suspense, animacao , documentario ,comedia , romance , drama)
values(7 , 5 , 0, 1, 0, 3 , 3 , 3, 3);

insert into filme(nome , diretor, elenco , classificacao, sinopse , duracao ,datalancamento ,genero , imagem)
values('INTERESTELAR','Christopher Nolan', 'Matthew McConaughey, Anne Hathaway, Michael Caine mais', 10, 'Após
 ver a Terra consumindo boa parte de suas reservas naturais, um grupo de astronautas recebe a missão de verificar
  possíveis planetas para receberem a população mundial, possibilitando a continuação da espécie. Cooper
   (Matthew McConaughey) é chamado para liderar o grupo e aceita a missão sabendo que pode nunca mais ver
    os filhos. Ao lado de Brand (Anne Hathaway), Jenkins (Marlon Sanders) e Doyle (Wes Bentley), ele seguirá em
busca de uma nova casa. Com o passar dos anos, sua filha Murph (Mackenzie Foy e Jessica Chastain) investirá 
numa própria jornada para também tentar salvar a população do planeta.', 180 , '06/11/2014' ,'  Ficção científica, Drama',
'interstelar.jpg');

insert into Perfil( id_filme , acao , terror , suspense, animacao , documentario ,comedia , romance , drama)
values(8 , 2 , 0, 2, 0, 3 , 2 , 4, 5);


insert into filme(nome , diretor, elenco , classificacao, sinopse , duracao ,datalancamento ,genero , imagem)
values('VIZINHOS 2',' Nicholas Stoller', 'Seth Rogen, Zac Efron, Rose Byrne mais', 16, 'Com um novo bebê a 
caminho, Mac (Seth Rogen) e Kelly Radner (Rose Byrne) decidem vender a casa e mudar-se para o subúrbio. Entretanto,
 uma nova fraternidade, mais estrondosa que seus antigos vizinhos, assumem a casa ao lado. Liderada por Shelby
  (Chloë Grace Moretz), as meninas do Kappa Nu pretendem mostrar que sabem fazer uma festa bem melhor que os 
  meninos. A fim de que a paz na vizinhança seja restaurada e a venda de sua casa concretizada, Mac e Kelly 
  convocam sua arma secreta: Teddy (Zac Efron).', 120 , '19/05/2016' ,'Comédia','vizinhos2.jpg');

insert into Perfil( id_filme , acao , terror , suspense, animacao , documentario ,comedia , romance , drama)
values(9 , 2 , 0, 0, 0, 0 , 5 , 2, 0);

insert into filme(nome , diretor, elenco , classificacao, sinopse , duracao ,datalancamento ,genero , imagem)
values('X-MEN: ',': Bryan Singer', 'James McAvoy, Michael Fassbender, Jennifer Lawrence mais', 12, 
'Também conhecido como Apocalipse, En Sabah Nur (Oscar Isaac) é o mutante original. Após milhares da anos, ele 
volta a vida disposto a garantir sua supremacia e acabar com a humanidade. Ele seleciona quatro Cavaleiros nas 
figuras de Magneto (Michael Fassbender), Psylocke (Olivia Munn), Anjo (Ben Hardy) e Tempestade (Alexandra Shipp).
 Do outro lado, o professor Charles Xavier (James McAvoy) conta com uma série de novos alunos, como Jean Grey 
 (Sophie Turner), Ciclope (Tye Sheridan) e Noturno (Kodi Smit-McPhee), além de caras conhecidas como Mística 
 (Jennifer Lawrence), Fera (Nicholas Hoult) e Mercúrio (Evan Peters), para tentar impedir o vilão.', 
 144 , '19/05/2016' ,' Ação, Ficção científica, Fantasia','x-men.jpg');

insert into Perfil( id_filme , acao , terror , suspense, animacao , documentario ,comedia , romance , drama)
values(10, 5 , 0, 0, 2, 2 , 4 , 2, 4);

insert into Cliente (nome, senha, email)
values ("jao","abc","haha@haha.com");




