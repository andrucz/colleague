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
List<String> l = Colleague.list(list, new StartsWithPredicate("Foo"));

List<String> l = list(list, startsWith("Foo"));
```

Get the second element that does not end with "bar":

```java
String second = Colleague.get(list, 1, new NotPredicate(new EndsWithPredicate("bar"));

String second = get(list, 1, not(endsWith("bar")));
```

Print all elements that are in upper case:

```java
Colleague.each(list, new UpperCasePredicate(), new PrintOperation(System.out));

each(list, isUpper(), new PrintOperation(System.out));
```

Execute some custom operation in elements that are in lower case:

```java
Operation<String> myOperation = new Operation<String>() {

  @Override
  public void execute(String element) throws OperationException {
    // interesting stuff
  }

};

Colleague.each(list, new LowerCasePredicate(), myOperation);

each(list, isLower(), myOperation);
```

Execute the operation in all elements:

```java
Colleague.each(list, myOperation);

each(list, myOperation);
```

Remove all null elements from a list:

```java
Colleague.remove(list, new IsNullPredicate());

remove(list, isNull());
```

Add to a list all elements from another list that are greater than 10:

```java
Colleague.add(list, anotherList, new GreaterThanPredicate(10));

add(list, anotherList, greaterThan(10));
```

Count the elements that are between 10 and 20:

```java
int c = Colleague.count(list, new BetweenPredicate(10, 20));

int c = Colleague.count(list, between(10, 20));
```

Verify if there is a element in the list that are not contained in another list:

```java
boolean b = Colleague.contains(list, new NotPredicate(new ContainedInPredicate(anotherList)));

boolean b = contains(list, not(containedIn(anotherList)));
```

Convert a list of string to a list with the length of each string:

```java
ElementConverter<String, Integer> myConverter = new ElementConverter<String, Integer>() {
  
    @Override
    public Integer convert(String element) {
      return element.length();
    }
  
}

List<Integer> lengths = Colleague.convert(list, myConverter);
```

Convert only non null elements:

```java
List<Integer> lengths = Colleague.convert(list, new NotPredicate(new IsNullPredicate()), myConverter);

List<Integer> lengths = convert(list, not(isNull()), myConverter);
```