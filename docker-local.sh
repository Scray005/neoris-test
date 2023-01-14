./gradlew compileJava compileTestJava assemble build

docker build -t neoris-test .

docker run --name neoris-test -p 80:80 -d neoris-test