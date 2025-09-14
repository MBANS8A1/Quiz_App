# Quiz App of General Knowledge

## How the application operates 

This is an application made in Kotlin that uses knowledge questions to test the users' intellect.
The user will start by inputting their name on the home screen and then clicking the "Next" button to be presented with a question on each page with four possible answers; only one option is the correct one. The user will be presented with a score on the results page letting him/her know how well he/she performed as a fraction of the total number of questions.


## Screens presented

   1. Home Screen (HomeFragment)

   * You will be presented with a welcome screen where you will be required to input your name. You will not be able to click on the "Next" button until you enter a name. If you do not enter a name and try to click "Next", you will receive an error warning stating you should enter your name first. The name entered is passed via the Bundle to the next fragment (QuestionFragment).

 <img src="https://github.com/MBANS8A1/Quiz_App/blob/5494a53172b31b75439e6090737c6f7df80170e3/app/src/main/res/drawable/quiz_image1.png" alt="Error home page" width="250" height="490">


 <img src="https://github.com/MBANS8A1/Quiz_App/blob/5494a53172b31b75439e6090737c6f7df80170e3/app/src/main/res/drawable/quiz_image2.png" alt="Home page with name" width="250" height="490">

   2. Question Screen(s)

   * You will be presented with a question in bold with a progress bar below indicating how many questions are remaining. Read the question and choose the option you think is the correct answer. When you touch an option it will be coloured with a blue outline. If the option is correct when you click the "Next" button, it will be coloured solid green; if the option is wrong it will be coloured a solid red. Once the wrong and correct answers have been highlighted, click the "Next" button to move on. Your scoring will be collected and passed again via a Bundle obejct to where it will be retrieved at the Result Screen
   
 <img src="https://github.com/MBANS8A1/Quiz_App/blob/5494a53172b31b75439e6090737c6f7df80170e3/app/src/main/res/drawable/quiz_image3.png" alt="Selected answer" width="250" height="490">


 <img src="https://github.com/MBANS8A1/Quiz_App/blob/5494a53172b31b75439e6090737c6f7df80170e3/app/src/main/res/drawable/quiz_image4.png" alt="Correct answer" width="250" height="490">


 <img src="https://github.com/MBANS8A1/Quiz_App/blob/5494a53172b31b75439e6090737c6f7df80170e3/app/src/main/res/drawable/quiz_image5.png" alt="Wrong answer" width="250" height="490">


   3. Result Screen

   * When you have answered all the questions, your score will be displayed (along with your name) and you will get a message stating whether your score is **poor**, **average** or **really good**. Also, there will be a "Finish" button, which will allow you to exit the application. The score is passed to the Result Screen via a Bundle object from the QuestionFragment.

 <img src="https://github.com/MBANS8A1/Quiz_App/blob/5494a53172b31b75439e6090737c6f7df80170e3/app/src/main/res/drawable/quiz_image6.png" alt="Result screen" width="250" height="490">



