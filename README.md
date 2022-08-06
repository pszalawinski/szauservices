#### in normal approach there should be separate container for the fraud service but for sake of saving local space now I will do everything in the same db


##Start:
To start application, firstly run docker-compose.yml to create docker postgres database.

## Some kubectl commands:


kubectl apply -f path
kubectl delete -f path

kubectl get po
kubectl get svc
kubectl get po -w

kubectl logs postgres-0

kubectl exec -it postgres-0 -- psql -U amigoscode

kubectl describe pod podName

kubectl logs podName
kubectl logs -f podName

kubectl exec -it postgres-0 -- psql -U linpostgres -h lin-4621-419-pgsql-primary.servers.linodedb.net
kubectl exec -it postgres-0 -- psql --help
kubectl exec -it postgres-0 -- psql -U linpostgres -h lin-4621-419-pgsql-primary.servers.linodedb.net
kubectl exec -it postgres-0 -- bash

psql -U host -U username -d database
\d
\dt
\c databaseName
create database dbName;
select * from tableName;


