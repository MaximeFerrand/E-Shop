-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mar. 22 nov. 2022 à 08:37
-- Version du serveur :  5.7.31
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `siteeshop`
--

-- --------------------------------------------------------

--
-- Structure de la table `account`
--

DROP TABLE IF EXISTS `account`;
CREATE TABLE IF NOT EXISTS `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_5vxwyorsr92jce3ore6h93k6q` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `account`
--

INSERT INTO `account` (`id`, `login`, `password`) VALUES
(8, 'admin@admin.fr', '$2a$10$vn/AtrH4yfUeU8bJQLc53O.qdZkp.FkZjrgEjzR/INJLW1knc0xb6'),
(9, 'jane@doe.fr', '$2a$10$I1B.pVm.4udim0wWHnX3ReBEJJzSBF6ENz8ha3WoHuTz0fPoCsRgm'),
(10, 'john@doe.fr', '$2a$10$qZQ/mEuNGvD/iJY0Mg2OiOZ6obkNN3JfzVKhA0CaiNnXybwVsnufe'),
(11, 'supplier@sopra.fr', '$2a$10$HPbY3uniN2M7Yar3uxvj0OOoARSERRGtFWujMrPcna1CSCANZBMPi'),
(12, 'supplier@AJC.fr', '$2a$10$YgupZVA1ArurJ0R6.QP/8uNecIkEE8JIzLXz1AyyuF0HvD9nRshJK');

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `admin`
--

INSERT INTO `admin` (`id`) VALUES
(8);

-- --------------------------------------------------------

--
-- Structure de la table `artisan`
--

DROP TABLE IF EXISTS `artisan`;
CREATE TABLE IF NOT EXISTS `artisan` (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `basket`
--

DROP TABLE IF EXISTS `basket`;
CREATE TABLE IF NOT EXISTS `basket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_tracking` enum('ordered','inPreparation','shipped','delivered','closed') NOT NULL DEFAULT 'ordered',
  `shipping` enum('houseShipping','pickUp','withdrawal') DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfp7yinn3dh4sy1ia364xp3d9g` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE IF NOT EXISTS `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `labelcat` varchar(35) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_d1th1pltb63gh2jgwbplpsds` (`labelcat`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `category`
--

INSERT INTO `category` (`id`, `labelcat`) VALUES
(2, 'décoration'),
(4, 'électroménager'),
(6, 'entretien'),
(5, 'linges'),
(3, 'meubles');

-- --------------------------------------------------------

--
-- Structure de la table `merchant`
--

DROP TABLE IF EXISTS `merchant`;
CREATE TABLE IF NOT EXISTS `merchant` (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `order_detail`
--

DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE IF NOT EXISTS `order_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quantity` int(11) NOT NULL,
  `comment` text,
  `notation` int(11) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK191acqcunrl0xo32ub778fqa6` (`order_id`),
  KEY `FKb8bg2bkty0oksa3wiq5mp5qnc` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` text NOT NULL,
  `label` varchar(255) NOT NULL,
  `measure` varchar(255) NOT NULL,
  `price` double NOT NULL,
  `reference` varchar(20) NOT NULL,
  `status` enum('New','Reconditioned','Repaired') DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `supplier_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1mtsbur82frn64de7balymq9s` (`category_id`),
  KEY `FK2kxvbr72tmtscjvyp9yqb12by` (`supplier_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `product`
--

INSERT INTO `product` (`id`, `description`, `label`, `measure`, `price`, `reference`, `status`, `stock`, `category_id`, `supplier_id`) VALUES
(2, 'Vous trouverez ci-dessous toutes les caractéristiques de Suspension design en verre et métal moderne (plusieurs formes), telles qu\'elles sont données dans la notice d\'utilisation.', 'Suspension design en verre et en metal moderne ', '33 x 13cm', 189, 'P2-SUS-2022-1-11', 'New', 100, 2, 11),
(3, 'Vous trouverez ci-dessous toutes les caractéristiques de Plafonnier LED design arrondi et plat (plusieurs tailles), telles qu\'elles sont données dans la notice d\'utilisation. Illuminez votre intérieur de façon originale et élégante grâce à ce plafonnier LED design arrondi et plat. Disponible en plusieurs tailles et coloris, cet éclairage s\'adapte à toutes les pièces. Bénéficiez d\'une livraison gratuite pour ravir vos envies d\'aménagement. Ce plafonnier est disponibles en plusieurs wattages et plusieurs dimensions de diamètre. Vous pouvez l\'installer aussi bien dans une pièce à vivre que dans une salle de réunion. Discret, ce plafonnier LED design est aussi très léger à manipuler.', 'Plafonnier LED design arrondi et plat', '23cm', 69, 'P2-SUS-2022-2-11', 'New', 100, 2, 11),
(4, 'Vous trouverez ci-dessous toutes les caractéristiques de Suspension design vintage noire Loft, telles qu\'elles sont données dans la notice d\'utilisation.Avec sa forme graphique, la suspension design vintage noire Loft est un véritable accroche-regard. Découvrez vite ce luminaire élégant, disponible en trois versions habillées de noir. Seul ou en rangée, il donne du style à n\'importe quelle pièce. Composée de métal, la suspension Loft associe un extérieur noir et un intérieur doré magnifiant la lumière. Sa forme originale s\'inspire du cône ou de la cloche, et mesure 36 x 17cm. Ce luminaire diffuse un éclairage efficace vers le bas, parfait dans une chambre, un salon, ou au-dessus d\'un îlot de cuisine ou d\'une table à manger. Aux normes européennes, il nécessite une ampoule E27 de 60 W.', 'Suspension design vintage noire Loft', '36 x 17cm', 139, 'P2-SUS-2022-3-11', 'New', 100, 2, 11),
(5, 'Vous trouverez ci-dessous toutes les caractéristiques de Applique murale design à LED en triangle métal Loft, telles qu\'elles sont données dans la notice d\'utilisation. L\'applique murale design à LED en triangle apporte un caractère indéniable à la pièce dans laquelle elle est située. Sa forme est très originale et crée un design moderne et singulier dans votre intérieur. Cette applique murale design se décline en trois couleurs : le noir, le blanc et le doré. Vous pouvez ainsi associer celle qui correspond le mieux à l\'atmosphère de votre logement. Vous pouvez aussi accrocher plusieurs lampes ensemble et ajouter du caractère dans l\'esthétisme de votre pièce. Ce type d\'applique murale est parfaite pour votre bureau, votre chambre ou encore votre salon ou salle à manger. Les ampoules sont fournies avec et la lampe est garantie pendant deux ans.', 'Applique murale design à LED en triangle métal Loft', '12 x 12 x 25 x 18 x 15cm', 99, 'P2-SUS-2022-4-11', 'New', 100, 2, 11),
(6, '', 'Tapis Lorentz', '240 x 340cm', 613, 'P2-TAP-2022-1-12', 'New', 100, 2, 12),
(7, '', 'Tapis Davina', '200 x 200cm', 230, 'P2-TAP-2022-2-12', 'New', 100, 2, 12),
(8, 'Le meuble TV Anton 100 est fabriqué en teck massif naturel. Equipé de 2 portes coulissantes et d\'une niche, il sera idéal comme meuble de rangement pour votre salon. Vous aimerez son style sobre et naturel : un design simple caractérisé par des lignes droites, une teinte claire et une finition naturelle du bois de teck. Pour un salon harmonieux, n’hésitez pas à le coordonner avec nos meubles teck de la collection Les essentiels; une gamme de meubles fonctionnels au style moderne. Grâce à leur design intemporel et élégant ils trouveront facilement leur place dans toute la maison. Sublimez votre meuble avec des accessoires décoratifs, découvrez notre gamme d’objets déco sélectionnés par nos designers. Particulièrement convoité en architecture et en mobilier, le teck est dense, résistant à l\'humidité et durable. Très esthétique, il affiche une élégance teintée d’exotisme et offre une large palette de nuances : miel clair, bronze ou brun avec des veinages sombres. En savoir plus sur le teck.', 'Anton - Meuble TV en teck massif 100 cm', '50 x 100 x 40cm', 329, 'P3-MEU-2022-1-12', 'New', 50, 3, 12),
(9, 'Grand meuble de télévision en bois de palissandre, à la teinte chaleureuse et chamarrée. Doté de multiples rangements ouverts :  1 grande niche supérieure , 4 petites niches latérales et 2 niches centrales (vendu avec 2 tiroirs et 1 casier), il sera idéal pour l\'optimisation de votre espace salon. Ses lignes simples et modernes s\'accorderont aisément avec votre intérieur, pour une installation plus complète, ce meuble TV peut être additionné des modules Kwarto. La collection modulable en palissandre Kwarto a été imaginée pour toutes les pièces de la maison. Ces cubes identiques s\'adaptent à vos envies : meuble tv, meuble de salle de bain, colonne de rangement.', 'Kwarto - Meuble TV en palissandre massif 170 cm', '42 x 170 x 32', 799, 'P3-MEU-2022-2-12', 'New', 50, 3, 12),
(10, 'Découvrez notre tête de lit Colette en rotin naturel vernis. Conçue pour un couchage de 2 personnes, elle sera idéale pour un lit de 140 ou 160 cm. Naturel et authentique, nous aimons son style cocon, idéal pour un intérieur douillet et accueillant. Il est caractérisé par la douceur de la composition en tiges de rotin, vous aimerez également la sobriété de sa teinte claire qui apportera un esprit nature tout en style. Pour une totale harmonie dans votre intérieur, n’hésitez pas à découvrir l\'intégralité de notre collection de meubles en rotin vintage, une sélection de meubles fonctionnels au style moderne et cosy. Originalité et élégance du style, ils trouveront aisément leur place dans toute la maison. Pour une décoration chaleureuse, consultez notre sélection deco : tapis, coussins, plaids ... vous y trouverez les indispensables pour votre espace nuit.', 'Colette - Tête de lit en rotin 160 cm', '111 x 160 x 3cm', 149, 'P3-TET-2022-1-12', 'New', 50, 3, 12),
(11, 'Découvrez notre tête de lit Minimalys en teck massif brut. Conçue pour un couchage de 2 personnes, elle sera idéale pour un lit de 140 ou 160 cm. Naturel et authentique, son style moderne est caractérisé par la structure lattée en teck qui la compose, vous aimerez la sobriété de sa teinte claire alliée à la simplicité de ses lignes qui apporteront un esprit nature tout en style. Pour un intérieur harmonieux n’hésitez pas à découvrir notre collection en teck brut Minimalys, une sélection de meubles fonctionnels au style moderne. Originalité et élégance du style, ils trouverons aisément leur place dans toute la maison. Pour une décoration chaleureuse, consultez notre sélection deco : paniers, coussins, plaids ... vous y trouverez les éléments indispensables pour votre espace nuit.', 'Minimalys - Tête de lit en teck massif 165 cm', '95 x 165 x 3cm', 329, 'P3-TET-2022-1-11', 'New', 50, 3, 11),
(12, 'Ce meuble de salle de bain en bois massif est doté de nombreux espaces de rangement : 5 niches, 2 tiroirs, il vous permettra de ranger votre linge de maison ainsi que vos produits de soin. Notre meuble Soho est idéal pour une utilisation de la salle de bain en famille ou en couple, en effet, vous pourrez disposer deux vasques, parfaites pour une salle de bain harmonieuse et conviviale. Son style élégant et intemporel fait de lui un atout charme de la salle de bain, vous serez séduits par son authenticité et sa teinte claire. Pour une salle de bain complète, accompagnez le meuble Soho d’une jolie colonne fonctionnelle pour plus d’espace de rangement. Découvrez notre sélection de colonne en bois massif. Pour une salle de bain complète, associez votre meuble de salle de bain Soho d\'une ou deux vasques en marbre ou terrazzo.', 'Soho - Meuble sous vasque en teck massif 125 cm', '75 x 125 x 55cm', 999, 'P3-MEU-2022-1-11', 'New', 25, 3, 11),
(13, 'Charmant meuble de salle de bain en teck de grade supérieur, il s\'adaptera à  toutes les tailles de salle de bain. Seul, ou accompagné du meuble sous vasque Stelle gauche, vous avez la possibilité de moduler votre intérieur comme bon vous semble. Vous remarquerez l\'élégance des lignes, la qualité des finitions et le soin apporté au ponçage laissant apparaître les ravissantes veinures du bois de teck clair. Pratique, il est muni de 3 niches et d\'un porte serviette en laiton vieilli, vous apportant un confort d\'utilisation de votre espace bain. N\'hésitez pas à compléter les meubles de salle de bain Stelle, du miroir de la même collection ...', 'Stelle - Meuble sous vasque en teck massif droit', '78 x 30 x 40cm', 449, 'P3-MEU-2022-3-12', 'New', 25, 3, 12),
(14, 'Doté de plusieurs solutions de rangement, ce réfrigérateur AYAaffiche une contenance totale de 206 L. Prévu pour un foyer de trois à quatre personnes, il comporte une zone réfrigérante de 165 L divisée par des étagères amovibles. Situé dans la partie supérieure du réfrigérateur, le congélateur de 41 L est organisé à l\'aide d\'une clayette de séparation en verre. D\'un niveau sonore de 40 dB, ce modèle se fait discret dans votre cuisine. L\'éclairage intégré simplifie son utilisation et permet de repérer plus facilement les aliments. Autre avantage, ce réfrigérateur à 2 portescomprend un distributeur d\'eau posé sur sa façade. Avec son design moderne, ce réfrigérateur de L. 54,2 x H. 143,4 x P. 55 cm trouvera sa place dans une cuisine contemporaine. Sa porte réversible lui permet de s\'adapter à la configuration de vos espaces en toute simplicité. Ce réfrigérateur de couleur silvers\'intègrera sans fausse note parmi vos équipements. Robuste, il vous servira pendant longtemps. Facile à utiliser, ce réfrigérateur à pose librefonctionne avec la technologie de froid statique. Pour nettoyer l\'intérieur, rien de plus simple : retirez tous les balconnets de contre-porte ainsi que les clayettes en verre. Lavez soigneusement chaque élément à l\'eau chaude additionnée de détergent doux, et laissez sécher avant de replacer les accessoires. Enfin, passez un coup d\'éponge propre sur les parois intérieures pour éliminer les salissures. Côté consommation, ce réfrigérateur dépense en moyenne 221 kWh/an. Lors de son installation, prévoyez un espace suffisant à l\'arrière de ce réfrigérateur avec congélateurafin de favoriser une bonne ventilation. La température de l\'appareil se règle très simplement à l\'aide d\'un bouton dédié. ', 'AYA Réfrigérateur 2 portes - 206L', '54.2 x 143.4 x 55cm', 379.99, 'P4-REF-2022-1-12', 'New', 25, 4, 12),
(15, 'Doté de plusieurs solutions de rangement, ce réfrigérateur AYAaffiche une contenance totale de 206 L. Prévu pour un foyer de trois à quatre personnes, il comporte une zone réfrigérante de 165 L divisée par des étagères amovibles. Situé dans la partie supérieure du réfrigérateur, le congélateur de 41 L est organisé à l\'aide d\'une clayette de séparation en verre. D\'un niveau sonore de 40 dB, ce modèle se fait discret dans votre cuisine. L\'éclairage intégré simplifie son utilisation et permet de repérer plus facilement les aliments. Autre avantage, ce réfrigérateur à 2 portescomprend un distributeur d\'eau posé sur sa façade. Avec son design moderne, ce réfrigérateur de L. 54,2 x H. 143,4 x P. 55 cm trouvera sa place dans une cuisine contemporaine. Sa porte réversible lui permet de s\'adapter à la configuration de vos espaces en toute simplicité. Ce réfrigérateur de couleur silvers\'intègrera sans fausse note parmi vos équipements. Robuste, il vous servira pendant longtemps. Facile à utiliser, ce réfrigérateur à pose librefonctionne avec la technologie de froid statique. Pour nettoyer l\'intérieur, rien de plus simple : retirez tous les balconnets de contre-porte ainsi que les clayettes en verre. Lavez soigneusement chaque élément à l\'eau chaude additionnée de détergent doux, et laissez sécher avant de replacer les accessoires. Enfin, passez un coup d\'éponge propre sur les parois intérieures pour éliminer les salissures. Côté consommation, ce réfrigérateur dépense en moyenne 221 kWh/an. Lors de son installation, prévoyez un espace suffisant à l\'arrière de ce réfrigérateur avec congélateurafin de favoriser une bonne ventilation. La température de l\'appareil se règle très simplement à l\'aide d\'un bouton dédié. ', 'AYA Réfrigérateur 2 portes - 206L', '54.2 x 143.4 x 55cm', 259.99, 'P4-REF-2022-1-12R', 'Reconditioned', 25, 4, 12),
(16, 'Rien de tel qu\'un bon café pour bien commencer la journée ! Offrant un excellent rapport qualité-prix, la cafetière SIGNATURE CA4313 est un modèle classique fonctionnant avec un filtre. Très simple d\'utilisation, elle dispose d\'un réservoir de 1,25 L qui permet de préparer jusqu\'à 10 tasses du précieux breuvage. Le niveau d\'eau est visible, pour que vous puissiez savoir quelle quantité d\'eau il reste. Cette cafetière noire et inox possède un système de maintien au chaud idéal pour profiter d\'une boisson à la bonne température tout au long de la matinée. Le nettoyage des différents éléments est facile et peut se faire directement sous l\'eau du robinet. Cette cafetière de 1,25 L de contenance mise sur un design élégant. Vous apprécierez sa finition bimatière où le noir sublime la brillance de l\'inox. Cette cafetière fait partie d\'une collection d\'éléments assortis pour le petit-déjeuner, parfaits pour créer une déco de cuisine coordonnée. La verseuse est en verre.', 'SIGNATURE Cafetière Coffee Maker', '58 x 11 x 35cm', 21.99, 'P4-CAF-2022-1-11R', 'Reconditioned', 5, 4, 11),
(17, 'Ici, les couleurs exultent et s\'en donnent à coeur joie ! Linge de lit imprimé multicolore. Uni bordeaux. Finition surjet bourdon bordeaux. Percale 100% coton, 80 fils/cm2. Lavage à 60°', 'Housse de couette - Joie de vivre', '140 x 200cm', 21.99, 'P5-HOU-2022-1-11', 'New', 75, 5, 11),
(18, 'Côté fleurs ou côté carreaux, un vent de fraîcheur souffle dans votre chambre. Linge de lit imprimé fleuri multicolore associé à un imprimé de carreaux verts. Percale 100% coton, 80 fils/cm2. Lavage à 60°.', 'Housse de couette - Fleurs d\'anis', '200 x 200cm', 135, 'P5-HOU-2022-1-12', 'New', 60, 5, 12),
(19, 'Vinaigre blanc 20° multi usages. Fait briller tous types de support. Idéal nettoyant intensif a l\'intérieur et à l\'extérieur', 'Vinaigre blanc 20° - Gloss', '10L', 28.75, 'P6-VIN-2022-1-12', 'New', 60, 6, 12),
(20, 'Bon rapport qualité/ prix ! 1 face verte pour le récurage. 1 face éponge végétale pour nettoyer, absorber et essuyer. Bonnes propriétés récurantes et grande capacité l\'absorption. Pour le nettoyage courant de la vaisselle, des plaques de cuisson, des pianos, des éviers. Rinçage facile. Eponge flexible et souple. Le lot de 10 tamponges.', '10 tamponges professionnels Bernard verts, 13 x 9 x 2,2 cm', '13 x 9 x 2,2cm', 9, 'P6-VIN-2022-1-11', 'New', 150, 6, 11);

-- --------------------------------------------------------

--
-- Structure de la table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
CREATE TABLE IF NOT EXISTS `supplier` (
  `company` varchar(50) NOT NULL,
  `type_of_supplier` varchar(50) DEFAULT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `supplier`
--

INSERT INTO `supplier` (`company`, `type_of_supplier`, `id`) VALUES
('Sopra', NULL, 11),
('AJC', NULL, 12);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `discount` int(11) NOT NULL,
  `firstname` varchar(30) NOT NULL,
  `is_validated` bit(1) DEFAULT NULL,
  `id` int(11) NOT NULL,
  `lastname` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`discount`, `firstname`, `is_validated`, `id`, `lastname`) VALUES
(0, 'Jane', NULL, 9, 'Doe'),
(0, 'John', NULL, 10, 'Doe');

-- --------------------------------------------------------

--
-- Structure de la table `user_adresses`
--

DROP TABLE IF EXISTS `user_adresses`;
CREATE TABLE IF NOT EXISTS `user_adresses` (
  `user_id` int(11) NOT NULL,
  `city` varchar(35) NOT NULL,
  `number` varchar(35) NOT NULL,
  `pc` varchar(35) NOT NULL,
  `way` varchar(35) NOT NULL,
  PRIMARY KEY (`user_id`,`city`,`number`,`pc`,`way`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `FKn8edb4epg8k2xutqkoa7knt9v` FOREIGN KEY (`id`) REFERENCES `account` (`id`);

--
-- Contraintes pour la table `artisan`
--
ALTER TABLE `artisan`
  ADD CONSTRAINT `FKd334f8g839konpr9h1gij4d5y` FOREIGN KEY (`id`) REFERENCES `supplier` (`id`);

--
-- Contraintes pour la table `basket`
--
ALTER TABLE `basket`
  ADD CONSTRAINT `FKfp7yinn3dh4sy1ia364xp3d9g` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `merchant`
--
ALTER TABLE `merchant`
  ADD CONSTRAINT `FK35cc2itoh7skk963okgolootl` FOREIGN KEY (`id`) REFERENCES `supplier` (`id`);

--
-- Contraintes pour la table `order_detail`
--
ALTER TABLE `order_detail`
  ADD CONSTRAINT `FK191acqcunrl0xo32ub778fqa6` FOREIGN KEY (`order_id`) REFERENCES `basket` (`id`),
  ADD CONSTRAINT `FKb8bg2bkty0oksa3wiq5mp5qnc` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`);

--
-- Contraintes pour la table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `FK1mtsbur82frn64de7balymq9s` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  ADD CONSTRAINT `FK2kxvbr72tmtscjvyp9yqb12by` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`);

--
-- Contraintes pour la table `supplier`
--
ALTER TABLE `supplier`
  ADD CONSTRAINT `FKhxhcs9i8povygg78n7ui67l14` FOREIGN KEY (`id`) REFERENCES `account` (`id`);

--
-- Contraintes pour la table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FKre5uwuepts6lywms9h3ksux9s` FOREIGN KEY (`id`) REFERENCES `account` (`id`);

--
-- Contraintes pour la table `user_adresses`
--
ALTER TABLE `user_adresses`
  ADD CONSTRAINT `FKh9r96dgv6vd3qjvc39x1hpk4u` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
