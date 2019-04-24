# Exercise
Your task is to write the first screen of a new app all about Mars. This screen will show a gallery of images returned from the [NASA Image and Video Library API](https://api.nasa.gov/api.html#Images).

Here is the API call you should use to obtain image links and metadata: https://images-api.nasa.gov/search?q=mars&media_type=image 

In essence, for each item in `collection -> items` in the API response, we want you to display a card with the image found under `links -> href` and also show `data -> description` and `data -> date_created`.

A rough design can be found in the file `design.png` in the same directory as this readme (with placeholder images, obviously).

## Notes
Please don’t spend any more than 2–3 hours on this exercise. We don’t expect you to completely finish, but it would be great if you could get something working end-to-end and have an idea of what else you would do, given more time. Please write this down as notes when send us the exercise.

You may write your code in Kotlin or Java.

## What we're looking for
* The app must work offline, as best it can. It is up to you to decide how the app should behave in this situation.
- The app is using caching for images (provided by the library). And is using in memory caching for metadata. The cache in memory has a validity of 2 hours. 

* The ability to explain why you decided to implement something the way you did, what you explicitly decided not to do and what improvements you would make given more time.
- I've used Retrofit for network calls, Picasso for image loading. Both libraries are powerful and easy to customise. I've used the MVP for achieving high level of modularity and this way having a easy way of implementing the tests. For improvement I would've implemented a mechanism for caching in Database. Add the unit tests and improve the design.

* Good architectural principles. You should assume that this screen will form part of a larger project, with many screens.
* Readable, maintainable code.
* If you’re about to run out of time, add a few comments indicating what you were planning to do.

* Examples of how to test different parts of your codebase. For this assessment, you don’t have to test everything.
- Since the usage of MVP, we are achieving a high level of testability. And I would've used Mockito and JUnit for testing, replacing the logic for providing data to mock one, and focusing in testing the logic in Presenter. 

* Resilience to Android app component lifecycle changes.
- To be safe, we are using in cache memory, and this way any lifecycle change will defend us against the problems with loading the data every time. For future we can use ViewModel class from Google.

* Use of open source libraries, where appropriate.
