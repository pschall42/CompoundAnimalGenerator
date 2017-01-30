# CompoundAnimalGenerator
Java application that generates random compound animals based on text data sources.

The program follows an MVC design pattern, showing a GUI that takes two inputs: the number you want to generate and how many animals you want compounded. Clicking on generate sends those variables to the control which then queries the model to generate the animals.

CAG.jar is the compiled Java binary. To run, download CAG.jar and the data folder, make certain they are beside each other in the directory you download them to. Then, run CAG.jar.

To add extra data sources, simply add .txt files to the data folder. Make certain that all entries are line separated. All duplicate entries are ignored, so don't worry about scanning all entries beforehand to make sure you aren't copying anything. All entries are case sensitive, so "dog", "Dog", and "dOg" are all counted as separate entries. To remove a data source, simply delete the text file.
