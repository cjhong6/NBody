The goal for this project is to write a program simulating the motion of 4 planets(Earth,Mars,Mercury,Venus) rotating around the Sun in a plane, accounting for the gravitational forces mutually affecting each planet as demonstrated by Sir Isaac Newton’s <a href="https://en.wikipedia.org/wiki/Newton%27s_law_of_universal_gravitation">Law of Universal Gravitation</a>.

Ultimately, I will be creating a program NBody.java that draws an animation of bodies floating around in space tugging on each other with the power of gravity.

Things I did well:
1. I found unit testing is really helpful. It ensure every method/function that I created bahaved correctly. Especially designing Body instance method/function, I used unit testing for every method/function because each method/function is using previous defined method/function/equation's answer to calculate certain value(force,acceleration,distance,velocity). Unt testing ensure the number that I calculated is correct before moving on the to the next equation.
2. I designed the program in a grphical interface. It has visual presentation for the planet's trajectory. In the back end, it's all scientific number and physic equation. Present it in grphical user interface and use animation has made my program very easy to see and understand.
3. Last but not least, I learned about physic, Newton's Law. It is fun to know about 
 a.We can break up force, acceleration and velocity into x and y. 
 b.Excerting force on something will change its accleration. Change of the acceleration will cause change of the velocity(speed). Changed of velocity will cause change of position. This chain reaction is interesting!
 
Things I can improve:
1. Planet is flickering on the screen everytime its position update because the program will redraw the background on top of the old drawing(planet's previous location) and redraw the new location of all planet.
a. I ended up comment out the background redraw method/funtion. Planet will not flicker anymore but planet's previous location will stay on the screem.
2. To create the simulation, I discretized time. The idea is that at every discrete interval, I will be doing my calculations and once I have done my calculations for that time step, I will then update the values of planets and then redraw the universe.
a.Maybe I need to consult with a scientic to find a better solution.

To run the code you need to provide 3 command line arguments:
1. First argument is the total time to run the simluation
2. Second argument is the change of time
3. Third argument is filename: data/planets.txt

javac NBody.java
java NBody 157788000.0 25000.0 data/planets.txt
