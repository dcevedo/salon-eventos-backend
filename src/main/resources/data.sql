INSERT INTO score(value) VALUES ("0");
INSERT INTO score(value) VALUES ("1");
INSERT INTO score(value) VALUES ("2");
INSERT INTO score(value) VALUES ("3");
INSERT INTO score(value) VALUES ("4");
INSERT INTO score(value) VALUES ("5");

INSERT INTO client(name,email,age,password) VALUES ("Armando Cervera","armandoc5@hotmail.com",33,"cerveras33");
INSERT INTO client(name,email,age,password) VALUES ("Juliana Vasquez","juliv99@gmail.com",24,"vasjuli2020"); 
INSERT INTO client(name,email,age,password) VALUES ("Edison Mendez","edimendez11@gmail.com",37,"donedi33"); 
INSERT INTO client(name,email,age,password) VALUES ("Mariana Vargas","vargasmaria25@hotmail.com",55,"mariv007"); 
INSERT INTO client(name,email,age,password) VALUES ("Erick Arenas","eriarenas11@hotmail.com",60,"arenick22"); 
INSERT INTO client(name,email,age,password) VALUES ("Vanessa Perez","vane19perez@gmail.com",19,"vperez19"); 
INSERT INTO client(name,email,age,password) VALUES ("Carlos Lopez","car15lopez@gmail.com",40,"carlitos2000"); 
INSERT INTO client(name,email,age,password) VALUES ("Andrea Bermudez","andrebermu0@hotmail.com",21,"bermua99"); 
INSERT INTO client(name,email,age,password) VALUES ("Alberto Mosquera","malbero12@gmail.com",29,"mosquealbert22"); 
INSERT INTO client(name,email,age,password) VALUES ("Daniela Perez","danipere44@hotmail.com",34,"danitaperez44"); 

INSERT INTO category(name,description) VALUES ("Juegos","para juegos de mesa");
INSERT INTO category(name,description) VALUES ("Fiestas","para fiestas");
INSERT INTO category(name,description) VALUES ("Reuniones","para pocas personas");
INSERT INTO category(name,description) VALUES ("Conferencias","para muchas personas");

INSERT INTO partyroom(name,owner,capacity,description,category_id) VALUES ("Salon Xbox","Julian Mesa",25,"salon para videojuegos en xbox",1);
INSERT INTO partyroom(name,owner,capacity,description,category_id) VALUES ("Salon PlayStation","Andres Bernal",22,"salon para videojuegos en playStation",1);
INSERT INTO partyroom(name,owner,capacity,description,category_id) VALUES ("Salon quinceañera","Andrea Soto",100,"salon para fiestas de quinceañeras",2);
INSERT INTO partyroom(name,owner,capacity,description,category_id) VALUES ("Salon rumba-electro","Miguel Hernandez",300,"salon para rumba electronica",2);
INSERT INTO partyroom(name,owner,capacity,description,category_id) VALUES ("Salon sala redonda","Camilo Vega",20,"salon para reuniones de oficina",3);


INSERT INTO message(messageText,client_id,partyroom_id) VALUES ("Buen espacio en el sitio",1,1);
INSERT INTO message(messageText,client_id,partyroom_id) VALUES ("Bastantes juegos",2,1);
INSERT INTO message(messageText,client_id,partyroom_id) VALUES ("Cuenta con equipo de oficina",3,5);
INSERT INTO message(messageText,client_id,partyroom_id) VALUES ("Fiesta inolvidable de mi hija",4,3);

INSERT INTO reservation(startDate,devolutionDate,status,client_id,partyroom_id,score_id) VALUES ("2020-01-01","2020-01-02","created",1,1,5);