# labforward-task

The project is created using SpringBoot. Spring Web is used as the main framework. Spring Data JPA is used for accessing and manipulating the database.
And H2 database is used for storage.

The project is structured regarding a simple Controller <-> Service <-> Repository architecture.
Dto objects are used for consuming data from the controllers. These dtos are converted to database model objects in the service layer.
Also model objects are converted to dtos when requesting data from database.

There are four models :

CategoryModel : Definition table for storing categories <br>
AttributeModel : Definition table for storing attributes belonging to a category <br>
ItemModel : Model for storing items <br>
AttributeValueModel: Model for storing attribute values belonging to an item <br>

Also, there are 4 dtos corresponding to these models.

In order to avoid cycling during mapping from dtos to models and models to dtos (regarding parent-child relations), conditions are added to mapper methods for controlling cycling.

There are 4 endpoints corresponding to the requirements of the task. These are :

/createCategory<br>
/createItem<br>
/updateItem<br>
/itemsByCategory/{categoryId}

Category creation is straightforward. Category name and attributes belonging to that category are given as input. <br>
Integrity checks are performed during updateItem and createItem requests. If an attribute does not belong to the given category, an error message
is returned. Also, if more than one attribute with the same id is given as input, an error message is returned too. <br>
When querying for items belonging to a category, if the provided category does not exist in the database, an exception is thrown and a message is returned to user. <br>

You can start the application by right-clicking TaskApplication and select Run from your IDE. You can also launch the application by
running <i>./mvnw clean spring-boot:run</i> or <i>mvn clean spring-boot:run</i> within the path of the project. <br>

H2 database can be accessed while running the application on http://localhost:8080/h2-console/ with the following parameters : <br>
JDBC URL : jdbc:h2:mem:taskdb <br>
username : sa <br>
password : (empty) <br>

A postman collection named <i>Labforward Task.postman_collection.json</i> is added to the base path of the repository for easy-access to services.
