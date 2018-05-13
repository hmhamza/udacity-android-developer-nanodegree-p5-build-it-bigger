# Build It Bigger

### Gradle for Android and Java Final Project
In this project, I created an app with multiple flavors that uses multiple libraries and Google Cloud Endpoints. The finished app consists of four modules. A Java library that provides jokes, a Google Cloud Endpoints (GCE) project that serves those jokes, an Android Library containing an activity for displaying jokes, and an Android app that fetches jokes from the GCE module and passes them to the Android Library for display.

### Why this Project
As Android projects grow in complexity, it becomes necessary to customize the behavior of the Gradle build tool, allowing automation of repetitive tasks. Particularly, factoring functionality into libraries and creating product flavors allow for much bigger projects with minimal added complexity.

### Required Components
- Project contains a Java library for supplying jokes
- Project contains an Android library with an activity that displays jokes passed to it as intent extras.
- Project contains a Google Cloud Endpoints module that supplies jokes from the Java library. Project loads jokes from GCE module via an async task. Note that this GCE module doesn't need to be deployed to a server. Local testing works fine.
- Project contains connected tests to verify that the async task is indeed loading jokes.
- Project contains paid/free flavors. The paid flavor has no ads, and no unnecessary dependencies.

### Required Behavior
App retrieves jokes from Google Cloud Endpoints module and displays them via an Activity from the Android Library.

### What I Learnt?
I understood the role of Gradle in building Android Apps and how to use Gradle to manage apps of increasing complexity. I learnt how to:

- Add free and paid flavors to an app, and set up the build to share code between them
- Factor reusable functionality into a Java library
- Factor reusable Android functionality into an Android library
- Configure a multi project build to compile the libraries and app
- Use the Gradle App Engine plugin to deploy a backend
- Configure an integration test suite that runs against the local App Engine development server

### How I Completed this Project?

#### Step 1: Create a Java library
Create a Java library that provides jokes. Create a new Gradle Java project either using the Android Studio wizard, or by hand. Then introduce a project dependency between the app and the new Java Library.

#### Step 2: Create an Android Library
Create an Android Library containing an Activity that will display a joke passed to it as an intent extra. Wire up project dependencies so that the joke can be passed from the Java Library to the Android Library.

#### Step 3: Setup GCE
Instead of pulling jokes directly from the Java library, set up a Google Cloud Endpoints development server, and pull our jokes from there. The starter code already contained the GCE module.

Before going ahead, I had to run a local instance of the GCE server. In order to do that, we need to install the Cloud SDK:

https://cloud.google.com/sdk/docs/

Once installed, follow the instructions in the Setup Cloud SDK section at:

https://cloud.google.com/endpoints/docs/frameworks/java/migrating-android

Introduce a project dependency between Java library and the GCE module, and modify the GCE starter code to pull jokes from Java library. Create an AsyncTask to retrieve jokes. Make the button kick off a task to retrieve a joke, then launch the activity from your Android Library to display it.

#### Step 4: Add Functional Tests
Add code to test that the Async task successfully retrieves a non-empty string.

#### Step 5: Add a Paid Flavor
Add free and paid product flavors to the app. Remove the ad (and any dependencies you can) from the paid flavor.

#### Optional Tasks
For extra practice to make my project stand out, I completed the following tasks.

##### Add Loading Indicator
Add a loading indicator that is shown while the joke is being retrieved and disappears when the joke is ready. I followed [this](http://www.tutorialspoint.com/android/android_loading_spinner.htm) tutorial.

---

# Project Review

🎉🎉🎉 Congratulations!!   
Your submission looks great! 👏👏👏.  
Work done in this project makes your effort apparent and I really appreciate it.

I will encourage you to keep this work on in upcoming projects.  
You have done a good job.  
All the specifications were met correctly.

Keeping a certain level of expectations from our student is crucial to your improvement, and we will not let you fall behind.

My best wishes for your course and next project too  
Have a nice day 😊👍


### Common Project Requirements

##### :heavy_check_mark: App is written solely in the Java Programming Language

##### :heavy_check_mark: App utilizes stable release versions of all libraries, Gradle, and Android Studio.

### Required Components
##### :heavy_check_mark: Project contains a Java library for supplying jokes.

##### :heavy_check_mark: Project contains an Android library with an activity that displays jokes passed to it as intent extras.

##### :heavy_check_mark: Project contains a Google Cloud Endpoints module that supplies jokes from the Java library. Project loads jokes from GCE module via an AsyncTask.

##### :heavy_check_mark: Project contains connected tests to verify that the AsyncTask is indeed loading jokes.

##### :heavy_check_mark: Project contains paid/free flavors. The paid flavor has no ads and no unnecessary dependencies.    Ads are required in the free version.

You have made the required changes perfectly! 👏👏


### Required Behavior
##### :heavy_check_mark: App retrieves jokes from Google Cloud Endpoints module and displays them via an Activity from the Android Library. Note that the GCE module need only be deployed locally.

##### :heavy_check_mark: App conforms to common standards found in the [Android Nanodegree General Project Guidelines](http://udacity.github.io/android-nanodegree-guidelines/core.html).
