
CREATE TABLE Perfil (
id_perfil  INTEGER PRIMARY KEY,
id_filme INTEGER,
Acao INTEGER,
Terror INTEGER,
Suspense INTEGER,
Animacao INTEGER,
Documentario INTEGER,
Comedia INTEGER,
Romance INTEGER,
FOREIGN KEY(id_filme) REFERENCES Filme (id_filme))

CREATE TABLE Filme (
id_filme INTEGER PRIMARY KEY,
Nome VARCHAR(254),
Diretor VARCHAR(254),
Atores VARCHAR(254),
F_idade INTEGER,
Duracao INTEGER,
Data_lance VARCHAR(254)
)

CREATE TABLE Cinema (
id_cinema INTEGER PRIMARY KEY,
Nome VARCHAR(254),
Endereco VARCHAR(254),
Cidade VARCHAR(254)
)

CREATE TABLE Ingresso (
id_engresso INTEGER PRIMARY KEY,
id_filme INTEGER,
Data_filme VARCHAR(254),
Valor DECIMAL,
FOREIGN KEY(id_filme) REFERENCES Filme (id_filme)
)

CREATE TABLE Compras (
id_compras INTEGER PRIMARY KEY,
id_cliente INTEGER,
Data_Compra VARCHAR(254),
Total DECIMAL,
FOREIGN KEY(id_cliente) REFERENCES Cliente (id_cliente)
)

CREATE TABLE Produto (
id_produtro  INTEGER PRIMARY KEY,
Nome VARCHAR(254),
Valor DECIMAL
)

CREATE TABLE Cliente (
id_cliente INTEGER PRIMARY KEY,
Nome VARCHAR(254),
Senha VARCHAR(254),
Email VARCHAR(254)
)

CREATE TABLE Salas (
id_sala INTEGER PRIMARY KEY,
id_cinema INTEGER,
Nome VARCHAR(254),
FOREIGN KEY(id_cinema) REFERENCES Cinema (id_cinema)
)

CREATE TABLE Filmes_Cinemas (
id_cinema INTEGER,
id_filme INTEGER,
FOREIGN KEY(id_cinema) REFERENCES Cinema (id_cinema),
FOREIGN KEY(id_filme) REFERENCES Filme (id_filme)
)

CREATE TABLE Ingresso_Compras (
id_compras INTEGER,
id_engresso INTEGER,
Quantidade INTEGER,
FOREIGN KEY(id_compras) REFERENCES Compras (id_compras),
FOREIGN KEY(id_engresso) REFERENCES Ingresso (id_engresso)
)

CREATE TABLE Compras_Produto (
id_compras INTEGER,
id_produtro  INTEGER,
Quantidade INTEGER,
FOREIGN KEY(id_compras) REFERENCES Compras (id_compras),
FOREIGN KEY(id_produtro ) REFERENCES Produto (id_produtro)
)

