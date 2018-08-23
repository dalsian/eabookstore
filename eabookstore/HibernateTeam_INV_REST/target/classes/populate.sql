INSERT INTO credentials(username,password,enabled) VALUES ('guest','$2a$10$0.ESlGysrPaiW5HaapKwoehzWt5AibgbPPOvMhDv8D6H26QQ/CwhS', TRUE);
INSERT INTO credentials(username,password,enabled) VALUES ('admin','$2a$10$S/wlXEo/APzf.Sn1cO2p4.V12EJmaw.uzrHelMvkpuahjmHWnSafe', TRUE);
 
INSERT INTO authority (username, authority) VALUES ('guest', 'ROLE_USER');
INSERT INTO authority (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO authority (username, authority) VALUES ('admin', 'ROLE_USER');

INSERT INTO category (`name`) VALUES ('Art');
INSERT INTO category (`name`) VALUES ('Biography');
INSERT INTO category (`name`) VALUES ('Business');
INSERT INTO category (`name`) VALUES ('Children');
INSERT INTO category (`name`) VALUES ('Comics');
INSERT INTO category (`name`) VALUES ('Cookbooks');
INSERT INTO category (`name`) VALUES ('Classic');
INSERT INTO category (`name`) VALUES ('Ebooks');
INSERT INTO category (`name`) VALUES ('Fantacy');
INSERT INTO category (`name`) VALUES ('Fiction');
INSERT INTO category (`name`) VALUES ('History');
INSERT INTO category (`name`) VALUES ('Horror');
INSERT INTO category (`name`) VALUES ('Science');
INSERT INTO category (`name`) VALUES ('SCI-FI');
INSERT INTO category (`name`) VALUES ('Romance');
INSERT INTO category (`name`) VALUES ('Nonfiction');
INSERT INTO category (`name`) VALUES ('Self help');
INSERT INTO category (`name`) VALUES ('Travel');

INSERT INTO `status` (`name`) VALUES ('NEW_PUB');
INSERT INTO `status` (`name`) VALUES ('IN_STOCK');


INSERT INTO `Book` (`id`,`author`,`description`,`isbn`,`name`,`price`,`quantity`,`category_id`,`status_id`) VALUES (1,'Grace Bonney','Over 100 exceptional and influential women describe how they embraced their creative spirit, overcame adversity, and sparked a global movement of entrepreneurship. Media titans and ceramicists, hoteliers and tattoo artists, comedians and architectsâ??taken together, these profiles paint a beautiful picture of what happens when we pursue our passions and dreams.','123-462-865','In the Company of Women: Inspiration and Advice from over 100 Makers, Artists, and Entrepreneurs',23.79,0,1,1);
INSERT INTO `Book` (`id`,`author`,`description`,`isbn`,`name`,`price`,`quantity`,`category_id`,`status_id`) VALUES (2,'Ray Dalio','#1 New York Times Bestseller  â??Significant...The book is both instructive and surprisingly moving.â?? â??The New York Times  Ray Dalio, one of the worldâ??s most successful investors and entrepreneurs, shares the unconventional principles that heâ??s developed, refined, and used over the past forty years to create unique results in both life and businessâ??and which any person or organization can adopt to help achieve their goals.','567-234-796','Principles: Life and Work',28.53,0,3,1);
INSERT INTO `Book` (`id`,`author`,`description`,`isbn`,`name`,`price`,`quantity`,`category_id`,`status_id`) VALUES (3,'Dr. Seuss','You\'re Only Old Once!: A Book for Obsolete Children (Classic Seuss)','334-123-776-754','You\'re Only Old Once!: A Book for Obsolete Children',7.61,0,4,1);
INSERT INTO `Book` (`id`,`author`,`description`,`isbn`,`name`,`price`,`quantity`,`category_id`,`status_id`) VALUES (4,'Jane Austen','Marianne Dashwood wears her heart on her sleeve, and when she falls in love with the dashing but unsuitable John Willoughby she ignores her sister Elinor\'s warning that her impulsive behaviour leaves her open to gossip and innuendo.','742-297-434','Sense and Sensibility (Penguin Classics)',8,0,7,1);
INSERT INTO `Book` (`id`,`author`,`description`,`isbn`,`name`,`price`,`quantity`,`category_id`,`status_id`) VALUES (5,'Rupert Colley','Two brothers. One woman. A nation at war.  A compelling story of war, brotherly love, romance and betrayal during World War One.   Vast in scope and intimate in the portrayal of three lives swept along by circumstances, \'This Time Tomorrow\' moves from the drawing rooms of Edwardian London to the trenches of the Western Front and to the uncertainty of post-war Britain. ','645-745-214','This Time Tomorrow: World War One Historical Fiction (The Searight Saga Book 1)',10.99,0,10,1);
INSERT INTO `Book` (`id`,`author`,`description`,`isbn`,`name`,`price`,`quantity`,`category_id`,`status_id`) VALUES (6,'Stephen Hawking','#1 NEW YORK TIMES BESTSELLER  A landmark volume in science writing by one of the great minds of our time, Stephen Hawkingâ??s book explores such profound questions as: How did the universe beginâ??and what made its start possible? Does time always flow forward? Is the universe unendingâ??or are there boundaries? Are there other dimensions in space? What will happen when it all ends?','055-338-016','A Brief History of Time',11.04,10,11,2);
INSERT INTO `Book` (`id`,`author`,`description`,`isbn`,`name`,`price`,`quantity`,`category_id`,`status_id`) VALUES (7,'Thommy Hutson','\"Thommy Hutson is the ultimate authority in nostalgia-driven storytelling.\"  â??Clive Barker, Bestselling Author of Books of Blood and The Thief of Always  â??Jinxed is the teen whodunit that Wes Craven and Lois Duncan never made. Hutson has created the best new slasher franchise since Scream.â??','642-790-980','Jinxed',15.95,0,12,1);
INSERT INTO `Book` (`id`,`author`,`description`,`isbn`,`name`,`price`,`quantity`,`category_id`,`status_id`) VALUES (8,'Wladston Ferreira Filho','A walkthrough of computer science concepts you must know. Designed for readers who don\'t care for academic formalities, it\'s a fast and easy computer science guide. It teaches the foundations you need to program computers effectively. After a simple introduction to discrete math, it presents common algorithms and data structures. It also outlines the principles that make computers and programming languages work.','123-124-124','Computer Science Distilled: Learn the Art of Solving Computational Problems',22.5,0,13,1);
INSERT INTO `Book` (`id`,`author`,`description`,`isbn`,`name`,`price`,`quantity`,`category_id`,`status_id`) VALUES (9,'Daniel Willson','From the New York Times bestselling author of Robopocalypse comes a fascinating and fantastic collection that explores complex emotional and intellectual landscapes at the intersection of artificial intelligence and human life. A VINTAGE BOOKS ORIGINAL.  In \"All Kinds of Proof,\" a down-and-out drunk makes the unlikeliest of friends when he is hired to train a mail-carrying robot; in \"Blood Memory,\" a mother confronts the dangerous reality that her daughter will never assimilate in this world after she was the first child born through a teleportation device; in \"The Blue Afternoon That Lasted Forever,\" a physicist rushes home to be with his daughter after he hears reports of an atmospheric anomaly which he knows to be a sign of the end of the earth; in \"Miss Gloria,\" a robot comes back to life in many different forms in a quest to save a young girl. ','097-236-864','Guardian Angels and Other Monsters',12.18,0,14,1);
INSERT INTO `Book` (`id`,`author`,`description`,`isbn`,`name`,`price`,`quantity`,`category_id`,`status_id`) VALUES (10,'Meera Lee Patel','Start Where You Are is an interactive journal designed to help readers nurture their creativity, mindfulness, and self-motivation. It helps readers navigate the confusion and chaos of daily life with a simple reminder: that by taking the time to know ourselves and what those dreams are, we can appreciate the world around us and achieve our dreams.','345-234-876','Start Where You Are: A Journal for Self-Exploration',13.15,0,17,1);