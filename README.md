It’s been a while since people have been working with Springboot and Hibernate. In this article, we will refresh some of the concepts of Hibernate that could be extremely useful for solving complex problems and writing reusable code.

Collections
When we work with ORM, we need to persist collections of items for example:

An employee can have multiple addresses.
A student can have various courses.
Java Collection framework has a List, Set, and Map. we will see how we can leverage these collections alongside Hibernate.

Mapping a Set Collection
/*
@ElementCollection: The Data for the collection stored in a separate table.
@CollectionTable: Here refer the table name and provide the join column 
                  attribute
*/
@ElementCollection
@CollectionTable(
        name = "image",
        joinColumns = @JoinColumn(name = "student_id")
)
@Column(name = "file_name")
private Set<String> images = new HashSet<String>();
In the below diagram, when the post contract gets executed it inserts data in the Student’s table and image table keeping integrity intact.


@ElementCollection can be defined as a relationship one-to-many to @Embeddable objects and Basic Objects like Integer, Double, Date String, etc.

@ElementCollection is similar to @OneToMany except the target object is not an Entity. So, we can’t query, persist, or merge target objects independently of their parent object. It always persisted, merged, and removed with their parent objects.

As we have done the mappings for the Set collection above we can also perform mapping with the List Collection, and Map with subtle tweaks.

@Embeddable
JPA provides @Embeddable annotation to declare a class that will be embedded in other entities. It promotes reusability across the entities.

When we embed any embeddable entities it adds entries in the same table. For example, we added AddressEntity in StudentEntity, so the records get added to the Student table.


Embeddable also provides the capability to have multiple embeds of the same embeddable with attribute override. We can have another address embedded with a different name like “Billing address” just we need to override the property to avoid the conflict.

@Enumerated
Java Enums are used when we know all possible values at compile time i.e. fixed sets of constant values. The most common option to map an enum value to and from its database is @Enumerated annotation.


Inheritance
Inheritance is not a new term for object-oriented programming language. We understand how much it is useful when it comes to reusability. We can keep the common data in the super-class and the sub-class can inherit the super-class.
There are a few downsides to using deep inheritance relationships in ORM

It may increase the complexity of the application.
It may impact the application's performance.
Inheritance mapping strategies
Single Table
Table per class
Joined table
Mapped superclass
Single Table Mapping Strategy
This strategy maps all entities in the inheritance tree to a single database table. A discriminator column indicates types/classes of data in the row. It has the best query performance and straightforward implementation.

The entities from different classes with a common ancestor are placed in a single table. JPA chooses this strategy by default if we don’t specify one explicitly.

For our example, we have created two entities i.e. DocotorEntity and EngineerEntity, and added one dedicated field in each. we can see in the image the new fields that each entity has assigned a new column to it and the value in other inserted as null, which we sometimes don’t like.


Table per class Mapping Strategy
The Table per Class strategy maps each entity to its table, which contains all the properties of the entity, including the ones inherited.

All the concrete classes are mapped to a table per class and include fields defined in the sub-class and inherited from the super-class.


When we query the base class, it will return all the subclass records as by using a UNION statement in the background. The use of UNION can also lead to inferior performance when choosing this strategy. Another issue is that we can no longer use identity key generation.

Joined Table Mapping Strategy
In this strategy, all the classes are mapped to the table, the superclass contains fields that are common to all subclasses, sub-classes table contains all the fields specific to the sub-class.

Inheritance will be modeled with a foreign key, and hibernate will join the data based on the primary key and foreign key relationship.


The disadvantage of this inheritance mapping method is that retrieving entities requires joins between tables, which can result in lower performance for large numbers of records.

The number of joins is higher when querying the parent class because it will join with every single related child — so performance is more likely to be affected the higher up the hierarchy we want to retrieve records

** Mapped Superclass Strategy
In this strategy, the subclass is mapped to a table and each table has the inherited fields and fields defined in the subclass.

The mapped superclass is no longer a separate table/entity only subclasses will use @Entity and only subclasses will have tables in the database.

Using the MappedSuperclass strategy, inheritance is only evident in the class but not the entity model. The implementation will be straightforward without impacting the performance.


Well, that was it for this article, Please do share your thoughts and challenges that you’ve faced in your project.

Thank you for reading! Have a great one!!
