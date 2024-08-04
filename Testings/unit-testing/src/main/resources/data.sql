CREATE TABLE IF NOT EXISTS item (
                                    id INT PRIMARY KEY,
                                    name VARCHAR(255),
    price DECIMAL,
    quantity INT
    );

insert into item(id, name, price, quantity)
values(10001,'Item1',10,20);
insert into item(id, name, price, quantity)
values(10002,'Item2',5,10);
insert into item(id, name, price, quantity)
values(10003,'Item3',15,2);