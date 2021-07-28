# GemographyChallenge
My solution to Gemography for backend challenge for the rest microservice that can retrieve information about the repository of the last 30 days.
## Functional specs
- Develop a REST microservice that list the languages used by the 100 trending public repos on GitHub.
- For every language, you need to calculate the attributes below:
    - Number of repos using this language.
    - The list of repos using the language.

## API List
- ```localhost:8080\api\v1\languages``` list of the languages used by the 100 trending public repos on GitHub.
    - ![1](https://user-images.githubusercontent.com/48381378/127367467-fec40403-7212-430f-ae64-6d3ba6d24bd5.PNG)

- ```localhost:8080\api\v1\informations\{language}``` number of respos and the list of repos by language
    - ![2](https://user-images.githubusercontent.com/48381378/127367494-d30b8941-a813-4620-bd20-2e676ee5cfbc.PNG)


