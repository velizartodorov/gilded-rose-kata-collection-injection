# Introduction

Implementation of
the [Gilded Rose Kata](https://github.com/emilybache/GildedRose-Refactoring-Kata/tree/main/Java) in
Spring Boot, using Collection Injection. All
implementations are complying towards the abstract class `ItemType`, and are turned into a
`List<ItemType>`
inside the `ItemFactory` class, and alter consumed in the `ItemController` using Spring's
`@Autowired` annotation.

Beyond the basic tests, the `ItemControllerTest` is demonstrating clearly the behaviour.