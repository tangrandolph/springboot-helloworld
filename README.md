# Java Version Management

jenv 管理多版本 Java

jenv add /Library/Java/JavaVirtualMachines/jdk-21.jdk/Contents/Home
jenv versions
jenv global 21.0

# Common Springboot Errors

invalid flag: --release
需要在 idea 的 project settings / maven importing / maven run 中的 jdk 配置一致才行  
环境变量需要配置 JAVA_HOME，其他都不需要

# Remote Debian Config


## Run redis cluster via K3S
kubectl Unauthorized error  
`cp /etc/rancher/k3s/k3s.yaml ~/.kube/config`

```bash
# install redis cluster
helm repo add bitnami https://charts.bitnami.com/bitnami
helm repo update
helm install my-redis bitnami/redis

export REDIS_PASSWORD=$(kubectl get secret --namespace default my-redis -o jsonpath="{.data.redis-password}" | base64 -d)
kubectl port-forward --namespace default svc/my-redis-master 6379:6379 &
REDISCLI_AUTH="$REDIS_PASSWORD" redis-cli -h 127.0.0.1 -p 6379
```

## Run redis singleton
Modify /etc/redis.conf file
1. `protected-mode no` # allow remote login
2. `requirepass redis` # set password
3. `redis-cli` to locally login
4. `AUTH redis` # verify
5. `ACL SETUSER default on >redis` # may not need
```bash
redis-server /etc/redis.conf &
```

## Config mariaDB
Install `sudo apt install mariadb-server`  
Modify config file /etc/mysql/mariadb.conf.d/50-server.cnf
```
bind-address            = 0.0.0.0
```
`service mysql restart`  
Login locally `mysql -u root -p` (seems locally need no password, you can input anything)
```SQL
create user 'root'@'%' identified by 'mariadb';
FLUSH PRIVILEGES;

# change password to mariadb
set password for username@localhost = password('mariadb');
# show users
use mysql;
select User, Host from user;
```

# Import logback
add logback-xml in resource folder