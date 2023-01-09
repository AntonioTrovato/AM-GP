INSERT INTO `amgp`.`utente`
(`id`,
`password`,
`ruolo`,
`nome`,
`cognome`)
VALUES
("AAAAAAAAAAAAAA",
"passwordProva1?+",
"tecnico",
"Pietro",
"Negri");

INSERT INTO `amgp`.`utente`
(`id`,
`password`,
`ruolo`,
`nome`,
`cognome`)
VALUES
("AAAAAAAAAAAAAB",
"passwordProva2?+",
"tecnico",
"Mafalda",
"Ingenito");

INSERT INTO `amgp`.`utente`
(`id`,
`password`,
`ruolo`,
`nome`,
`cognome`)
VALUES
("AAAAAAAAAAAAAF",
"passwordProva3?+",
"tecnico",
"Antonio",
"Trovato");


INSERT INTO `amgp`.`utente`
(`id`,
`password`,
`ruolo`,
`nome`,
`cognome`)
VALUES
("AAAAAAAAAAAAAC",
"passwordProva4?+",
"pilota",
"Giovanni",
"Renzulli");


INSERT INTO `amgp`.`utente`
(`id`,
`password`,
`ruolo`,
`nome`,
`cognome`)
VALUES
("AAAAAAAAAAAAAD",
"passwordProva5?+",
"pilota",
"Charles",
"LeClerc");


INSERT INTO `amgp`.`utente`
(`id`,
`password`,
`ruolo`,
`nome`,
`cognome`)
VALUES
("AAAAAAAAAAAAAZ",
"passwordProva76?+",
"tecnico",
"Luca",
"De Marinis");

INSERT INTO `amgp`.`pilota`
(`fk_utente`,
`punteggio`,
`numvittorie`,
`numpole`,
`numpiazz`,
`numritiri`)
VALUES
("AAAAAAAAAAAAAC",
145,
3,
4,
7,
2);

INSERT INTO `amgp`.`pilota`
(`fk_utente`,
`punteggio`,
`numvittorie`,
`numpole`,
`numpiazz`,
`numritiri`)
VALUES
("AAAAAAAAAAAAAD",
210,
4,
6,
10,
0);


INSERT INTO `amgp`.`circuito`
(idcircuito,
`nome`,
`sede`,
`lunghezza`,
`meteo`,
`tpm`,
`rpm`,
`umidita`,
`ngiri`)
VALUES
(10,
"Spa-Francorchamps",
"Belgio",
7004,
"Pioggia",
110.5876,
108.564,
55,
67);

INSERT INTO `amgp`.`curva`
(
`nome`,
`angolo`,
`fk_circuito`)
VALUES
(
"La Source",
90,
10);

INSERT INTO `amgp`.`curva`
(
`nome`,
`angolo`,
`fk_circuito`)
VALUES
(
"Raidillon de L'Eau Rouge",
38,
10);

INSERT INTO `amgp`.`curva`
(
`nome`,
`angolo`,
`fk_circuito`)
VALUES
(
"Les Combes",
45,
10);

INSERT INTO `amgp`.`curva`
(
`nome`,
`angolo`,
`fk_circuito`)
VALUES
(
"Bruxelles",
45,
10);

INSERT INTO `amgp`.`curva`
(
`nome`,
`angolo`,
`fk_circuito`)
VALUES
(
"Pouhoun 1",
67,
10);

INSERT INTO `amgp`.`curva`
(
`nome`,
`angolo`,
`fk_circuito`)
VALUES
(
"Pouhoun 2",
68,
10);

INSERT INTO `amgp`.`curva`
(
`nome`,
`angolo`,
`fk_circuito`)
VALUES
(
"Fagnes",
69,
10);

INSERT INTO `amgp`.`curva`
(
`nome`,
`angolo`,
`fk_circuito`)
VALUES
(
"Campus",
45,
10);

INSERT INTO `amgp`.`curva`
(
`nome`,
`angolo`,
`fk_circuito`)
VALUES
(
"Blanchimont",
45,
10);

INSERT INTO `amgp`.`rettilineo`
(
`nome`,
`lunghezza`,
`fk_circuito`)
VALUES
(
"Kemmel",
770,
10);

INSERT INTO `amgp`.`rettilineo`
(
`nome`,
`lunghezza`,
`fk_circuito`)
VALUES
(
"Paul Frere",
340,
10);


INSERT INTO `amgp`.`circuito`
(idcircuito,
`nome`,
`sede`,
`lunghezza`,
`meteo`,
`tpm`,
`rpm`,
`umidita`,
`ngiri`)
VALUES
(
11,
"Circuito di Albert-Park",
"Australia",
5303,
"Sole",
97.578,
84.125,
33,
81);

INSERT INTO `amgp`.`rettilineo`
(
`nome`,
`lunghezza`,
`fk_circuito`)
VALUES
(
"Walker",
750,
11);

INSERT INTO `amgp`.`curva`
(
`nome`,
`angolo`,
`fk_circuito`)
VALUES
(
"Clark 1",
34,
11);

INSERT INTO `amgp`.`curva`
(
`nome`,
`angolo`,
`fk_circuito`)
VALUES
(
"Clark 2",
38,
11);

INSERT INTO `amgp`.`curva`
(
`nome`,
`angolo`,
`fk_circuito`)
VALUES
(
"Ascari 1",
46,
11);

INSERT INTO `amgp`.`curva`
(
`nome`,
`angolo`,
`fk_circuito`)
VALUES
(
"Ascari 2",
46,
11);


INSERT INTO `amgp`.`circuito`
(idcircuito,
`nome`,
`sede`,
`lunghezza`,
`meteo`,
`tpm`,
`rpm`,
`umidita`,
`ngiri`)
VALUES
(12,
"Autodromo Internazionale Enzo e Dino Ferrari",
"Imola",
4909,
"Sole",
83.578,
75.155,
33,
56);

INSERT INTO `amgp`.`curva`
(
`nome`,
`angolo`,
`fk_circuito`)
VALUES
(
"Variante Tamburello 1",
46,
12);

INSERT INTO `amgp`.`curva`
(
`nome`,
`angolo`,
`fk_circuito`)
VALUES
(
"Variante Tamburello 2",
52,
12);

INSERT INTO `amgp`.`curva`
(
`nome`,
`angolo`,
`fk_circuito`)
VALUES
(
"Variante Tamburello 3",
31,
12);

INSERT INTO `amgp`.`curva`
(
`nome`,
`angolo`,
`fk_circuito`)
VALUES
(
"Variante Villeneuve 1",
48,
12);

INSERT INTO `amgp`.`curva`
(
`nome`,
`angolo`,
`fk_circuito`)
VALUES
(
"Variante Villeneuve 2",
34,
12);

INSERT INTO `amgp`.`curva`
(
`nome`,
`angolo`,
`fk_circuito`)
VALUES
(
"Variante Villeneuve 3",
38,
12);

INSERT INTO `amgp`.`curva`
(
`nome`,
`angolo`,
`fk_circuito`)
VALUES
(
"Tosa",
78,
12);

INSERT INTO `amgp`.`curva`
(
`nome`,
`angolo`,
`fk_circuito`)
VALUES
(
"Piratella",
71,
12);

INSERT INTO `amgp`.`curva`
(
`nome`,
`angolo`,
`fk_circuito`)
VALUES
(
"Acque Minerali",
58,
12);

INSERT INTO `amgp`.`rettilineo`
(
`nome`,
`lunghezza`,
`fk_circuito`)
VALUES
(
"Rivazza",
550,
12);

INSERT INTO `amgp`.`circuito`
(idcircuito,
`nome`,
`sede`,
`lunghezza`,
`meteo`,
`tpm`,
`rpm`,
`umidita`,
`ngiri`)
VALUES
(
13,
"Autòdromo Hermanos Rodriguez",
"Città del Messico",
4304,
"Sole",
77.578,
70.127,
70,
65);


INSERT INTO `amgp`.`rettilineo`
(
`nome`,
`lunghezza`,
`fk_circuito`)
VALUES
(
"Recta del Ovalo",
760,
13);

INSERT INTO `amgp`.`rettilineo`
(
`nome`,
`lunghezza`,
`fk_circuito`)
VALUES
(
"Recta Pincipal",
560,
13);

INSERT INTO `amgp`.`rettilineo`
(
`nome`,
`lunghezza`,
`fk_circuito`)
VALUES
(
"Recta Trasera",
560,
13);


INSERT INTO `amgp`.`curva`
(
`nome`,
`angolo`,
`fk_circuito`)
VALUES
(
"Ese Moises Solana",
121,
13);

INSERT INTO `amgp`.`curva`
(
`nome`,
`angolo`,
`fk_circuito`)
VALUES
(
"Ese del Lago",
101,
13);

INSERT INTO `amgp`.`curva`
(
`nome`,
`angolo`,
`fk_circuito`)
VALUES
(
"Haipin",
85,
13);

INSERT INTO `amgp`.`curva`
(
`nome`,
`angolo`,
`fk_circuito`)
VALUES
(
"Peraltada",
190,
13);

INSERT INTO `amgp`.`circuito`
(idcircuito,
`nome`,
`sede`,
`lunghezza`,
`meteo`,
`tpm`,
`rpm`,
`umidita`,
`ngiri`)
VALUES
(
14,
"Autodromo Internazionale Monza",
"Monza",
4304,
"Sole",
85.578,
81.127,
30,
61);


INSERT INTO `amgp`.`curva`
(
`nome`,
`angolo`,
`fk_circuito`)
VALUES
(
"Biassono",
130,
14);

INSERT INTO `amgp`.`curva`
(
`nome`,
`angolo`,
`fk_circuito`)
VALUES
(
"Roggia",
120,
14);


INSERT INTO `amgp`.`curva`
(
`nome`,
`angolo`,
`fk_circuito`)
VALUES
(
"Lesmo",
100,
14);

INSERT INTO `amgp`.`curva`
(
`nome`,
`angolo`,
`fk_circuito`)
VALUES
(
"Serraglio",
140,
14);

INSERT INTO `amgp`.`curva`
(
`nome`,
`angolo`,
`fk_circuito`)
VALUES
(
"Ascari",
100,
14);

INSERT INTO `amgp`.`curva`
(
`nome`,
`angolo`,
`fk_circuito`)
VALUES
(
"Parabolica",
100,
14);

INSERT INTO `amgp`.`rettilineo`
(
`nome`,
`lunghezza`,
`fk_circuito`)
VALUES
(
"Rettilineo Box",
500,
14);

INSERT INTO `amgp`.`rettilineo`
(
`nome`,
`lunghezza`,
`fk_circuito`)
VALUES
(
"Rettilineo Levante",
510,
14);

INSERT INTO `amgp`.`rettilineo`
(
`nome`,
`lunghezza`,
`fk_circuito`)
VALUES
(
"Rettilineo Centrale",
400,
14);

INSERT INTO `amgp`.`rettilineo`
(
`nome`,
`lunghezza`,
`fk_circuito`)
VALUES
(
"Rettilineo Tribune",
200,
14);

INSERT INTO `amgp`.`circuito`
(
idcircuito,
`nome`,
`sede`,
`lunghezza`,
`meteo`,
`tpm`,
`rpm`,
`umidita`,
`ngiri`)
VALUES
(
15,
"Circuito Gilles Villeneuve",
"Montreal",
4304,
"Pioggia",
76.578,
73.127,
30,
61);

INSERT INTO `amgp`.`curva`
(
`nome`,
`angolo`,
`fk_circuito`)
VALUES
(
"Virage Senna",
150,
15);

INSERT INTO `amgp`.`curva`
(
`nome`,
`angolo`,
`fk_circuito`)
VALUES
(
"Pont de La Concorde",
130,
15);

INSERT INTO `amgp`.`curva`
(
`nome`,
`angolo`,
`fk_circuito`)
VALUES
(
"L'Epingle",
95,
15);
INSERT INTO `amgp`.`rettilineo`
(
`nome`,
`lunghezza`,
`fk_circuito`)
VALUES
(
"Casino",
550,
15);
INSERT INTO `amgp`.`circuito`
(
idcircuito,
`nome`,
`sede`,
`lunghezza`,
`meteo`,
`tpm`,
`rpm`,
`umidita`,
`ngiri`)
VALUES
(
16,
"Silverstone",
"Silverstone",
1950,
"Pioggia",
81.578,
59.00,
48,
52);

INSERT INTO `amgp`.`curva`
(
`nome`,
`angolo`,
`fk_circuito`)
VALUES
(
"Stowe",
130,
16);

INSERT INTO `amgp`.`curva`
(
`nome`,
`angolo`,
`fk_circuito`)
VALUES
(
"Chapel",
121,
16);

INSERT INTO `amgp`.`curva`
(
`nome`,
`angolo`,
`fk_circuito`)
VALUES
(
"Abbay",
80,
16);

INSERT INTO `amgp`.`curva`
(
`nome`,
`angolo`,
`fk_circuito`)
VALUES
(
"Farm",
43,
16);

INSERT INTO `amgp`.`curva`
(
`nome`,
`angolo`,
`fk_circuito`)
VALUES
(
"Village",
35,
16);

INSERT INTO `amgp`.`curva`
(
`nome`,
`angolo`,
`fk_circuito`)
VALUES
(
"Brooklends",
140,
16);

INSERT INTO `amgp`.`curva`
(
`nome`,
`angolo`,
`fk_circuito`)
VALUES
(
"Coopse",
121,
16);


INSERT INTO `amgp`.`rettilineo`
(
`nome`,
`lunghezza`,
`fk_circuito`)
VALUES
(
"Hangar",
430,
16);

INSERT INTO `amgp`.`rettilineo`
(
`nome`,
`lunghezza`,
`fk_circuito`)
VALUES
(
"Hamilton",
230,
16);