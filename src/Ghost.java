
public class Ghost extends NPC {
    public Ghost() {
        super("Ghost", "A translucent figure drifts silently, its hollow eyes staring into nothingness.");
    }

    @Override
    public void talk() {
    say("Boo! Welcome to my haunting grounds. Why are you here?");
    String[] options = {
    		"I got lost, sorry!",
            "I'm here to explore your secrets."
    };
    getResponse(options);
    }
    @Override
    public void response(int option) {
    switch(option) {
    case 1:
    say("Lost, you say? You humans always stumble where you're not supposed to.");
    break;
    case 2:
    say("Secrets? There are none, only despair. But beware, not all who seek them survive.");
    Game.print("I don't understand what you mean.");
    break;
    }
    }
    }
