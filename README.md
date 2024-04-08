# Berlin clock

This Android app showcases the Berlin Clock, a time-telling device that utilizes a series of
illuminated colored blocks. The app is built using Clean Architecture + MVVM + TDD

This characteristic clock reads from top to bottom.

- The top big lamp - (yellow) - blinks to indicate seconds and remains illuminated only during even
  seconds.
- The first line - 4 lamps (red) - each lamp representing five hours.
- The second line - 4 lamps (red) - each lamp represents one hour.
- The third line - 11 lamps (yellow, every 3rd is red) - each lamp represents five minutes.
- The fourth line - 4 lamps (yellow) - each lamp represents one minute.

# Inspiration
Code Katas
https://code-exercises.com/#google_vignette
http://codekata.com/
https://github.com/gamontal/awesome-katas

## Current Tech Stack

- Kotlin
- Jetpack Compose
- Coroutines + Flow for asynchronous
- MVVM + Clean architecture 
- StateFlow and ViewModel
- Dagger Hilt - Dependency Injection


# TODO
- Compose
- Stateflow
- Nav Utils
- Test coverage
- Instrumentation Tests
- Device configuration handling - Tablets, foldable etc
- Settings screen - Color picker
- See if clock Widget is possible (if because how to send updates to the widget every second)
- Chrome App
- Multi platform (Android, Chrome, iOS) 



