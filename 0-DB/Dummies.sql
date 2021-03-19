INSERT INTO Role VALUES
	(1, 'Chef.fe de la Terre'),
	(2, 'Grosse Pompe');

INSERT INTO User (id, mail, password, username, role_id) VALUES
	(1, 'johanna.jato@epsi.fr', 'johanna', 'johanna', 2),
	(2, 'camille,jouan@epsi.fr', 'camille', 'camille', 1),
	(3, 'donovan.damhec@epsi.fr', 'donovan', 'donovan', 1),
	(4, 'claire.lapompe@epsi.fr', 'claire', 'claire', 2),
	(5, 'toto@epsi.fr', 'toto', 'toto', 2);

INSERT INTO Category VALUES
	(1, 'Revolution'),
	(2, 'Connasse'),
	(3, 'Rouleur patin');

INSERT INTO Idea (date, description, image, title, author_id, category_id) VALUES
	(2021-01-01, 'Elisons Johanna a la presidence de la planete, ca tombe sous le sens.', 'https://www.groupe-imprim.com/wp-content/uploads/2019/09/election-img2.jpg', 'Johanna Presidente', 2, 1),
	(2021-02-16, 'Les patins ca coute la blinde. On en offre une paire a tout le monde!!!', 'https://pbs.twimg.com/media/DlwkRQsU4AAa4tU.jpg', 'Patins gratuits', 3, 3),
	(2021-02-02, 'Les rendus par mail ca me degoute!', 'https://resize-parismatch.lanmedia.fr/r/620,/img/var/news/storage/images/media/images/super-nanny-portrait/207874-1-fre-FR/Super-Nanny-portrait_original_backup.jpg', '1 point de penalite', 4, 2),
	(2021-03-20, 'Java c''etait bien... en 1990', 'https://pic.clubic.com/v1/images/1501424/raw', 'Java', 5, 1),
	(2021-03-02, 'Moins de projets à l''EPSI... On a trop de taff', 'https://storage.googleapis.com/prod-phoenix-bucket/osp/cards/534/logo-epsi-200727055421.jpg', 'EPSI', 2, 1);
	