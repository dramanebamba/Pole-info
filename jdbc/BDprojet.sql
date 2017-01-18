DROP TABLE Master;
CREATE TABLE Master (id SERIAL NOT NULL,
                      nom VARCHAR(100) NOT NULL,
                      description TEXT,
PRIMARY KEY (id));

DROP TABLE Contenu;
CREATE TABLE Contenu (id SERIAL NOT NULL,
        	       nom VARCHAR(200) NOT NULL,	
                       volume_horaire INT NOT NULL DEFAULT 0,
                       volume_projet INT NOT NULL DEFAULT 0,
                      ects INT NOT NULL DEFAULT 3,
	             description TEXT,	
                        objectives TEXT,
                contents TEXT,
                  biblio TEXT,
                     apprentissage CHAR(1) NOT NULL DEFAULT 'N',
	  PRIMARY KEY (id)	
);

DROP TABLE Cours;
CREATE TABLE Cours (id_master INT NOT NULL,
                    id_contenu INT NOT NULL,
                   id_enseignant INT NOT NULL,
	            notes TEXT,
                    periode VARCHAR(200),
                    obligatoire CHAR(1) NOT NULL DEFAULT 'O',
PRIMARY KEY (id_master, id_contenu));

DROP TABLE Personne;
CREATE TABLE Personne (id SERIAL  NOT NULL,
			prenom VARCHAR (60) NOT NULL ,
                        nom VARCHAR (60) NOT NULL,
                        email VARCHAR (60) NOT NULL, 
                        telephone VARCHAR (20) NOT NULL,
                        fax     VARCHAR (20) NOT NULL,
                        home_page VARCHAR (100),
                        cv     TEXT,
                        notes TEXT,
                        roles VARCHAR(10) DEFAULT 'M',
                        password VARCHAR(32),
 	                id_master INT,
                        annee_master INT,
                        PRIMARY KEY (id),
	                 UNIQUE (prenom, nom),
	                 UNIQUE (email)
);

DROP TABLE Preference;
CREATE TABLE Preference (id_master INTEGER NOT NULL,
			id_contenu INTEGER NOT NULL,	
	               id_personne INTEGER NOT NULL, 
                       niveau INTEGER NOT NULL,
                       PRIMARY KEY (id_master, id_contenu, id_personne)
);

DROP TABLE Affectation;
CREATE TABLE Affectation (id_master INTEGER NOT NULL,
			id_contenu INTEGER NOT NULL,	
	                id_personne INTEGER NOT NULL, 
                        annee INT NOT NULL,
                       note DECIMAL (6,2),
                       PRIMARY KEY (id_master, id_contenu, id_personne, annee)
);

DROP TABLE Session;
CREATE TABLE Session (id_session     VARCHAR (40) NOT NULL,
	               id_person        VARCHAR(60) NOT NULL, 
		    first_name VARCHAR(60) NOT NULL,
		    last_name VARCHAR(60) NOT NULL,
	               end_session   DECIMAL (10,0) NOT NULL,
			roles    VARCHAR(10) NOT NULL,
                       PRIMARY KEY (id_session),
                       FOREIGN KEY (id_person) REFERENCES Personne(id)
);