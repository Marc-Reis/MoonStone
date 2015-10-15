

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by reisma on 27.05.15.
 */

public class MoonStoneSlick2d //extends BasicGame
       // implements InputProviderListener
{
/*
    private int posX,posY = 100;

    private InputProvider inProvider;

    private Command ckeyLeft = new BasicCommand("left");
    private Command ckeyRight = new BasicCommand("right");

    private Command ckeyUp = new BasicCommand("up");
    private Command ckeyDown = new BasicCommand("down");

    private String message="";

    private Image imgFace;
    private SimpleDiagramRenderer imgMan;
    private String imgPathMarc = "res/MarcFreeMan.png";
    private String strWelcome = "Hello World!";

    public MoonStoneSlick2d(String gamename)
    {
        super(gamename);
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
    
        inProvider = new InputProvider(gc.getInput());
        inProvider.addListener(this);

        inProvider.bindCommand(new KeyControl(Input.KEY_LEFT), ckeyLeft);
        inProvider.bindCommand(new KeyControl(Input.KEY_RIGHT), ckeyRight);
        inProvider.bindCommand(new KeyControl(Input.KEY_UP), ckeyUp);
        inProvider.bindCommand(new KeyControl(Input.KEY_DOWN), ckeyDown);

        imgFace = new Image(imgPathMarc);

        ///imgMan = new SimpleDiagramRenderer(InkscapeLoader.load("res/NewTux.svg")); imgMan.render(g);
    }

    @Override
    public void update(GameContainer gc, int i) throws SlickException {}

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException
    {
        move();
        imgFace.setRotation(30.0f);
        imgFace.draw(posX, posY);
        g.drawString(strWelcome, posX, posY);


        g.drawString(message + "x:" + posX + ", y:" + posY, 50, 50);


    }

    public void move(){

        posX = inProvider.isCommandControlDown(ckeyLeft) ?  posX-1: posX;
        posX = inProvider.isCommandControlDown(ckeyRight) ?  posX+1: posX;

        posY = inProvider.isCommandControlDown(ckeyDown)?  posY+1: posY;
        posY = inProvider.isCommandControlDown(ckeyUp)?  posY-1: posY;

    }

    public static void main(String[] args)
    {
        try
        {
            AppGameContainer appgc;
            appgc = new AppGameContainer(new MoonStoneSlick2d("Simple Slick Game"));
            appgc.setDisplayMode(1980, 1024, false);
            appgc.start();
        }
        catch (SlickException ex)
        {
            Logger.getLogger(MoonStoneSlick2d.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void controlPressed(Command command) {

    }

    @Override
    public void controlReleased(Command command) {
        message = command.toString()+" pressed!";
    }

*/
}
