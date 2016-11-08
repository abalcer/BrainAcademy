Работа с консолью:

javac -d ./BrainAcademy/lesson1/out ./BrainAcademy/lesson1/src/com/brainacademy/lesson1/Main.java

java -classpath ./BrainAcademy/lesson1/out com.brainacademy.lesson1.Main


jar cfe hw.jar com.brainacademy.lesson1.Main -C ./BrainAcademy/lesson1/out . 

jar tf hw.jar

java -jar hw.jar 
