# Java Rest Complex Structures

## Functionality
This service connects to shopify wit the credentials provided by Returnly's team. 
Retrieves all the orders of the shop and applies several transformations:
- Total number of orders 
- Number of unique customers 
- Most and least frequently ordered items
- Median order value (please note median is different from the average)
- Shortest interval between any two consecutive orders placed by the same customer

## Code structure
The structure of the service has been changed to a standard micro services structure:
- Model for the domain and POJO objects
- Service for the service and it's implementation
- Controller for the controller and the ExceptionHandler
- Utils for classes with utility methods and other common stuff
In addition, sensitive information has been stored in application.properties, in the "resources" folder.
  
## Language
The service is coded 100% in Java. 
While I understand that Kotlin's syntax has similarities with Scala's, I'm not confident enough to use Kotlin as the main language without spending more time than the necessary.

## Tests
I've coded several unit tests that, I expect, are enough coverage for the exercise.

## Performance
Because of my experience as Data Engineer in jobs where the volume of data was huge, I think that the key of this exercise is filtering the json files before they are inserted into a data structure. 
The "order" json is huge and have a lot of fields which aren't necessary for the purpose of the exercise.

## Docker
The project is prepared to generate a Docker image using gradle. However, I can't try this feature because I don't have installed docker in my work-PC.
