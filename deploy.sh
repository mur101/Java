cd ../home/ration24/backend
pgrep java | xargs kill -9
nohup java -jar JavaEdition-0.0.1-SNAPSHOT.jar > log.txt &
tail -f log.txt