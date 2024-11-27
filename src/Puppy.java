
public class Puppy extends NPC {
    private boolean FetchBall = false; 

    public Puppy() {
        super("puppy", "A hideous puppy wags his tail.");
    }

    @Override
    public void talk() {
        if (FetchBall == false) {
            say("Hi! I'm an adorable puppy!");
            String[] options = {
                "Yes you are! Who's a good boy?",
                "Ew, no. You're actually kinda hideous."
            };
            getResponse(options);
        } else {
            
            say("Yip!");  
        }
    }

    @Override
    public void response(int option) {
       if (FetchBall == false) {
            switch (option) {
                case 1: 
                    say("I am! I'm a good boy!");
                    break;
                case 2: 
                    say("I am adorable! Why are you so mean?");
                    Game.print("The puppy bites you. You deserve it.");
                    break;
            }

           say("Hey! Wanna play fetch? Say yes! Say yes!");
            String[] options = {
                "Yes! I love fetch!",
                "No. I am a horrible person and don't like playing with puppies."
            };
            getResponse(options);
        } else {
            switch (option) {
                case 1: 
                    say("Yay! Fetch!");
                    FetchBall = true; 
                    Game.print("You now have the fetch ball.");
                    break;
                case 2: 
                    say("You're a bad person! I don't like you!");
                    Game.print("The puppy runs away and doesn't come back.");
                    break;
            }
        }
    }
}


