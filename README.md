colleague
=========

Simple, easy-to-use Java API that allows functional interactions with collections. Operations can be run over elements of a collection, considering a predicate.

There is a set of predefined predicates and operations and user can implement any others.

Simple predicates can be combined to build complex predicates.

Examples
---------

Consider a list of strings.

Get the elements that start with "Foo":

```java
List<String> l = Colleague.getElements(list, new StartsWithPredicate("Foo"));
```

Get the second element that does not end with "bar":

```java
String second = Colleague.getElementAt(list, 1, new NotPredicate(new EndsWithPredicate("bar"));
```
