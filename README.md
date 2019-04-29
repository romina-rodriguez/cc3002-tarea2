# CC3002-TAREA1: Pokémon TCG
The goal of this project is to implement a clone of the Pokémon trading card game, using the Double Dispatch technique. 

## Rough Project Description
Since this is a Pokémon game, the major entities at play are the Trainers and the Cards. 
The Trainer must be able to use said cards in a fight by drawing them from their deck. They must select a Pokémon Card as the current active Pokémon at play, and can also bench 5 other Pokémon. They should be able to select an ability of their active Pokémon to attack their rival.

As previoustly mentioned, a card can be an instance of a Pokémon Card, and there also exists Enery Cards (6 types for both cards: electric, fighting, psychic, fire, water, grass).

A Pokémon card's main purpose is to keep track of its health points and store the different energies that the trainer obtains from de the deck (by drawing Energy Cards) to unlock different attacks (each attack has an enery cost), that will behave differently depending on whether the Pokémon that recieves it is weak or resistant against said attack, as shown in the table below.

| Type          | Weakness              | Resistance  |
| ------------- |:---------------------:| -----------:|
| Grass         | Fire                  | Water       |
| Fire          | Water                 |             |
| Water         | Electric, Grass       | Fighting    |
| Electric      | Fighting              |             |
| Fighting      | Psychic, Grass        |             |
| Psychic       | Psychic               | Fighting    |

For this instance, when the active Pokémon dies (its health points equal zero), the trainer's active Pokémon should be replaced by the first one on the trainer's bench, and we don't concern ourselves with the case in wich the trainer doesn't have any Pokémon to promote to active, wich is of course when said trainer loses the game.
When working with multiple classes that share several methods, an efective design uses Interfaces and Abstract Classes, which is what was done here. The interfaces, abstract classes and classes are as follows:

* ICard
* IPokemon
* IEnergy
* IAttack
* AbstractPokemon
* AbstractEnergy
* AbstractAttack
* Trainer

Each abstract class has 6 subclasses of the previoustly mentioned types (electric, fighting, psychic, fire, water, grass) with it's specific behavior for each. To implement the wanted methods, Double Dispatch was repeteadly used, as it makes sense to use it when interacting with different classes that implement the same interface. Everything here is stored in the pokemon package.

The tests reached 91% line coverage and are stored in the Test package.

## Prerequisites
This implementation was done using Java SE 8u111.

## Authors
* **Romina Rodríguez** - [romina-rodriguez](https://github.com/romina-rodriguez)

## Acknowledgments
* This implementation was heavily influenced by a class excercise (Auxiliar 3, CC3002-1, Fall, 2019) done by Ignacio Slater.
