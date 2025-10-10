# Introduction

Implementation of the Gilded Rose Kata in Spring Boot, using Collection Injection. All
implementations are complying towards the abstract class `ItemType`, and are turned into a
`List<ItemType>`
inside the `ItemController` class, using Spring's `@Autowired` annotation.

Beyond the basic tests, the `ItemControllerTest` is demonstrating clearly the behaviour.