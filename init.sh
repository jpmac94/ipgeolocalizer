cd ipgeolocalizer
mvn -DskipTests=true clean package
cd ..
docker build -t ipgeolocalizer .
docker compose build
docker compose up
