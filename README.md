# IntroductoryCampaign
This README.md has the next structure:
  a) Description of the project (my variant).
  b) Installation Instructions.
  c) Instructions for launching the application.


  a) Description of the project:
      Varian №6 - System «Introductory Campaign»:
      The student registers for the exams.
      The administrator sets grades for items. 
      The student chooses a specialty at the university. 
      Formed rating lists of applicants, students receive a notice of admission.

  b) Installation Instructions:
      Just click "Clone or download" button on the top-left corner.
      Then choose "Download ZIP". And unpack ZIP-archive wherever you want.

  c) Instructions for launching the application:
      You should have installed Java and Maven on your local machine.
      Then in command prompt you have to write:
        1)cd [the path to directory where you unpacked ZIP-archive]
        2)mvn compile
        3)mvn clean install tomcat7: run
        4)write this url address prompt in your browser: http://localhost:8888/introductory-campaign/
