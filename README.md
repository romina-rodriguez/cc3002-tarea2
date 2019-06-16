# CC3002-TAREA2: Pokémon TCG
The goal of this project is to implement a clone of the Pokémon trading card game, using the Double Dispatch technique. 

## Rough Project Description
Since this is a Pokémon game, the major entities at play are the Trainers and the Cards. 
The Trainer must be able to use said cards in a fight by drawing them from their deck. They must select a Pokémon Card as the current active Pokémon at play, and can also bench 5 other Pokémon. They should be able to select an ability of their active Pokémon to use in battle.

As previoustly mentioned, a card can be an instance of a Pokémon Card, and there also exists Energy Cards (6 types for both cards: electric, fighting, psychic, fire, water, grass) and Trainer Cards (Stadium, Supporter, Item). A Pokémon can be basic, or evolved (first and second phase), with differences and its requirements to be used.

A Pokémon card's main purpose is to keep track of its health points and store the different energies that the trainer obtains from de the deck (by drawing Energy Cards) to unlock different abilities (each ability has an energy cost). When it comes to attacks, they will behave differently depending on whether the Pokémon that receives it is weak or resistant against said attack, as shown in the table below.

| Type          | Weakness              | Resistance  |
| ------------- |:---------------------:| -----------:|
| Grass         | Fire                  | Water       |
| Fire          | Water                 |             |
| Water         | Electric, Grass       | Fighting    |
| Electric      | Fighting              |             |
| Fighting      | Psychic, Grass        |             |
| Psychic       | Psychic               | Fighting    |

When working with multiple classes that share several methods, an efective design uses Interfaces and Abstract Classes, which is what was done here. The interfaces, abstract classes and classes are as follows:

* IAbility
* ICard
* IPokemon
* IEnergy
* IAttack
* IBasicPokemon
* IEvoPokemon
* AbstractAbility
* AbstractCard
* AbstractPokemon
* AbstractEnergy
* AbstractAttack
* AbstractTrainerCard
* Trainer

To implement the wanted methods, Double Dispatch was repeteadly used, as it makes sense to use it when interacting with different classes that implement the same interface. Everything here is stored in the pokemon package.
A visitor pattern was meant to be used to introduce new functionalities, but due to the fact that just implementing said functionalities directly was easier with the structure of the already existing code, that's what was ultimately chosen. Said functionalities are:

* Electric Shock
* Potion
* Fire Spin
* Professor Juniper
* Training Center
* Damage Swaps

They have matching tests names in the package test.requirements.
A controller was implemented (with Observer) to handle the different turns between the two players, keeping track of the amount of cards played. The game ends when all cards from either player's deck run out.

## Prerequisites
This implementation was done using Java SE 8u111.

## Authors
* **Romina Rodríguez** - [romina-rodriguez](https://github.com/romina-rodriguez)

## Acknowledgments
* This implementation was heavily influenced by a class excercise (Auxiliar 3, CC3002-1, Fall, 2019) done by Ignacio Slater.
