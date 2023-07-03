# Marvel
👽 For best practices: Clean Architecture, Multi Modules, Hilt, MVVM, Coroutines with migrating a View-based app to Jetpack Compose.

## 🏛 Architecture
### Clean Architecture
<img width="1505" alt="image" src="https://github.com/youlalala/Marvel/assets/62279741/ad92ac74-1a74-49df-a226-969b0cba96ba">

The application consists of 3 layers.

1. **Presentation Layer** <br/>
    - `view` : Displays the application data on the screen (Activity/Fragment)
    - `viewmodel` : Stores UI realted data and interacts with the domain layer.
2. **Domain Layer** <br/>
  Contains the **business logic** of the application. <br/>
  It's a individual moduel and complete java/kotlin module. <br/> 
  The domain layer is responsible for encapsulating complex business logic, or simple business logic that is reused by multiple ViewModels.
    - `usecase` : Contains the business logic of the application.
    - `repository interface`
    - `model` (domain) : Represents the domain-specific objects or entities.
3. **Data Layer** <br/>
   Handles data retrieval, storage, and mapping.
    - `datasource` : Represents the source of data, such as a network API or a local DB responsible for data retrieval and storage.
    - `repository impl` : Implments the repository interface in the domain layer.
    - `mapper` : Converts data model to domain model.
    - `model` (dto) : Represents the data structure or objects used within the data layer.

### Modularization & dependencies
<p align="center">
<img width="300" alt="image" src="https://github.com/youlalala/Marvel/assets/62279741/a5a25aff-5596-498f-b7c7-9e70caeb9dc0"> 
</p>
 
  - `app` : Serves as an entry point to the application.
  - `feature` : Contains an isolated part of an app's functionality.
  - `common-ui` : Contains custom UI elements that helps make UI consistent across different features.
  - `domain` : Encapsulates the business logic of the application.
  - `data` : Containes a repository, data sources and model classes.


## ⚒ Tech Stack

작성중(...)
