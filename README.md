```mysql -uroot -proot```
```sudo docker container run --name mysqldb -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=easybank -d mysql:8```
```sudo docker container exec -it {CONTAINER ID} bash```