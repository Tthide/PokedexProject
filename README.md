After cloning this repository, if you have a Java environment on your machine, you can directly run the commands.


# Build the project

```
./gradlew build
```



# Run the application

```
./gradlew run
```

To run the application with command line arguments, First argument is the Id of the pokemon of which you want the entry, Second Argument(OPTIONNAL) needs to be the path of a local sqlite database containing entries of the pokedex  :

```
./gradlew run --args="'1' 'ressources/pokemondatabase.sqlite'"
```


# Run the tests

```
./gradlew test
```
