-- DB creation
DROP DATABASE TopIdea;

CREATE DATABASE IF NOT EXISTS TopIdea;
USE TopIdea;

CREATE TABLE IF NOT EXISTS `User` (
    id BIGINT NOT NULL AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(260) NOT NULL,
    isactive BOOLEAN,
    CONSTRAINT pk_user PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `Role` (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    CONSTRAINT pk_role PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS UserRole (
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES `User`(id),
    CONSTRAINT fk_role FOREIGN KEY (role_id) REFERENCES `Role`(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS Category (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS Idea (
    id BIGINT NOT NULL AUTO_INCREMENT,
    `date` DATE NOT NULL,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    image VARCHAR(255),
    author_id BIGINT NOT NULL,
    category_id BIGINT NOT NULL,
    CONSTRAINT pk_idea PRIMARY KEY (id),
    CONSTRAINT fk_idea_user FOREIGN KEY (author_id) REFERENCES `User`(id),
    CONSTRAINT fk_idea_category FOREIGN KEY (category_id) REFERENCES Category(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS Vote (
    id BIGINT NOT NULL AUTO_INCREMENT,
    user_id BIGINT NOT NULL,
    idea_id BIGINT NOT NULL,
    vote VARCHAR(5) NOT NULL,
    CONSTRAINT pk_vote PRIMARY KEY (id),
    CONSTRAINT fk_vote_user FOREIGN KEY (user_id) REFERENCES `User`(id),
    CONSTRAINT fk_vote_idea FOREIGN KEY (idea_id) REFERENCES `Idea`(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS Comment (
    id BIGINT NOT NULL AUTO_INCREMENT,
    user_id BIGINT NOT NULL,
    idea_id BIGINT NOT NULL,
    text VARCHAR(500) NOT NULL,
    CONSTRAINT pk_comment PRIMARY KEY (id),
    CONSTRAINT fk_comment_user FOREIGN KEY (user_id) REFERENCES `User`(id),
    CONSTRAINT fk_comment_idea FOREIGN KEY (idea_id) REFERENCES `Idea`(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- DB population
INSERT INTO Role VALUES
	(1, 'ADMIN'),
	(2, 'USER');

INSERT INTO User (id, username, password, isActive) VALUES
	(1, 'johanna', 'johanna', TRUE),
	(2, 'camille', 'camille', TRUE),
	(3, 'donovan', 'donovan', TRUE),
	(4, 'claire', 'claire', TRUE),
	(5, 'toto', 'toto', TRUE);

INSERT INTO UserRole VALUES
    (1, 1),
    (1, 2),
    (2, 1),
    (2, 2),
    (3, 2),
    (4, 2),
    (5, 2);

INSERT INTO Category VALUES
	(1, 'Revolution'),
	(2, 'Connasse'),
	(3, 'Rouleur');

INSERT INTO Idea (date, description, image, title, author_id, category_id) VALUES
	(20210101, 'Elisons Johanna a la presidence de la planete, ca tombe sous le sens.', 'https://www.groupe-imprim.com/wp-content/uploads/2019/09/election-img2.jpg', 'Johanna Presidente', 2, 1),
	(20210216, 'Les patins ca coute la blinde. On en offre une paire a tout le monde!!!', 'https://pbs.twimg.com/media/DlwkRQsU4AAa4tU.jpg', 'Patins gratuits', 3, 3),
	(20210202, 'Les rendus par mail ca me degoute!', 'https://resize-parismatch.lanmedia.fr/r/620,/img/var/news/storage/images/media/images/super-nanny-portrait/207874-1-fre-FR/Super-Nanny-portrait_original_backup.jpg', '1 point de penalite', 4, 2),
	(20210320, 'Java c''etait bien... en 1990', 'https://pic.clubic.com/v1/images/1501424/raw', 'Java', 5, 1),
	(20210302, 'Moins de projets à l''EPSI... On a trop de taff', 'https://storage.googleapis.com/prod-phoenix-bucket/osp/cards/534/logo-epsi-200727055421.jpg', 'EPSI', 2, 1);
	